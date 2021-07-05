package ru.sbr;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbr.DAO.WorkDB;
import ru.sbr.controller.Server;

import java.io.IOException;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");

        Server.start();
        WorkDB.init();
    }
}
