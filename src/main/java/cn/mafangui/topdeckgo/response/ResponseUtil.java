package cn.mafangui.topdeckgo.response;

import cn.mafangui.topdeckgo.response.AjaxResult;
import cn.mafangui.topdeckgo.response.MsgType;

public class ResponseUtil {

    public static AjaxResult<Object> success(Object object){
        return new AjaxResult<>(object);
    }

    public static AjaxResult failed(MsgType msgType){
        return new AjaxResult(msgType.getCode(),msgType.getMessage());
    }

}
