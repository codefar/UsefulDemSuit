package com.meituan.davy.myapplication.db.entity.tomany;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

@Entity
public class OrderExt {
    @Id private Long id;
    private Date date;
    private long customerId;
    @Generated(hash = 267530688)
    public OrderExt(Long id, Date date, long customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }
    @Generated(hash = 1165813706)
    public OrderExt() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}