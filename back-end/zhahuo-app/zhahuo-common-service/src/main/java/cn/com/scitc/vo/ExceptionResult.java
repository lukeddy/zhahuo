package cn.com.scitc.vo;

import cn.com.scitc.myexception.ZhahuoExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;
    public ExceptionResult(ZhahuoExceptionEnum exceptionEnum){
        this.status = exceptionEnum.getStatusCode();
        this.message = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}