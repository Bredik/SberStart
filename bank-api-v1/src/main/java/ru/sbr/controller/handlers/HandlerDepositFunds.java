package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;
import ru.sbr.utils.ParserURI;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class HandlerDepositFunds implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String responce = "";

        if ("POST".equals(exchange.getRequestMethod())) {


        } else {
            exchange.sendResponseHeaders(405, -1);
        }

        /*System.out.println("DepositFunds, handle");

        ParserURI parserURI = new ParserURI(); // объект для парсинга числа из урла
        String path = exchange.getRequestURI().getPath(); // получаем урл
        System.out.println("path = " + path);

        float sum = parserURI.getSumFromUri(path); // получаем id сумму
        System.out.println("Сумма");
        System.out.println(sum);
        long idCard = parserURI.getIdFromUri(path); // получаем id сумму
        System.out.println("id");
        System.out.println(idCard);

        String response = "";
        //int codeResponse = 1;

        //посылаем запрос на добавление карты с  id  аккаунта
        int codeResponse = new Service().depFundsToCard(sum, idCard);
        System.out.println("code = " + codeResponse);

        if (codeResponse == 1) {
            response = "Sum add!";
        } else response = "Your card has not been added or an error has occurred";

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());*/
        exchange.close();
    }
}



