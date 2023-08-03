package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> duplicates = new HashSet<>();
    private List<FileProperty> properties = new LinkedList<>();
    private Map<String, FileProperty> propertiesMap = new HashMap<String, FileProperty>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty property = new FileProperty(file.toFile().length(), file.getFileName().toString());
            file.toString();
            if (propertiesMap.containsValue(property)) {
                duplicates.add(property);
             }
            propertiesMap.put(file.toString(), property);
        }
        return super.visitFile(file, attrs);
    }
    public List<String> getDuplicates() {
        List<String> result = new LinkedList<>();

        List<FileProperty> propertiesResult = new LinkedList<>(properties);
        propertiesResult.retainAll(duplicates);
        propertiesResult.forEach(p -> result.add(p.getName()));
        propertiesMap.forEach((k, v) -> {
            if (duplicates.contains(v)) {
                result.add(k);
            }
        });
        return result;
    }

}
