package ru.sbr.service;

import ru.sbr.DAO.CardDAO;
import ru.sbr.utils.ParserJson;

public class Service {
    private final CardDAO cardDAO = new CardDAO();

    public String getAllCards() {
        return new ParserJson().toJson(cardDAO.getAllCards());
    }

    public int addNewCard(long idAccount) {
        System.out.println("Service, передаю запрос на добавление карты...");
        return cardDAO.addNewCard(idAccount);
    }

    public int depFundsToCard(float sum, long idCard) {
        return cardDAO.depFundsToCard(sum, idCard);
    }

    public String checkBalance(long idCard) {
        return new ParserJson().toJson1(cardDAO.checkBalance(idCard));
    }
}
