package aoc2022;

import aoc2023.day1.Day1;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1Example.txt");

        Day1 day1 = new Day1(testInput);
        assertEquals(142, day1.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1.txt");

        Day1 day1 = new Day1(testInput);
        System.out.println(day1.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1Example2.txt");

        Day1 day1 = new Day1(testInput);
        assertEquals(281, day1.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day1.txt");

        Day1 day1 = new Day1(testInput);
        System.out.println(day1.execute2());
    }
}
