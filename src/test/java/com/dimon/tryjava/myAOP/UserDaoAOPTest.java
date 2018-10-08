package com.dimon.tryjava.myAOP;

import com.dimon.tryjava.myAOP.springAOPDemo.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations = "/resource/spring-aspectj.xml")
public class UserDaoAOPTest {

    @Autowired
    UserDao userDao;

    @Test
    public void aspectJTest(){
        userDao.addUser();
    }

}
