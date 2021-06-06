package com.pax.uptrillion.handler.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Java Annotations, tell Jackson to ignore unknown properties which are not defined here
@JsonIgnoreProperties(ignoreUnknown = true)
public class PHICAccount {
    private String username;
    private String password;
    private String serialNum;
    private String processor;

    //not used yet
    //private String posID;

    private Status status;

    //For Jackson Project to use
    public PHICAccount() {

    }

    public PHICAccount(String username, String password, String serialNum) {
        this.username = username;
        this.password = password;
        this.serialNum = serialNum;
        //this.posID = posID;
        // set status to READY whenever someone calls new PHICAccount(...)
        status = Status.READY;
    }

    // define our own equals method
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PHICAccount) {
            PHICAccount outter = (PHICAccount) obj;
            return outter.getUsername().equals(username)
                    && outter.getPassword().equals(password)
                    && outter.getSerialNum().equals(serialNum);
        } else {
            return false;
        }
    }
    @Override
    public String toString(){
        return "{ Username: " + this.username
                + ", Password: " + this.password
                + ", SerialNumber: " + this.serialNum
                + "}";
    }



    public String getSerialNum() {
        return serialNum;
    }

    public String getProcessor() {
        return processor;
    }

    public Status getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
enum Status {
    RUNNING, READY, INVALID
}