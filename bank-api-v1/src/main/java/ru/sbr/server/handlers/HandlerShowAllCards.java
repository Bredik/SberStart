package ru.sbr.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.DB.InitDB;
import ru.sbr.DTO.Cards;
import ru.sbr.parser.ToJson;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class HandlerShowAllCards implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Show all..";

        List<Cards> a = InitDB.readTable();
        new ToJson().toJson(a);

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();

        output.write(response.getBytes());
        output.flush();

        exchange.close();

    }
}
