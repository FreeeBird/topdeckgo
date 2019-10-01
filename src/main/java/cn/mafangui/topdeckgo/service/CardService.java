package cn.mafangui.topdeckgo.service;

import cn.mafangui.topdeckgo.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    List<Card> getAllCard(int pageNum,int pageSize);

    Card getByCardName(String cardName);

    Card getByCardEngName(String engName);

    Card getById(Integer id);

    List<Card> getRandomCard(int cardNum);

    List<Card> getRandomCard(int cardNum,String cardRarity);

    Card getDayCard();

    List<Card> getASetCard();
}
