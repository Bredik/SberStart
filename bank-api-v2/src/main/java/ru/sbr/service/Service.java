package ru.sbr.service;

import ru.sbr.DAO.CardDAO;
import ru.sbr.utils.ParserJson;

import java.io.InputStream;

public class Service {
    private final CardDAO cardDAO = new CardDAO();

    public String getAllCards() {
        return new ParserJson().toJson(cardDAO.getAllCards());
    }

    public String checkBalance(long idCard) {
        return new ParserJson().toJson(cardDAO.checkBalance(idCard));
    }

    public int addNewCard(InputStream response) {
        return cardDAO.addNewCard(new ParserJson().fromJson(response));
    }

    public int depFundsToCard(InputStream response) {
        return cardDAO.depFundsToCard(new ParserJson().fromJson(response));
    }


}
