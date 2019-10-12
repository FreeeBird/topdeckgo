package cn.mafangui.topdeckgo.entity;


import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel(value = "卡牌对象",description = "卡牌实体类")
@Entity
public class Card implements Serializable {
    // id
    @Id
    @GeneratedValue
    private Integer cardId;
    // 卡片名
    private String cardName;
    // 英文名
    private String cardEngName;
    // 卡牌职业
    private String cardClass;
    // 稀有度
    private String cardRarity;
    // 类型
    private String cardType;
    // 法力
    private Integer cardSpellPower;
    // 生命
    private Integer cardHealth;
    // 攻击
    private Integer cardAtk;
    //描述
    private String cardDescription;
    //图片地址
    private String cardImgUrl;
    //稀有度num
    private Integer cardRarityNum;

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardEngName='" + cardEngName + '\'' +
                ", cardClass='" + cardClass + '\'' +
                ", cardRarity='" + cardRarity + '\'' +
                ", cardSpellPower=" + cardSpellPower +
                ", cardHealth=" + cardHealth +
                ", cardAtk=" + cardAtk +
                ", cardDescription='" + cardDescription + '\'' +
                ", cardImgUrl='" + cardImgUrl + '\'' +
                ", cardRarityNum=" + cardRarityNum +
                '}';
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getCardRarityNum() {
        return cardRarityNum;
    }

    public void setCardRarityNum(Integer cardRarityNum) {
        this.cardRarityNum = cardRarityNum;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public String getCardImgUrl() {
        return cardImgUrl;
    }

    public void setCardImgUrl(String cardImgUrl) {
        this.cardImgUrl = cardImgUrl;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardEngName() {
        return cardEngName;
    }

    public void setCardEngName(String cardEngName) {
        this.cardEngName = cardEngName;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }

    public String getCardRarity() {
        return cardRarity;
    }

    public void setCardRarity(String cardRarity) {
        this.cardRarity = cardRarity;
    }

    public Integer getCardSpellPower() {
        return cardSpellPower;
    }

    public void setCardSpellPower(Integer cardSpellPower) {
        this.cardSpellPower = cardSpellPower;
    }

    public Integer getCardHealth() {
        return cardHealth;
    }

    public void setCardHealth(Integer cardHealth) {
        this.cardHealth = cardHealth;
    }

    public Integer getCardAtk() {
        return cardAtk;
    }

    public void setCardAtk(Integer cardAtk) {
        this.cardAtk = cardAtk;
    }

}
