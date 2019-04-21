package cn.mafangui.topdeckgo.controller;

import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.service.CardService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(value = "/card")
@Api(value = "卡牌信息管理",tags = "card - 卡牌信息")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     *
     * @param cardName
     * @return
     */
    @ApiOperation(value = "根据卡牌名获取卡牌信息",httpMethod = "GET",response = Card.class)
    @RequestMapping(value = "/getCardByCardName")
    public Card getCardByCardName(String cardName){
        return cardService.getCardByCardName(cardName);
    }

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @PostMapping(value = "/getAllCard")
    public List<Card> getAllCard(int pageNum,int pageSize){
        return cardService.getAllCard(pageNum,pageSize);
    }

    /**
     *
     * @param cardNum
     * @return
     */
    @RequestMapping(value = "/getRandomCard")
    public List<Card> getRandomCard(int cardNum){
        return cardService.getRandomCard(cardNum);
    }

    @Cacheable(value = "dayCard")
    @RequestMapping(value = "/getDayCard")
    public Card getDayCard(){
        Card card = cardService.getDayCard();
        return card;
    }


    @Cacheable(value = "ccc")
    @RequestMapping(value = "/ccc")
    public String getStringByCache(){
        String cn = getDayCard().getCardName();
        return cn;
    }

}
