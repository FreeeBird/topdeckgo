package cn.mafangui.topdeckgo.service.impl;

import cn.mafangui.topdeckgo.dao.CardDao;
import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.service.CardService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    @Override
    public List<Card> getAllCard(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return cardDao.findAllCard();
    }

    @Override
    public Card getCardByCardName(String cardName) {
        return cardDao.findByCardName(cardName);
    }

    @Override
    public List<Card> getRandomCard(int cardNum) {
        return cardDao.selectCardByRandom(cardNum);
    }

    @Override
    public Card getDayCard() {
        return cardDao.selectCardByRandom(1).get(0);
    }
}
