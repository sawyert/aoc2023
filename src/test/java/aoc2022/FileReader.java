package aoc2022;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static String[] read(String filename) throws URISyntaxException, IOException {
        URL url = FileReader.class.getClassLoader().getResource(filename);
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);
        return testInputArray;
    }

    public static char[][] readGrid(String filename) throws URISyntaxException, IOException {
        String[] lines = FileReader.read(filename);

        char[][] grid = new char[lines.length][lines[1].length()];
        int lineNumber = 0;
        for (String line : lines) {
            int columnNumber = 0;
            for (char eachChar : line.toCharArray()) {
                grid[lineNumber][columnNumber] = eachChar;
                columnNumber++;
            }
            lineNumber++;
        }
        return grid;
    }
}