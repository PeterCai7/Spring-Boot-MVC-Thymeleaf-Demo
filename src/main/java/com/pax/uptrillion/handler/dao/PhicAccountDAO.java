package com.pax.uptrillion.handler.dao;

import com.pax.uptrillion.handler.entity.PHICAccount;

import java.util.List;

public interface PhicAccountDAO {
    public List<PHICAccount> getPhicAccounts();

    public void savePhicAccount(PHICAccount phicAccount);

    public PHICAccount getPhicAccount(String userName, String passWord, String serialNum);

    public void deletePhicAccount(String userName, String passWord, String serialNum);
}
