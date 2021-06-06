package com.pax.uptrillion.handler.service;

import com.pax.uptrillion.handler.dao.PhicAccountDAO;
import com.pax.uptrillion.handler.entity.PHICAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhicAccountServiceJsonImpl implements PhicAccountService{

    @Autowired
    private PhicAccountDAO phicAccountDAO;

    @Override
    public List<PHICAccount> getPhicAccounts() {
        return phicAccountDAO.getPhicAccounts();
    }

    @Override
    public void savePhicAccount(PHICAccount phicAccount) {
        phicAccountDAO.savePhicAccount(phicAccount);
    }

    @Override
    public PHICAccount getPhicAccount(String userName, String passWord, String serialNum) {
        return phicAccountDAO.getPhicAccount(userName,passWord,serialNum);
    }

    @Override
    public void deletePhicAccount(String userName, String passWord, String serialNum) {
        phicAccountDAO.deletePhicAccount(userName, passWord, serialNum);
    }
}
