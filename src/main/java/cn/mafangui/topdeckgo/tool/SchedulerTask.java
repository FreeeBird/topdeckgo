package cn.mafangui.topdeckgo.tool;


import cn.mafangui.topdeckgo.controller.CardController;
import cn.mafangui.topdeckgo.entity.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardController cardController;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 24*60*60*6000)
    private void reportCurrentTime(){
        logger.info("Now time is: " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 24*60*60*6000)
    private void getDayCard(){
        Card card = cardController.getDayCard();
        logger.info("Today Card is " + "sd");
    }

}
