package com.dimon.tryjava.awaitility;

import org.junit.Assert;
import static java.util.concurrent.TimeUnit.*;
import static org.awaitility.Awaitility.*;
import static org.awaitility.Duration.*;
import static org.awaitility.pollinterval.FibonacciPollInterval.*;

import com.dimon.tryjava.utils.DateTimeUtil;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AwaitilityTest {

    @Test
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
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousAtMost() {
        final CounterService service = new CounterServiceImpl();
        service.run();
        try {
            // 指定超时时间3s, 如果在这时间段内,条件依然不满足,将抛出ConditionTimeoutException
            await().atMost(6, SECONDS).until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return service.getCount() == 5;
                }
            });
        } catch (Exception e) {
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousAtLeast() {

        final CounterService service = new CounterServiceImpl();
        service.run();

        try {
            // 指定至少1s, 最多3s, 如果在这时间段内,条件依然不满足,将抛出ConditionTimeoutException
            await().atLeast(1, SECONDS).and().atMost(3, SECONDS).until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return service.getCount() == 2;
                }
            });

        } catch (Exception e) {
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());

        }
    }

//    await().forever().until(new Callable<Boolean>() {
//        @Override
//        public Boolean call() throws Exception {
//            return service.getCount() == 6;
//        }
//    });

    @Test
    public void testAsynchronousPoll() {
        final CounterService service = new CounterServiceImpl();
        service.run();
        try {
            // 轮询查询,pollInterval每隔多少时间段轮询, pollDelay每次轮询间隔时间
            with().pollInterval(ONE_HUNDRED_MILLISECONDS).and().with().pollDelay(500, MILLISECONDS)
                    .await("count is greater 3").until(
                    new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return service.getCount() == 4;
                        }
                    });
        } catch (Exception e) {
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testAsynchronousFibonacciPoll() {
        final CounterService service = new CounterServiceImpl();
        service.run();
        try {
            // 使用fibonacci数作为间隔数1,1,2,3,5,8,..., 默认单位milliseconds
            with().pollInterval(fibonacci(SECONDS)).await("count is greater 3").atMost(1000, SECONDS).until(
                    new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println(DateTimeUtil.getCurrentUTCTimeString());
                            return service.getCount() == 100;
                        }
                    });
        } catch (Exception e) {
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }

    @Test
    public void testPollDelayAndPollInterval() {
        final CounterService service = new CounterServiceImpl();
        service.run();
        try {
            System.out.println(DateTimeUtil.getCurrentUTCTimeString());
            // 轮询查询,pollInterval每隔多少时间段轮询, pollDelay每次轮询间隔时间
            with().pollInterval(TWO_SECONDS).and()
                    .
                            with().pollDelay(3, SECONDS)
                    .await("count is greater 3").atMost(1000, SECONDS).until(
                    new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println(DateTimeUtil.getCurrentUTCTimeString());
                            return service.getCount() == 100;
                        }
                    });
        } catch (Exception e) {
            Assert.fail("测试代码运行异常：" + e.getMessage() + "，代码位置：" + e.getStackTrace()[0].toString());
        }
    }

}

