package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            sources.forEach(s -> {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(s.toString()))) {
                    zip.putNextEntry(new ZipEntry(s.toString()));
                    zip.write(out.readAllBytes());
                    zip.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ArgsName names = ArgsName.of(args);
        checkArgs(names);
        String targetFileName = names.get("o");
        Path path = Path.of(names.get("d"));
        List<Path> paths = Search.search(path, p -> p.toFile().getName().endsWith(names.get("e")));
        Zip zip = new Zip();
        zip.packFiles(paths, Paths.get(targetFileName).toFile());

    }
    private static void checkArgs(ArgsName names) {
        if (!names.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Error: Argument 'o' does not end with '.zip'");
        }
    }
}
