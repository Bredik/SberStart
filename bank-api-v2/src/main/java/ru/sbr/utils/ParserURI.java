package ru.sbr.utils;

public class ParserURI {
    public long getNumberFromUri(String uri) {
        System.out.println("Получаем айди из урла для добавления карты");
        String[] strings = uri.split("/");
        return Long.parseLong(strings[strings.length - 1]);
    }
}
