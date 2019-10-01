package cn.mafangui.topdeckgo.dao;

import cn.mafangui.topdeckgo.entity.DayCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DayCardRepository extends JpaRepository<DayCard, Integer> {

    @Query(value = "select * from day_card order by date limit 1",nativeQuery = true)
    DayCard getLatestDayCard();

}
