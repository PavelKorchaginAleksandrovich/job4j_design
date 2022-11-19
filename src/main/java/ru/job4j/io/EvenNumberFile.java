package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try {
            StringBuilder fileText = new StringBuilder();
            FileInputStream in = new FileInputStream("even.txt");
            int read;
            while ((read = in.read()) != -1) {
                fileText.append((char) read);
            }
            String[] lines = fileText.toString().split(System.lineSeparator());
            for (String line:lines) {
                String even = Integer.valueOf(line) % 2 == 0 ? "четное" : "нечетное";
                System.out.println("Число " + line + " " +  even);
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
