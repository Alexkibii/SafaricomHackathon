package com.example.a52weekschallenge.models;

import android.arch.lifecycle.ViewModel;

import com.orm.SugarRecord;

public class WeekModel extends SugarRecord {


    private int week;
    private long amount;
    private long total;

    public WeekModel() {
    }

    public WeekModel(int week, long amount, long total) {
        this.week = week;
        this.amount = amount;
        this.total = total;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
