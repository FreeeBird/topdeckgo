package cn.mafangui.topdeckgo.controller;

import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.service.CardService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/getCardByCardName")
    public Card getCardByCardName(String cardName){
        return cardService.getCardByCardName(cardName);
    }

    @PostMapping(value = "/getAllCard")
    public List<Card> getAllCard(int pageNum,int pageSize){
        return cardService.getAllCard(pageNum,pageSize);
    }

    @RequestMapping(value = "/getRandomCard")
    public List<Card> getRandomCard(int cardNum){
        return cardService.getRandomCard(cardNum);
    }

}
