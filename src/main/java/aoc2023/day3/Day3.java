package aoc2023.day3;

import java.util.List;

public class Day3 {

    private char[][] grid;
    public Day3(char[][] testInput) {
        this.grid = testInput;
    }

    public long execute1() {
        long total = 0;
        Grid planGrid = new Grid(this.grid);
        List<Location> symbols = planGrid.listSymbols();
        for (Location loc : symbols) {
            long partNumber = planGrid.findPartNumberNear(loc);
            total += partNumber;
        }
        return total;
    }

    public long execute2() {
        long total = 0;
        Grid planGrid = new Grid(this.grid);
        List<Location> gears = planGrid.listGears();
        for (Location loc : gears) {
            long partNumber = planGrid.findGearRatio(loc);
            total += partNumber;
        }
        return total;
    }
}
