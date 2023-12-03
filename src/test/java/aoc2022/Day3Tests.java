package aoc2022;

import aoc2023.day2.Day2;
import aoc2023.day3.Day3;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day3Example.txt");

        Day3 day = new Day3(testInput);
        assertEquals(4361, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day3.txt");

        Day3 day = new Day3(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day3Example.txt");

        Day3 day = new Day3(testInput);
        assertEquals(467835, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        char[][] testInput = FileReader.readGrid("Day3.txt");

        Day3 day = new Day3(testInput);
        System.out.println(day.execute2());
    }
}
