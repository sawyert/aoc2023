package aoc2023.day12;

import java.util.ArrayList;
import java.util.List;

public class Day12 {

    private String[] testInput;
    List<SpringLine> springs = new ArrayList<>();

    public Day12(String[] testInput) {
        this.testInput = testInput;
    }

    public long execute1() {
        for (String eachLine : testInput) {
            this.springs.add(new SpringLine(eachLine, false));
        }

        long total = 0;
        for (SpringLine eachSpringLine : this.springs) {
            total += eachSpringLine.validCombinationCount();
        }
        return total;
    }


    public long execute2() {

        for (String eachLine : testInput) {
            this.springs.add(new SpringLine(eachLine, true));
        }

        long total = 0;
        for (SpringLine eachSpringLine : this.springs) {
            total += eachSpringLine.validCombinationCount();
        }
        return total;
    }
}
