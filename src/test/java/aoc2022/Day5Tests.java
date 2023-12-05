package aoc2022;

import aoc2023.day5.Day5;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        Day5 day = new Day5(testInput);
        assertEquals(35, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        Day5 day = new Day5(testInput);
        System.out.println(day.execute1());
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5Example.txt");

        Day5 day = new Day5(testInput);
        assertEquals(0, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day5.txt");

        Day5 day = new Day5(testInput);
        System.out.println(day.execute2());
    }
}
