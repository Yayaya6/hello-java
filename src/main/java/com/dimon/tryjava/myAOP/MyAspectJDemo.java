package com.dimon.tryjava.myAOP;

/*
public aspect MyAspectJDemo {
        */
/**
         * 定义切点,日志记录切点
         *//*

        pointcut recordLog():call(* HelloWord.sayHello(..));

        */
/**
         * 定义切点,权限验证(实际开发中日志和权限一般会放在不同的切面中,这里仅为方便演示)
         *//*

        pointcut authCheck():call(* HelloWord.sayHello(..));

        */
/**
         * 定义前置通知!
         *//*

        before():authCheck(){
        System.out.println("sayHello方法执行前验证权限");
        }

        */
/**
         * 定义后置通知
         *//*

        after():recordLog(){
        System.out.println("sayHello方法执行后记录日志");
        }
        }
*/


//        本文来自 zejian_ 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/javazejian/article/details/56267036?utm_source=copy