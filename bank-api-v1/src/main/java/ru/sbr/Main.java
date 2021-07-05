package ru.sbr;

import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");

        Server.start();
        LaunchDB.connect();
    }
}
