package com.dimon.tryjava.myDateTime;

import java.text.ParseException;

/**
 * Created by limeng on 2018/10/3.
 */
public class UnsafeDateUtilsTest {
    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    System.out.println(this.getName() + ":" + UnsafeDateUtils.parse("2018-06-20 01:18:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new TestSimpleDateFormatThreadSafe().start();
        }
    }
}
