package cn.mafangui.topdeckgo;

import cn.mafangui.topdeckgo.controller.CardController;
import cn.mafangui.topdeckgo.dao.CardRepository;
import cn.mafangui.topdeckgo.entity.Card;
import cn.mafangui.topdeckgo.service.CardService;
import cn.mafangui.topdeckgo.tool.WeightedChoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopdeckgoApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	public void contextLoads() {

	}

}
