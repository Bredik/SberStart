package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;
import ru.sbr.utils.ParserURI;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerCheckBalance implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Checkbalance, handle");

        ParserURI parserURI = new ParserURI(); // объект для парсинга числа из урла
        String path = exchange.getRequestURI().getPath(); // получаем урл

        long idCard = parserURI.getNumberFromUri(path); // получаем id url'a

        //int codeResponse = 1;

        //посылаем запрос на добавление карты с  id  аккаунта
        String response = new Service().checkBalance(idCard);

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        exchange.close();
    }
}
