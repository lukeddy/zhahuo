package cn.com.scitc.myexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends  RuntimeException {
    private ZhahuoExceptionEnum exceptionEnum;
}
