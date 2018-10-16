package com.postres.staffing_follower.utils;

public enum FieldConstants {
    YES("yes"),
    NOT("not");


    private String value;

    FieldConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
