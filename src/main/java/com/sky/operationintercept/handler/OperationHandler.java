package com.sky.operationintercept.handler;

import com.sky.operationintercept.annotation.OperationLog;
import com.sky.operationintercept.config.OperationBehave;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by sk on 2022/4/28
 */
@Aspect
public class OperationHandler {

    private final ExpressionParser parser = new SpelExpressionParser();
    @Autowired
    OperationBehave operationBehave;

    @After("@annotation(operationLog)")
    public void afterExecute(JoinPoint joinPoint, OperationLog operationLog) {

        // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。
        Object[] argVals = joinPoint.getArgs(); // 参数值
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
        String value = operationLog.value();

        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < argNames.length; len++) {
            context.setVariable(argNames[len], argVals[len]);
        }
        String message = parser.parseExpression(value).getValue(context, String.class);

        operationBehave.AfterExecute(joinPoint,operationLog,argNames, argVals, message);
    }

}
