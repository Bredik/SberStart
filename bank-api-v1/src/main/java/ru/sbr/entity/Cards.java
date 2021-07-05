package ru.sbr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cards {

    @JsonProperty()
    private int id;
    private String number;

    public Cards() {}

    public Cards(int id, String info) {
        this.id = id;
        this.number = info;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
