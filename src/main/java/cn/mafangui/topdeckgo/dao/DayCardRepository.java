package cn.mafangui.topdeckgo.dao;

import cn.mafangui.topdeckgo.entity.DayCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface DayCardRepository extends JpaRepository<DayCard, Integer> {

    /**
     * 从数据库找出最新的卡牌记录
     * @return
     */
    @Query(value = "select * from day_card order by date DESC limit 1",nativeQuery = true)
    DayCard getLatestDayCard();

}
