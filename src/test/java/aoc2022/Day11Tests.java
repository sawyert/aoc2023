package aoc2022;

import aoc2023.day11.Day11;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day11Example.txt");

        Day11 day = new Day11(testInput);
        assertEquals(374, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day11.txt");

        Day11 day = new Day11(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day11Example.txt");

        Day11 day = new Day11(testInput);
        assertEquals(1030, day.execute2(10));
        assertEquals(8410, day.execute2(100));
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day11.txt");

        Day11 day = new Day11(testInput);
        System.out.println(day.execute2(1000000));
    }
}
