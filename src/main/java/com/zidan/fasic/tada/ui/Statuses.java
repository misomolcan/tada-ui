package com.zidan.fasic.tada.ui;

public enum Statuses {
    CONFIRMED("confirmed"),
    REQUESTED("requested"),
    SUGGESTED("suggested"),
    DENIED("denied");

    String name;

    Statuses(String name) {
        this.name = name;
    }

}
