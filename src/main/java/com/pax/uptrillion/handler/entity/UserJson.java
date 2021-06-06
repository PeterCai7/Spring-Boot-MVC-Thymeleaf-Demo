package com.pax.uptrillion.handler.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//Java Annotations, tell Jackson to ignore unknown properties which are not defined here
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserJson {
    private List<PHICAccount> phicUsedList;
    private List<PHICAccount> phicUnusedList;

    public List<PHICAccount> getPhicUsedList() {
        return phicUsedList;
    }

    public void setPhicUsedList(List<PHICAccount> phicUsedList) {
        this.phicUsedList = phicUsedList;
    }

    public List<PHICAccount> getPhicUnusedList() {
        return phicUnusedList;
    }

    public void setPhicUnusedList(List<PHICAccount> phicUnusedList) {
        this.phicUnusedList = phicUnusedList;
    }

}