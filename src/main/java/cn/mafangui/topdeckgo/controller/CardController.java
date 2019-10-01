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


//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;

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
    @ApiOperation(value = "根据卡牌名获取卡牌信息",httpMethod = "GET",response = Card.class)
    @RequestMapping(value = "/name/{cardName}")
    public AjaxResult getCardByCardName(@PathVariable String cardName) throws CardException {
        Card card = cardService.getByCardName(cardName);
        if (card == null){
            return ResponseUtil.failed(MsgType.CARD_IS_NOT_FOUND);
        }
        return ResponseUtil.success(card);
    }

    @ApiOperation(value = "根据卡牌英文名获取卡牌信息",httpMethod = "GET",response = Card.class)
    @RequestMapping(value = "/eng_name/{cardEngName}")
    public AjaxResult getCardByCardEngName(@PathVariable String cardEngName) throws CardException {
        Card card = cardService.getByCardEngName(cardEngName);
        if (card == null){
            return ResponseUtil.failed(MsgType.CARD_IS_NOT_FOUND);
        }
        return ResponseUtil.success(card);
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getAllCard")
    public List<Card> getAllCard(int pageNum,int pageSize){
        return cardService.getAllCard(pageNum,pageSize);
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
        return ResponseUtil.success(cardService.getAllCard(pageNum,pageSize));
    }

    /**
     * 随机获取卡片
     * @param cardNum
     * @return
     */
    @RequestMapping(value = "/getRandomCard")
    public AjaxResult getRandomCard(Integer cardNum){
        if (cardNum<=0||cardNum>1000){
            return ResponseUtil.failed(MsgType.PARAM_IS_INVALID);
        }
        return ResponseUtil.success(cardService.getRandomCard(cardNum));
    }

//    @Cacheable(value = "dayCard")

    /**
     * 获取每日一卡
     * @return
     */
    @RequestMapping(value = "/getDayCard")
    public Card getDayCard(){
        Card card = cardService.getDayCard();
        return card;
    }

    /**
     *  抽卡包
     * @return
     */
    @RequestMapping(value = "/draw")
    public AjaxResult drawASetOfCard(){
        return ResponseUtil.success(cardService.getASetCard());
    }


}
