package aoc2022;

import aoc2023.day15.Day15;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day15Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day = new Day15(testInput);
        assertEquals(1320, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day = new Day15(testInput);
        long answer = day.execute1();
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15Example.txt");

        Day15 day = new Day15(testInput);
        assertEquals(145, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day15.txt");

        Day15 day = new Day15(testInput);
        System.out.println(day.execute2());
    }
}
