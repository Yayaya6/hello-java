package com.dimon.tryjava.myAOP.springAOPDemo;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {
    @Override
    public int addUser() {
        System.out.println("add user ......");
        return 6666;
    }

    @Override
    public void updateUser() {
        System.out.println("update user ......");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user ......");
    }

    @Override
    public void findUser() {
        System.out.println("find user ......");
    }
}


//        本文来自 zejian_ 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/javazejian/article/details/56267036?utm_source=copy