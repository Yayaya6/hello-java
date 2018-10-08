package com.dimon.tryjava.myCollection.myQueue.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest0 {

    public static void main(String[] args) {
        PriorityQueue<Integer> qi = new PriorityQueue<Integer>();
        qi.add(5);
        qi.add(2);
        qi.add(1);
        qi.add(10);
        qi.add(3);
        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + ",");
        }
        System.out.println();
        //采用降序排列的方式，越小的越排在队尾
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
        q2.add(2);
        q2.add(8);
        q2.add(9);
        q2.add(1);
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + ",");
        }

//    链接：https://www.jianshu.com/p/35760d7bac0d

    }
}
