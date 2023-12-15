package aoc2023.day13;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

    private List<Pattern> patterns = new ArrayList<>();

    public Day13(String[] testInput) {
        Pattern pattern = new Pattern();
        this.patterns.add(pattern);
        for (String eachLine : testInput) {
            if (eachLine.trim().length() == 0) {
                pattern = new Pattern();
                this.patterns.add(pattern);
            } else {
                pattern.addLine(eachLine);
            }
        }
    }

    public long execute1() {
        long result = 0;
        for (Pattern eachPattern : this.patterns) {
            eachPattern.detectReflect(false);

            if (eachPattern.isVerticalReflection) {
                result += eachPattern.verticalLinesToLeftOfReflection;
            } else if (eachPattern.isHorizontalReflection) {
                result += 100L * (eachPattern.horizontalRowsAboveReflection);
            } else {
                throw new UnsupportedOperationException("No reflection found");
            }
        }
        return result;
    }

    public long execute2() {
        long result = 0;
        for (Pattern eachPattern : this.patterns) {
            eachPattern.detectReflect(true);

            if (eachPattern.isVerticalReflection) {
                result += eachPattern.verticalLinesToLeftOfReflection;
            } else if (eachPattern.isHorizontalReflection) {
                result += 100L * (eachPattern.horizontalRowsAboveReflection);
            } else {
                throw new UnsupportedOperationException("No reflection found");
            }
        }
        return result;
    }
}
