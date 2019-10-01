package cn.mafangui.topdeckgo.entity;

public enum CardRarity {

    FREE(0,"免费"),
    COMMON(1,"普通"),
    RARE(2,"稀有"),
    EPIC(3,"史诗"),
    LEGEND(4,"传说"),
    ;

    private Integer cardRarityNum;
    private String cardRarity;

    CardRarity(Integer cardRarityNum, String cardRarity) {
        this.cardRarityNum = cardRarityNum;
        this.cardRarity = cardRarity;
    }

    /**
     * 根据 稀有度描述 获取 稀有度值
     * @param cardRarity
     * @return
     */
    public static Integer getCardRarityNumByRarity(String cardRarity){
        for (CardRarity c: CardRarity.values()) {
            if (c.getCardRarity().equals(cardRarity)) return c.getCardRarityNum();
        }
        return 0;
    }

    /**
     * 根据 稀有度值 获取 稀有度描述
     * @param cardRarityNum
     * @return
     */
    public static String getCardRarityByRarityNum(Integer cardRarityNum){
        for (CardRarity c: CardRarity.values()) {
            if (c.getCardRarityNum()==cardRarityNum) return c.getCardRarity();
        }
        return FREE.getCardRarity();
    }



    public Integer getCardRarityNum() {
        return cardRarityNum;
    }

    public void setCardRarityNum(Integer cardRarityNum) {
        this.cardRarityNum = cardRarityNum;
    }

    public String getCardRarity() {
        return cardRarity;
    }

    public void setCardRarity(String cardRarity) {
        this.cardRarity = cardRarity;
    }

}
