package aoc2022;

import aoc2023.day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day = new Day4(testInput);
        assertEquals(13, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day = new Day4(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4Example.txt");

        Day4 day = new Day4(testInput);
        assertEquals(30, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day4.txt");

        Day4 day = new Day4(testInput);
        System.out.println(day.execute2());
    }
}
