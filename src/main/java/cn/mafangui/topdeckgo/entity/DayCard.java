package cn.mafangui.topdeckgo.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@ApiModel(value = "每日卡牌",description = "每日卡牌信息")
@Entity
public class DayCard {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;
    private Integer cardId;

    public DayCard() {
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "DayCard{" +
                "id=" + id +
                ", date=" + date +
                ", cardId=" + cardId +
                '}';
    }
}
