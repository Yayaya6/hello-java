package com.dimon.tryjava.myThread.producerAndConsumer;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ProAndConWithCondition {
    public static void main(String[] args) {
        Godown godown = new Godown();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                godown.put(i);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++)
                godown.get();
        }).start();
    }
}

// 仓库
class Godown {
    // 产品
    private static class Product {
        private int id;
        public Product(int id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return "(产品名: 吊牌洗衣粉" + ", 产品编号: " + id + ")";
        }
    }

    private ReentrantLock lock = new ReentrantLock(); // 非公平锁
    private Condition condProduce = lock.newCondition(); // 生产队列
    private Condition condConsume = lock.newCondition(); // 消费队列
    private Product product; // 当前产品
    private boolean isProduced = false; // 标识产品已生产

    // 生产产品
    public void put(int id) {
        lock.lock();
        try {
            while (isProduced) { // 如果有产品
                try {
                    condConsume.signalAll(); // 通知消费者
                    condProduce.await(); // 进入生产队列等待
                } catch (InterruptedException e) {
                    // TODO
                }
            }
            isProduced = true;
            product = new Product(id);
            System.out.println("[生产了一个产品] -> " + product);
            condConsume.signalAll(); // 通知消费者
        } finally {
            lock.unlock();
        }
    }

    // 消费产品
    public void get() {
        lock.lock();
        try {
            while (!isProduced) { // 如果没有产品
                try {
                    condProduce.signalAll(); // 通知生产者
                    condConsume.await(); // 进入消费队列等待
                } catch (InterruptedException e) {
                    // TODO
                }
            }
            isProduced = false;
            System.out.println("[消费了一个产品] -> " + product);
            product = null;
            condProduce.signalAll(); // 通知生产者
        } finally {
            lock.unlock();
        }
    }
}
