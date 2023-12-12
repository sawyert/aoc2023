package aoc2022;

import aoc2023.day12.Day12;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day = new Day12(testInput);
        assertEquals(21, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");

        Day12 day = new Day12(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12Example.txt");

        Day12 day = new Day12(testInput);
        assertEquals(525152, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day12.txt");

        Day12 day = new Day12(testInput);
        System.out.println(day.execute2());
    }
}
