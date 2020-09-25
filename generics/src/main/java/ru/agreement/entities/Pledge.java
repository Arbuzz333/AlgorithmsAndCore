package ru.agreement.entities;



public enum Pledge {

    APARTMENT(11),
    RETAIL(55),
    INDUSTRIAL(77);

    private int code;

    Pledge(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
