package ru.borisova;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = scanner.nextInt();

        int[][] matrix = siameseMethodForEvenNumbers(sizeMatrix);

        for (int[] i: matrix) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Cиамский метод
    private static int[][] siameseMethodForEvenNumbers(int n) {
        int[][] matrix = new int[n][n];

        // Заполняем нулями, что бы потом проверять на блокировку
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 0);
        }

        int number = 1;
        int row = 0;
        int col = matrix.length/2;
        int last = n - 1;

        int curr_row;
        int curr_col;

        while (number <= n * n) {
            matrix[row][col] = number;
            number++;

            curr_row = row;
            curr_col = col;

            row--;
            col++;

            if (row == -1) {
                row = last;
            }
            if (col == n) {
                col = 0;
            }

            if (matrix[row][col] != 0) {
                row = curr_row + 1;
                col = curr_col;
            }
        }

        return matrix;
    }
}
