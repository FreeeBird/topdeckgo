package cn.mafangui.topdeckgo.service.impl;

import cn.mafangui.topdeckgo.dao.CardRepository;
import cn.mafangui.topdeckgo.dao.DayCardRepository;
import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.entity.CardRarity;
import cn.mafangui.topdeckgo.entity.DayCard;
import cn.mafangui.topdeckgo.service.CardService;
import cn.mafangui.topdeckgo.tool.MyDateTimeUtil;
import cn.mafangui.topdeckgo.tool.RedisUtil;
import cn.mafangui.topdeckgo.tool.WeightedChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    public final static String DAY_CARD = "day-card";

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DayCardRepository dayCardRepository;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Card> getAllCard() {
        return null;
    }

    @Override
    public Page<Card> getAllCard(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        if (!pageable.isPaged()) return null;
        return cardRepository.findAll(pageable);
    }

    @Override
    public Page<Card> getAllCard(Pageable pageable) {
        return cardRepository.findAll(pageable);
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
    public List<Card> getCardByClass(String cardClass) {
        return cardRepository.getAllByCardClass(cardClass);
    }

    @Override
    public List<Card> getCardByType(String cardType) {
        return cardRepository.getAllByCardType(cardType);
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
        if (redisUtil.hasKey(DAY_CARD)){
            return (Card) redisUtil.get(DAY_CARD);
        }
        DayCard dayCard = dayCardRepository.getLatestDayCard();
        if (MyDateTimeUtil.isToday(dayCard.getDate())){
            return cardRepository.findById(dayCard.getCardId()).get();
        }
        Card card =  cardRepository.getRandom(1).get(0);
        redisUtil.set(DAY_CARD,card);
        dayCard = new DayCard();
        dayCard.setCardId(card.getCardId());
        dayCard.setDate(new Date());
        dayCardRepository.save(dayCard);
        return card;
    }


    /**
     * 获取一个卡包
     * @return
     */
    @Override
    public List<Card> getASetCard() {
        // 稀有度卡牌数量数组
        int[] num = WeightedChoice.getARandomSet();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            // 按稀有度分别抽取对应数量的卡牌放入卡包
            cards.addAll(cardRepository.getRandomCardByRarity(num[i],i));
        }
        return cards;
    }

    @Override
    public Long getCount() {
        return cardRepository.count();
    }
}
