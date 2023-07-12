package com.antra.webapi.entity;

import java.util.Date;

public class Transaction {
    private Integer id;
    private Integer purchase;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Transaction(Integer id, Integer purchase, Date date) {
        this.id = id;
        this.purchase = purchase;
        this.date = date;
    }
}
