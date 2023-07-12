package com.antra.webapi.entity;

import java.util.Date;

public class Transaction {
    private Integer user_id;
    private Integer purchase;
    private Date date;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(Integer user_id, Integer purchase, Date date) {
        this.user_id = user_id;
        this.purchase = purchase;
        this.date = date;
    }
}
