package ru.sbr.service;

import ru.sbr.DAO.CardDAO;
import ru.sbr.Parser;

import java.io.IOException;

public class Service {
    private final CardDAO cardDAO = new CardDAO();

    public String getAllCards() throws IOException {
        System.out.println("Service, getAllCards...");
        return new Parser().toJson(cardDAO.getAllCards());
    }

    public void addNewCard() {
        System.out.println("Service, addNewCard...");
        cardDAO.addNewCard();
    }

    public void depFundsToCard() {
        cardDAO.depFundsToCard();
    }

    public int checkBalance() {
        //return new Parser().toJson(cardDAO.checkBalance());
        return 0;
    }
}
