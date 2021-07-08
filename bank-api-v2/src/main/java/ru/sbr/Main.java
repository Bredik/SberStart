package ru.sbr;

import ru.sbr.DAO.CreateDB;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Server.start();
            LaunchDB.connect();
            CreateDB.dbCreate();
        } catch (IOException e) {
            System.out.println("Ошибка запуска сервера.");
            e.printStackTrace();
        }
    }
}
