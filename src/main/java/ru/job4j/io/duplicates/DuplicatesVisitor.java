package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> propertiesMap = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
         FileProperty property = new FileProperty(file.toFile().length(), file.getFileName().toString());

         if (propertiesMap.containsKey(property)) {
             propertiesMap.get(property).add(file);
         } else {
             propertiesMap.put(property, new LinkedList<>(List.of(file)));
         }

        return super.visitFile(file, attrs);
    }
    public List<String> getDuplicates() {
        List<String> result = new LinkedList<>();

        propertiesMap.forEach((k, v) -> {
            if (v.size() > 1) {
                v.forEach(path -> result.add(path.toString()));
            }
        });
        return result;
    }

}
