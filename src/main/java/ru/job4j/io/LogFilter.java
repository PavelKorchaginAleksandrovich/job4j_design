package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private static final String ERROR_NUMBER  = "404";
    public List<String> filter(String file) {
        List<String> result = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            List<String> log = in.lines().toList();
            for (String line:log) {
                String[] lineValues = line.split(" ");
                if (ERROR_NUMBER.equals(lineValues[lineValues.length - 2])) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
       new LogFilter().filter("log.txt").stream().forEach(System.out::println);
    }
}
