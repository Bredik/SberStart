package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;
import ru.sbr.utils.ParserURI;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerAddNewCard implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("HandlerAddNewCard, handle");

        ParserURI parserURI = new ParserURI(); // объект для парсинга числа из урла
        String path = exchange.getRequestURI().getPath(); // получаем урл

        long idAccount = parserURI.getNumberFromUri(path); // получаем id url'a

        String response = "";
        //int codeResponse = 1;

        System.out.println("path = " + path);
        System.out.println(idAccount);

        // посылаем запрос на добавление карты с  id  аккаунта
        int codeResponse = new Service().addNewCard(idAccount);;

        if (codeResponse == 1) {
            response = "Card add!";
        } else response = "Your card has not been added or an error has occurred";

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
