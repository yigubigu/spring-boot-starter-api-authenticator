package com.ruize.api.authenticator.sample.model;

public class Book {
    private String name;
    private String auth;

    public Book(String name, String auth) {
        this.name = name;
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public String getAuth() {
        return auth;
    }
}
