package ru.sbr;

import org.junit.platform.commons.util.CollectionUtils;
import ru.sbr.DAO.CardDAO;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;
import ru.sbr.entity.Cards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Server.start();
            LaunchDB.connect();
        } catch (IOException e) {
            System.out.println("Ошибка запуска сервера.");
            e.printStackTrace();
        }
    }
}
