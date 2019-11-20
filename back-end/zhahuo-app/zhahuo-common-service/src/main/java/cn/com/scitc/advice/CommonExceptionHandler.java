package cn.com.scitc.advice;

import cn.com.scitc.myexception.MyException;
import cn.com.scitc.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionResult> handlerException(MyException e){
        return ResponseEntity.status(e.getExceptionEnum().getStatusCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }

}
