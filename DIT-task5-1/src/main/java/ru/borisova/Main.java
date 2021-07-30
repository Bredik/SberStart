package ru.borisova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ax^2+bx+c=-7
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a, b, с");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(solutionQuadratic(a, b, c));
    }

    public static String solutionQuadratic(int a, int b, int c) {
        int newC = c + 7;
        double D;

        double x1;
        double x2;

        String result = "";

        D = (b * b) - (4 * a * newC);

        if (D < 0) {
            result = "Решения нет";
        } else {
            x1 = (-b + Math.sqrt(D)) / 2 * a;
            x2 = (-b - Math.sqrt(D)) / 2 * a;
            if (D > 0) {
                result = "X1 = " + x1 + " X2 = " + x2;
            } else {
                result = "Уравнение имеет один корень X = " + x1;
            }
        }
        return result;
    }
}
