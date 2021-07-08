package ru.sbr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Cards {

    @JsonProperty()
    private long id;
    private String card_number;

    public Cards(long id, String card_number) {
        this.id = id;
        this.card_number = card_number;
    }

    public Cards() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return id == cards.id && Objects.equals(card_number, cards.card_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card_number);
    }
}
