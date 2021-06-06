package com.pax.uptrillion.handler.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pax.uptrillion.handler.entity.PHICAccount;
import com.pax.uptrillion.handler.entity.UserJson;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * This class implement DAO by reading from Json file, have nothing to do with database or JPA.
 * Read from and write to json file only
 */
@Repository
public class PhicAccountDAOJsonImpl implements PhicAccountDAO{
    private UserJson theUserJson;
    private ObjectMapper mapper;

    public PhicAccountDAOJsonImpl() {
        try{
            //create object mapper
            mapper = new ObjectMapper();
            //read Json file and map/convert to Java POJO
            theUserJson = mapper.readValue(new File("./user.json"), UserJson.class);
        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    @Override
    public List<PHICAccount> getPhicAccounts() {
        return theUserJson.getPhicUsedList();
    }

    @Override
    public void savePhicAccount(PHICAccount phicAccount) {
        // add nothing if already there
        for (PHICAccount i : theUserJson.getPhicUsedList()){
            if(i.equals(phicAccount)) {
                return;
            }
        }
        theUserJson.getPhicUsedList().add(phicAccount);
        //write to json file
        try {
            mapper.writeValue(new File("./user.json"), theUserJson);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public PHICAccount getPhicAccount(String userName, String passWord, String serialNum) {
        for (PHICAccount i : theUserJson.getPhicUsedList()){
            if(i.getUsername().equals(userName) && i.getPassword().equals(passWord) && i.getSerialNum().equals(serialNum)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void deletePhicAccount(String userName, String passWord, String serialNum) {
        Iterator<PHICAccount> iterator = theUserJson.getPhicUsedList().iterator();
        while (iterator.hasNext()) {
            PHICAccount i = iterator.next();
            if(i.getUsername().equals(userName) && i.getPassword().equals(passWord) && i.getSerialNum().equals(serialNum)) {
                iterator.remove();
            }
        }
        //write to json file
        try {
            mapper.writeValue(new File("./user.json"), theUserJson);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
