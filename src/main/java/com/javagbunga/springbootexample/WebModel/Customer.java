package com.javagbunga.springbootexample.WebModel;

public class Customer {
    private int id;
    private String userName;

    public Customer(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
