package cn.mafangui.topdeckgo;


import cn.mafangui.topdeckgo.controller.CardController;
import cn.mafangui.topdeckgo.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    @Autowired
    private CardController cardController;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 24*60*60*6000)
    private void reportCurrentTime(){
        System.out.println("Now time is: " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 24*60*60*6000)
    private void getDayCard(){
        Card card = cardController.getDayCard();
        System.out.println("Today Card is " + card.getCardName());
    }

}
