package com.dimon.tryjava.myAwaitility;

import java.util.concurrent.Callable;
import com.dimon.testy.javatry.myAwaitility.CounterServiceImpl;

public class AwaitilityTry {
    public void testAsynchronousNormal() {
        final CounterService service = new CounterServiceImpl();
        service.run();
        try {
            // 默认10s, 如果在这时间段内,条件依然不满足,将抛出ConditionTimeoutException
            await().until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return service.getCount() == 5;
                }
            });
        } catch (Exception e) {
            System.out.println("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }
}