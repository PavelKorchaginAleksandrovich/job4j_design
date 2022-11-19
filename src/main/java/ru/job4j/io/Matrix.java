package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Matrix {
    public static void main(String[] args) {
        String matrix = convertMatrix(getMatrix(10));
        try {
            FileOutputStream out = new FileOutputStream("matrix.txt");
            out.write(matrix.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String convertMatrix(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j]).append(" ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private static int[][] getMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        return matrix;
    }
}
