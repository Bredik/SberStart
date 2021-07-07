package ru.sbr.entity;

public class Deposite {
    private long id;
    private float sum;

    public Deposite() {}

    public Deposite(long id, float sum) {
        this.id = id;
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Deposite{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
