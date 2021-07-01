package ru.sbr.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerShowAllCards implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "Show all..";
        // разобраться с этой строкой response.getBytes().length
        // ну и вообще разобраться с кодами ответов
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
