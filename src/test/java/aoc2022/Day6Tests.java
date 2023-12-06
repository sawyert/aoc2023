package aoc2022;

import aoc2023.day6.Day6;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6Example.txt");

        Day6 day = new Day6(testInput);
        assertEquals(288, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day = new Day6(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6Example.txt");

        Day6 day = new Day6(testInput);
        assertEquals(71503, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day6.txt");

        Day6 day = new Day6(testInput);
        System.out.println(day.execute2());
    }
}
