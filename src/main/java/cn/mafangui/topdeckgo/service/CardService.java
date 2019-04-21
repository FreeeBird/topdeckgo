package cn.mafangui.topdeckgo.service;

import cn.mafangui.topdeckgo.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    List<Card> getAllCard(int pageNum,int pageSize);

    Card getCardByCardName(String cardName);

    List<Card> getRandomCard(int cardNum);

    Card getDayCard();
}
