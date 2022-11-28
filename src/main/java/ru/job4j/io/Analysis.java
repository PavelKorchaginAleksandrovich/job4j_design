package ru.job4j.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Analysis {
    private static final List<String> AVAILABLE_CODE = Arrays.asList("200", "300");
    private static final List<String> UNAVAILABLE_CODE = Arrays.asList("400", "500");;
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            StringBuilder result = new StringBuilder();
            String line;
            Boolean isAvailable = true;
            while ((line = read.readLine()) != null) {
                String[] splitedLine = line.split(" ");
                if (isAvailable && UNAVAILABLE_CODE.contains(splitedLine[0])) {
                    isAvailable = false;
                    result.append(splitedLine[1]).append(";");
                } else if (!isAvailable && AVAILABLE_CODE.contains(splitedLine[0])) {
                    isAvailable = true;
                    result.append(splitedLine[1]).append(System.lineSeparator());
                }
            }
            out.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("server.log", "unavailable.txt");
    }
}
