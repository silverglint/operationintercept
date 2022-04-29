package com.sky.operationintercept.config;

import com.sky.operationintercept.annotation.OperationLog;
import org.aspectj.lang.JoinPoint;

/**
 * Created by sk on 2022/4/28
 */
public class OperationBehave {

    public void AfterExecute(JoinPoint joinPoint, OperationLog operationLog, String[] argNames, Object[] argVals, String message) {
        System.out.println(message);
    }
}
