package com.dimon.tryjava.myAOP.springAOPDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/testaop", method = RequestMethod.GET)
    public String testUserDao() {
        userDao.addUser();
        return "TestController testUserDao method invoke";
    }

}
