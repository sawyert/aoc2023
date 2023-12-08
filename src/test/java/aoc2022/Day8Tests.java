package aoc2022;

import aoc2023.day8.Day8;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example.txt");

        Day8 day = new Day8(testInput);
        assertEquals(2, day.execute1());
    }

    @Test
    void testPart1BasicInputWorks2() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example2.txt");

        Day8 day = new Day8(testInput);
        assertEquals(6, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");

        Day8 day = new Day8(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8Example3.txt");

        Day8 day = new Day8(testInput);
        assertEquals(6, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day8.txt");

        Day8 day = new Day8(testInput);
        System.out.println(day.execute2());
    }
}
