package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private List<FileProperty> duplicates = new LinkedList<>();
    private List<FileProperty> properties = new LinkedList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty property = new FileProperty(file.toFile().length(), file.getFileName().toString(), file.toString());
            if (properties.contains(property)) {
                duplicates.add(property);
            }
            properties.add(property);
        }
        return super.visitFile(file, attrs);
    }
    public List<String> getDuplicates() {
        List<String> result = new LinkedList<>();
        List<FileProperty> propertiesResult = new LinkedList<>(properties);
        propertiesResult.retainAll(duplicates);
        propertiesResult.forEach(p -> result.add(p.getPath()));
        return result;
    }

}
