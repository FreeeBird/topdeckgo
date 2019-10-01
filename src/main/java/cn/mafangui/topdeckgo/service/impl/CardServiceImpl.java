package cn.mafangui.topdeckgo.service.impl;

import cn.mafangui.topdeckgo.dao.CardRepository;
import cn.mafangui.topdeckgo.dao.DayCardRepository;
import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.entity.CardRarity;
import cn.mafangui.topdeckgo.entity.DayCard;
import cn.mafangui.topdeckgo.service.CardService;
import cn.mafangui.topdeckgo.tool.WeightedChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DayCardRepository dayCardRepository;

    @Override
    public List<Card> getAllCard(int pageNum,int pageSize) {
        return cardRepository.findAll();
    }

    /**
     * 根据名字获取卡牌
     * @param cardName
     * @return
     */
    @Override
    public Card getByCardName(String cardName) {
        return cardRepository.getByCardName(cardName);
    }

    /**
     * 根据 英文名 获取卡牌
     * @param engName
     * @return
     */
    @Override
    public Card getByCardEngName(String engName) {
        return cardRepository.getByCardEngName(engName);
    }

    @Override
    public Card getById(Integer id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.orElse(null);
    }

    /**
     * 随机抽取 cardNum 张卡牌
     * @param cardNum
     * @return
     */
    @Override
    public List<Card> getRandomCard(int cardNum) {
        return cardRepository.getRandom(cardNum);
    }

    /**
     *  随机抽取 cardNum 张稀有度为cardRarity的卡牌
     * @param cardNum
     * @param cardRarity
     * @return
     */
    @Override
    public List<Card> getRandomCard(int cardNum, String cardRarity) {
        return cardRepository.getRandomCardByRarity(cardNum, CardRarity.getCardRarityNumByRarity(cardRarity));
    }

    /**
     * 获取每日卡牌
     * @return
     */
    @Override
    public Card getDayCard() {
//        DayCard card = dayCardRepository.
        return null;
    }


    @Override
    public List<Card> getASetCard() {
        int[] num = WeightedChoice.getARandomSet();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            cards.addAll(cardRepository.getRandomCardByRarity(num[i],i));
        }
        return cards;
    }
}
