package cn.mafangui.topdeckgo.response;


/**
 * 消息类型描述
 */
public enum MsgType {
    SUCCESS(1000,"success"),
    FAILED(1001,"Failure"),

    PARAM_IS_INVALID(1100,"参数非法"),
    CARD_IS_NOT_FOUND(2001,"找不到相应卡牌"),


    ;
    private Integer code;
    private String message;
    MsgType() {
    }
    MsgType(Integer code) {
        this.code = code;
    }
    MsgType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
