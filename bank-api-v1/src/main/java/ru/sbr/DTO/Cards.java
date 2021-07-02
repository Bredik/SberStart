package ru.sbr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cards {
    static {
        System.out.println("Create DTOTest");
    }

    @JsonProperty()
    int id;
    String info;

    public Cards() {}

    public Cards(int id, String info) {
        this.id = id;
        this.info = info;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
