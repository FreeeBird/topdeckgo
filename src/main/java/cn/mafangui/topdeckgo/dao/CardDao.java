package cn.mafangui.topdeckgo.dao;

import cn.mafangui.topdeckgo.entity.Card;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CardDao {


    @Insert("insert into t_card values(#{cardName},#{cardEngName},#{cardClass},#{cardRarity},#{cardType},#{cardSpellPower},#{cardHealth}" +
            ",#{cardSkill},#{cardDescription},#{cardImgUrl})")
    int addCard(Card card);


    int updateCard(Card card);

    @Delete("delete from t_card where card_name=#{cardName}")
    int deleteCard(String cardName);

    @Select("select * from t_card where card_name=#{cardName}")
    Card findByCardName(String cardName);

    @Select("select * from t_card")
    List<Card> findAllCard();

    @Select("SELECT * FROM t_card  ORDER BY  RAND() LIMIT #{cardNum}")
    Card selectCardByRandom(int cardNum);
}
