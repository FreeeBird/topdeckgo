package cn.mafangui.topdeckgo.entity;


import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "卡牌对象",description = "卡牌实体类")
public class Card implements Serializable {
    // id
    private int cardId;
    // 卡片名
    private String cardName;
    // 英文名
    private String cardEngName;
    // 卡牌职业
    private String cardClass;
    // 稀有度
    private String cardRarity;
    // 法力
    private int cardSpellPower;
    // 生命
    private int cardHealth;
    // 攻击
    private int cardAtk;
    //描述
    private String cardDescription;
    //图片地址
    private String cardImgUrl;
    //稀有度num
    private int cardRarityNum;

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

    public int getCardRarityNum() {
        return cardRarityNum;
    }

    public void setCardRarityNum(int cardRarityNum) {
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
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

    public int getCardSpellPower() {
        return cardSpellPower;
    }

    public void setCardSpellPower(int cardSpellPower) {
        this.cardSpellPower = cardSpellPower;
    }

    public int getCardHealth() {
        return cardHealth;
    }

    public void setCardHealth(int cardHealth) {
        this.cardHealth = cardHealth;
    }

    public int getCardAtk() {
        return cardAtk;
    }

    public void setCardAtk(int cardAtk) {
        this.cardAtk = cardAtk;
    }

}
