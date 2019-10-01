package cn.mafangui.topdeckgo.dao;

import cn.mafangui.topdeckgo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardRepository extends JpaRepository< Card,Integer> {
    Card getByCardName(String cardName);
    Card getByCardEngName(String engName);
    List<Card> getAllByCardClass(String cardClass);
    List<Card> getAllByCardType(String cardType);
//    @Query(value = "select * from card where card_id >= " +
//            "(select floor(RAND()*(select MAX(card_id) from card)))" +
//            " order by card_id limit 1",nativeQuery = true)
//    Card getRandomOne();
    @Query(value = "SELECT * FROM card ORDER BY RAND() LIMIT ?1 ",nativeQuery = true)
    List<Card> getRandom(int num);
    @Query(value = "SELECT * FROM card where card_rarity_num=?2 ORDER BY RAND() LIMIT ?1 ",nativeQuery = true)
    List<Card> getRandomCardByRarity(Integer num,Integer cardRarityNum);

}
