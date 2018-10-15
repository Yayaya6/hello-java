package com.dimon.tryjava.awaitility;

public class CounterServiceImpl implements CounterService {
    private volatile int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int index = 0; index < 5; index++) {
                        Thread.sleep(1000);
                        count += 1;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}