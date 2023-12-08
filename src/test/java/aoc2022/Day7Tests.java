package aoc2022;

import aoc2023.day7.Day7;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day7Tests {

    @Test
    void testPart1BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day = new Day7(testInput, false);
        assertEquals(6440, day.execute1());
    }

    @Test
    void testPart1Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");

        Day7 day = new Day7(testInput, false);
        long result = day.execute1();
        assertNotEquals(250861352, result);
        assertNotEquals(251038998, result);
        assertNotEquals(251038920, result);
        System.out.println(result);
    }

    @Test
    void testPart2BasicInputWorks() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7Example.txt");

        Day7 day = new Day7(testInput, true);
        assertEquals(5905, day.execute2());
    }

    @Test
    void testPart2Answer() throws IOException, URISyntaxException {
        String[] testInput = FileReader.read("Day7.txt");

        Day7 day = new Day7(testInput, true);
        System.out.println(day.execute2());
    }
}
