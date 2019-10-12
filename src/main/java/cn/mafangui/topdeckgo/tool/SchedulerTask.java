package cn.mafangui.topdeckgo.tool;


import cn.mafangui.topdeckgo.controller.CardController;
import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.service.CardService;
import cn.mafangui.topdeckgo.service.impl.CardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *
 */
@Component
public class SchedulerTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardService cardService;
    @Autowired
    private RedisUtil redisUtil;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 24*60*60*1000)
    private void reportCurrentTime(){
        logger.info("Now time is: " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 24*60*60*1000)
    private void getDayCard(){
        redisUtil.del(CardServiceImpl.DAY_CARD);
        Card card = cardService.getDayCard();
        logger.info("Today Card is " + card.getCardName());
    }

}
