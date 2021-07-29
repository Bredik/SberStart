package ru.borisova.solution1.OOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        try {
            menu.exe();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
