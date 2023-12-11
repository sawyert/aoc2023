package aoc2022;

import aoc2023.day10.Day10;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Tests {

    @Test
    void testPart1SimpleInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day10Simple.txt");

        Day10 day = new Day10(testInput);
        assertEquals(4, day.execute1());
    }

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day10Example.txt");

        Day10 day = new Day10(testInput);
        assertEquals(8, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day10.txt");

        Day10 day = new Day10(testInput);
        System.out.println(day.execute1());
    }
}
