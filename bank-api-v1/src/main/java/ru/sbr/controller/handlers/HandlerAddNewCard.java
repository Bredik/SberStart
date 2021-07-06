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
        String response = "";

        if ("GET".equals(exchange.getRequestMethod())) {
            String path = exchange.getRequestURI().getPath(); // получаем урл
            String[] strings = path.split("/");
            // получаем id счета, на который надо добавить карту
            long idAccount = Long.parseLong(strings[strings.length - 1]);
            // посылаем запрос на добавление карты с  id  аккаунта
            int codeResponse = new Service().addNewCard(idAccount);
            if (codeResponse == 1) {
                response = "Card add!";
            } else response = "Your card has not been added or an error has occurred";

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

        } else {
            exchange.sendResponseHeaders(405, -1);
        }
        exchange.close();
    }
}
