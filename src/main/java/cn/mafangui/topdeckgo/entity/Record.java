package cn.mafangui.topdeckgo.entity;


import java.sql.Time;
import java.util.Arrays;

public class Record {
    private long id;
    private int userId;
    private int cardId[];
    private int rarity;
    private Time createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getCardId() {
        return cardId;
    }

    public void setCardId(int[] cardId) {
        this.cardId = cardId;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userId=" + userId +
                ", cardId=" + Arrays.toString(cardId) +
                ", rarity=" + rarity +
                ", createTime=" + createTime +
                '}';
    }
}
