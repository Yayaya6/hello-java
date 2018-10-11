package com.dimon.tryjava.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntTest {

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(10);
        System.out.println("初始值: " + atomicInt.get()); // 10

        System.out.println("前自增: " + atomicInt.incrementAndGet()); // 11
        System.out.println("前自减: " + atomicInt.decrementAndGet()); // 10
        System.out.println("后自增: " + atomicInt.getAndIncrement()); // 10
        System.out.println("后自减: " + atomicInt.getAndDecrement()); // 11
        System.out.println("当前值: " + atomicInt.get());             // 10

        System.out.println("前更新: " + atomicInt.updateAndGet(v -> v + 10)); // 20
        System.out.println("后更新: " + atomicInt.getAndUpdate(v -> v - 10)); // 20
        System.out.println("当前值: " + atomicInt.get());                     // 10

        System.out.println("前累加: " + atomicInt.accumulateAndGet(10, (x, y) -> x + y)); // 20
        System.out.println("后累加: " + atomicInt.getAndAccumulate(10, (x, y) -> x + y)); // 20
        System.out.println("当前值: " + atomicInt.get());                                 // 30
    }

}
