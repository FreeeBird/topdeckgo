package cn.mafangui.topdeckgo.controller;

import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.exception.CardException;
import cn.mafangui.topdeckgo.response.MsgType;
import cn.mafangui.topdeckgo.service.CardService;
import cn.mafangui.topdeckgo.response.AjaxResult;
import cn.mafangui.topdeckgo.response.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
@Api(value = "卡牌信息管理",tags = "card - 卡牌信息")
public class CardController {

    private static Logger logger = LoggerFactory.getLogger(CardController.class);
    @Autowired
    private CardService cardService;


    /**
     * 根据ID号获取卡牌信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID号获取卡牌信息",httpMethod = "GET",response = AjaxResult.class)
    @RequestMapping(value = "/{id}")
    public AjaxResult getCardById(@PathVariable Integer id){
        Card card = cardService.getById(id);
        if (card == null){
            return ResponseUtil.failed(MsgType.CARD_IS_NOT_FOUND);
        }
        return ResponseUtil.success(card);
    }

    /**
     *
     * @param cardName
     * @return
     */
    @ApiOperation(value = "根据卡牌名获取卡牌信息",httpMethod = "GET",response = AjaxResult.class)
    @RequestMapping(value = "/name/{cardName}")
    public AjaxResult getCardByCardName(@PathVariable String cardName) {
        Card card = cardService.getByCardName(cardName);
        if (card == null){
            return ResponseUtil.failed(MsgType.CARD_IS_NOT_FOUND);
        }
        return ResponseUtil.success(card);
    }

    @ApiOperation(value = "根据卡牌英文名获取卡牌信息",httpMethod = "GET",response = AjaxResult.class)
    @RequestMapping(value = "/eng_name/{cardEngName}")
    public AjaxResult getCardByCardEngName(@PathVariable String cardEngName) {
        Card card = cardService.getByCardEngName(cardEngName);
        if (card == null){
            return ResponseUtil.failed(MsgType.CARD_IS_NOT_FOUND);
        }
        return ResponseUtil.success(card);
    }

    @ApiOperation(value = "获取分页数",response = AjaxResult.class)
    @RequestMapping(value = "/page")
    public AjaxResult getCount(Integer pageSize){
        if (null == pageSize||pageSize<=0){
            logger.error(MsgType.PARAM_IS_INVALID.getMessage());
            return ResponseUtil.failed(MsgType.PARAM_IS_INVALID);
        }
        int pageNum = (int) Math.ceil(cardService.getCount()*1.0 / pageSize);
        return ResponseUtil.success(pageNum);
    }

    /**
     * 获取全部卡牌
     * @return
     */
    @ApiOperation(value = "获取全部卡牌",response = AjaxResult.class)
    @RequestMapping(value = "/all")
    public AjaxResult getAllCard() {
        List<Card> cards = cardService.getAllCard();
        return ResponseUtil.success(cards);
    }

    /**
     * 根据页数，分页大小获取卡片
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页获取卡牌信息",httpMethod = "GET",response = AjaxResult.class)
    @RequestMapping(value = "")
    public AjaxResult getAllCards(Integer pageNum, Integer pageSize) {
        Pageable pageable;
        try{
            pageable = PageRequest.of(pageNum,pageSize);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseUtil.failed(e.getMessage());
        }
        List<Card> cards = cardService.getAllCard(pageable).getContent();
        return ResponseUtil.success(cards);
    }

    /**
     * 随机获取卡片
     * @param cardNum
     * @return
     */
    @ApiOperation(value = "随机获取卡片",response = AjaxResult.class)
    @RequestMapping(value = "/getRandomCard")
    public AjaxResult getRandomCard(Integer cardNum){
        if (cardNum<=0||cardNum>1000){
            return ResponseUtil.failed(MsgType.PARAM_IS_INVALID);
        }
        return ResponseUtil.success(cardService.getRandomCard(cardNum));
    }

    /**
     * 获取每日一卡
     * @return
     */
    @ApiOperation(value = "获取每日一卡",response = AjaxResult.class)
    @RequestMapping(value = "/getDayCard")
    public AjaxResult getDayCard(){
        return ResponseUtil.success(cardService.getDayCard());
    }
    /**
     *  抽卡包(5张卡牌)
     * @return
     */
    @ApiOperation(value = "抽卡包",response = AjaxResult.class)
    @RequestMapping(value = "/draw")
    public AjaxResult drawASetOfCard(){
        return ResponseUtil.success(cardService.getASetCard());
    }


}
