package ru.sbr.service;

import ru.sbr.DAO.CardDAO;
import ru.sbr.utils.ParserJson;

import java.io.IOException;

public class Service {
    private final CardDAO cardDAO = new CardDAO();

    public String getAllCards() throws IOException {
        System.out.println("Service, передаю запрос на получение списка всех карт...");
        return new ParserJson().toJson(cardDAO.getAllCards());
    }

    public int addNewCard(long idAccount) {
        System.out.println("Service, передаю запрос на добавление карты...");
        return cardDAO.addNewCard(idAccount);
    }

    public int depFundsToCard(float sum, long idCard) {
        cardDAO.depFundsToCard(sum, idCard);
        return 0;
    }

    public int checkBalance() {
        //return new Parser().toJson(cardDAO.checkBalance());
        return 0;
    }
}
