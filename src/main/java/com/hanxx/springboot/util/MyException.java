package com.hanxx.springboot.util;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 17:00 2017/11/7
 * @Description: <p>
 * <p> 自定义异常
 */
public class MyException extends Throwable {

    public  static String getMessage(ConstraintViolationException e){
        List<String> msg=new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation :e.getConstraintViolations()){
            msg.add(constraintViolation.getMessage());
        }
        String message= StringUtils.join(msg.toArray(),";");
        return message;
    }

}
