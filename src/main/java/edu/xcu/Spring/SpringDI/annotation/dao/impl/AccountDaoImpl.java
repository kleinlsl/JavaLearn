package edu.xcu.Spring.SpringDI.annotation.dao.impl;

import edu.xcu.Spring.SpringDI.annotation.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author: dell
 * @date: 2020/8/7 - 14:57
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("账户已被保存！！！");
    }
}
