package ru.sbr.utils;

public class ParserURI {
    public long getNumberFromUri(String uri) {
        System.out.println("Получаем айди из урла для добавления карты");
        String[] strings = uri.split("/");
        return Long.parseLong(strings[strings.length - 1]);
    }

    public long getIdFromUri(String uri) {
        System.out.println("Получаем айди из урла для обновления баланса карты");
        String[] strings = uri.split("/");
        return Long.parseLong(strings[strings.length - 2]);
    }

    public float getSumFromUri(String uri) {
        System.out.println("Получение суммы для обновления баланса карты");
        String[] strings = uri.split("/");
        return Float.parseFloat(strings[strings.length - 1]);
    }
}
