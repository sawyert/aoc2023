package aoc2022;

import aoc2023.day9.Day9;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9Example.txt");

        Day9 day = new Day9(testInput);
        assertEquals(114, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9.txt");

        Day9 day = new Day9(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9Example.txt");

        Day9 day = new Day9(testInput);
        assertEquals(2, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day9.txt");

        Day9 day = new Day9(testInput);
        System.out.println(day.execute2());
    }
}
