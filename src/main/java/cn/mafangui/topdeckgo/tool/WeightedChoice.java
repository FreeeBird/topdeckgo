package cn.mafangui.topdeckgo.tool;

import cn.mafangui.topdeckgo.entity.CardRarity;

import java.util.Random;

/**
 *  按概率抽取
 */
public class WeightedChoice {

    private static final int FREE = CardRarity.FREE.getCardRarityNum();
    // 普通 白卡
    private static final int COMMON = CardRarity.COMMON.getCardRarityNum();
    // 稀有 蓝卡
    private static final int RARE = CardRarity.RARE.getCardRarityNum();
    // 史诗 紫卡
    private static final int EPIC = CardRarity.EPIC.getCardRarityNum();
    // 传说 橙卡
    private static final int LEGEND = CardRarity.LEGEND.getCardRarityNum();
    private static final Integer[] WEIGHTS = new Integer[]{4,41,245,710};
    private static final Integer[] ID = new Integer[]{LEGEND,EPIC,RARE,COMMON};

    public static int randomChoice(){
        int sumOfWeight = 0;
        for (Integer weight : WEIGHTS) {
            sumOfWeight += weight;
        }
        Random random = new Random();
        int randNumber = random.nextInt(sumOfWeight);
        for (int i = 0; i < WEIGHTS.length; i++) {
            if (randNumber<WEIGHTS[i]) return ID[i];
            randNumber -= WEIGHTS[i];
        }
        return FREE;
    }

    public static int[] getARandomSet(){
        int[] sum = new int[5];
        for (int i = 0; i < 5; i++) {
            sum[randomChoice()]++;
        }
        return sum;
    }


}
