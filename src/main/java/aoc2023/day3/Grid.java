package aoc2023.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grid {

    private char[][] grid;
    public Grid(char[][] grid) {
        this.grid = grid;
    }

    public List<Location> listSymbols() {
        List<Location> locations = new ArrayList<>();

        for (int line = 0; line < grid.length; line++) {
            for (int column = 0; column < grid[0].length; column++) {
                char foundChar = this.grid[line][column];
                if (foundChar == '.') continue;
                if (Character.isDigit(foundChar)) continue;
                locations.add(new Location(line, column));
            }
        }
        return locations;
    }

    private char getChar(Location location) {
        try {
            return this.grid[location.line][location.column];
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            return '.';
        }
    }

    public long findPartNumberNear(Location loc) {
        Set<Long> uniqueNumbers = new HashSet<>();

        if (Character.isDigit(this.getChar(loc.tl()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.tl()));
        }
        if (Character.isDigit(this.getChar(loc.t()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.t()));
        }
        if (Character.isDigit(this.getChar(loc.tr()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.tr()));
        }
        if (Character.isDigit(this.getChar(loc.r()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.r()));
        }
        if (Character.isDigit(this.getChar(loc.br()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.br()));
        }
        if (Character.isDigit(this.getChar(loc.b()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.b()));
        }
        if (Character.isDigit(this.getChar(loc.bl()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.bl()));
        }
        if (Character.isDigit(this.getChar(loc.l()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.l()));
        }

        long total = 0;
        for (Long eachValue : uniqueNumbers) {
            total += eachValue;
        }
        return total;
    }

    private long processDigitFrom(Location loc) {
        String number = "";
        number += this.getChar(loc);

        Location newLocation = loc;
        while (Character.isDigit(this.getChar(newLocation.l()))) {
            number = this.getChar(newLocation.l()) + number;
            newLocation = newLocation.l();
        }
        newLocation = loc;
        while (Character.isDigit(this.getChar(newLocation.r()))) {
            number = number + this.getChar(newLocation.r());
            newLocation = newLocation.r();
        }

        return Integer.parseInt(number);
    }

    public List<Location> listGears() {
        List<Location> locations = new ArrayList<>();

        for (int line = 0; line < grid.length; line++) {
            for (int column = 0; column < grid[0].length; column++) {
                char foundChar = this.grid[line][column];
                if (foundChar == '*') {
                    locations.add(new Location(line, column));
                }
            }
        }
        return locations;
    }

    public long findGearRatio(Location loc) {
        Set<Long> uniqueNumbers = new HashSet<>();

        if (Character.isDigit(this.getChar(loc.tl()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.tl()));
        }
        if (Character.isDigit(this.getChar(loc.t()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.t()));
        }
        if (Character.isDigit(this.getChar(loc.tr()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.tr()));
        }
        if (Character.isDigit(this.getChar(loc.r()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.r()));
        }
        if (Character.isDigit(this.getChar(loc.br()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.br()));
        }
        if (Character.isDigit(this.getChar(loc.b()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.b()));
        }
        if (Character.isDigit(this.getChar(loc.bl()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.bl()));
        }
        if (Character.isDigit(this.getChar(loc.l()))) {
            uniqueNumbers.add(this.processDigitFrom(loc.l()));
        }

        if (uniqueNumbers.size() != 2) {
            return 0;
        }

        long total = 1;
        for (Long eachValue : uniqueNumbers) {
            total *= eachValue;
        }
        return total;
    }
}
