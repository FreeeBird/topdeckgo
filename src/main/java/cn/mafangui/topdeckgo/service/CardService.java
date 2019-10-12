package cn.mafangui.topdeckgo.service;

import cn.mafangui.topdeckgo.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    List<Card> getAllCard();

    Page<Card> getAllCard(int pageNum, int pageSize);

    Page<Card> getAllCard(Pageable pageable);

    Card getByCardName(String cardName);

    Card getByCardEngName(String engName);

    List<Card> getCardByClass(String cardClass);

    List<Card> getCardByType(String cardType);

    Card getById(Integer id);

    List<Card> getRandomCard(int cardNum);

    List<Card> getRandomCard(int cardNum,String cardRarity);

    Card getDayCard();

    List<Card> getASetCard();

    Long getCount();
}
