package com;

import com.dao.AccountDao;
import com.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    /**
     * test findAll() method.
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        // load config file.
        InputStream is = Resources.getResourceAsStream("applicationContext.xml");
        // creat a SqlSessionFactory object.
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // creat a SqlSession object.
        SqlSession session = factory.openSession();
        // get proxy object.
        AccountDao dao = session.getMapper(AccountDao.class);

        // find all player info.
        List<Account> list = dao.findAll();
        for(Account player : list) {
            System.out.println(player);
        }

        // close.
        session.close();
        is.close();
    }

    /**
     * test savePlayer() method.
     * @throws Exception
     */
    @Test
    public void testSavePlayer() throws Exception {
        // load config file.
        InputStream is = Resources.getResourceAsStream("applicationContext.xml");
        // creat a SqlSessionFactory object.
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // creat a SqlSession object.
        SqlSession session = factory.openSession();
        // get proxy object.
        AccountDao dao = session.getMapper(AccountDao.class);

        // creat a test player to save
        Account player = new Account();
        player.setPlayer_name("dummy4");
        player.setPassword("123456");
        player.setManagement_status(false);

        // save player.
        dao.insert(player);
        // commit transaction
        session.commit();
    }

}
