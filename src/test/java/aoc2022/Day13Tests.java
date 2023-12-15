package aoc2022;

import aoc2023.day13.Day13;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day13Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13 day = new Day13(testInput);
        assertEquals(405, day.execute1());
    }

    @Test
    void testPart1BasicInputWorks2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example2.txt");

        Day13 day = new Day13(testInput);
        assertEquals(1200, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");

        Day13 day = new Day13(testInput);
        long answer = day.execute1();
        assertNotEquals(1262, answer);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13Example.txt");

        Day13 day = new Day13(testInput);
        assertEquals(400, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day13.txt");

        Day13 day = new Day13(testInput);
        System.out.println(day.execute2());
    }
}
