package cn.mafangui.topdeckgo.exception;

import cn.mafangui.topdeckgo.response.AjaxResult;
import cn.mafangui.topdeckgo.response.MsgType;
import cn.mafangui.topdeckgo.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = CardException.class)
    @ResponseBody
    public AjaxResult defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception{
        logger.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
//        return e.getMessage();
        return new AjaxResult(2003,e.getMessage());
    }
}
