package ru.job4j.io;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

class AnalysisTest {

    @Test
    void checkUnavailable(@TempDir Path tempDir) throws IOException {
        Analysis analysis = new Analysis();
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        StringBuilder exp = new StringBuilder();
        exp.append("10:57:01;10:59:01").append("11:01:02;11:02:02");
        assertThat(exp.toString()).isEqualTo(rsl.toString());
    }
}