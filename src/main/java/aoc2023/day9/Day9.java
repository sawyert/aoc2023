package aoc2023.day9;

import java.util.ArrayList;
import java.util.List;

public class Day9 {

    List<HistoryLine> lines = new ArrayList<>();

    public Day9(String[] testInput) {
        for (String eachLine : testInput) {
            this.lines.add(new HistoryLine(eachLine));
        }
    }

    public long execute1() {
        long total = 0;
        for (HistoryLine eachLine : this.lines) {
            total += eachLine.nextNumber();
        }
        return total;
    }

    public long execute2() {
        long total = 0;
        for (HistoryLine eachLine : this.lines) {
            total += eachLine.previousNumber();
        }
        return total;
    }
}
