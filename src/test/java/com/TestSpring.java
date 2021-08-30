package com;

import com.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void Test1() {
        // load config file.
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // get object.
        AccountService as = (AccountService) ac.getBean("accountService");
        // call function.
        as.findAll();
    }
}
