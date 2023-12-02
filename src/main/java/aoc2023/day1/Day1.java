package aoc2023.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
    private List<String> lines = new ArrayList<>();

    public Day1(String[] testInput) {
        lines.addAll(Arrays.asList(testInput));
    }

    public long execute1() {
        long total = 0;
        for (String line : this.lines) {
            Character firstDigit = null;
            Character lastDigit = null;
            for (int i=0; i<line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (firstDigit == null) {
                        firstDigit = line.charAt(i);
                    }
                    lastDigit = line.charAt(i);
                }
            }

            String numberString = firstDigit.toString() + lastDigit.toString();
            int number = Integer.parseInt(numberString);
            total += number;
        }
        return total;
    }

    public long execute2() {
        long total = 0;
        for (String eachLine : this.lines) {
            Character firstDigit = this.findFirstDigit(eachLine);
            Character lastDigit = this.findLastDigit(eachLine);

            String numberString = firstDigit.toString() + lastDigit.toString();
            int number = Integer.parseInt(numberString);
            total += number;

            System.out.println(eachLine + " " + number);
        }
        return total;
    }

    private Character findFirstDigit(String line) {
        String lineToProcess = line;
        while (true) {
            if (Character.isDigit(lineToProcess.charAt(0))) {
                return lineToProcess.charAt(0);
            }

            if (lineToProcess.startsWith("one")) {
                return '1';
            }

            if (lineToProcess.startsWith("two")) {
                return '2';
            }

            if (lineToProcess.startsWith("three")) {
                return '3';
            }
            if (lineToProcess.startsWith("four")) {
                return '4';
            }

            if (lineToProcess.startsWith("five")) {
                return '5';
            }

            if (lineToProcess.startsWith("six")) {
                return '6';
            }

            if (lineToProcess.startsWith("seven")) {
               return '7';
            }

            if (lineToProcess.startsWith("eight")) {
               return '8';
            }

            if (lineToProcess.startsWith("nine")) {
                return '9';
            }

            lineToProcess = lineToProcess.substring(1);
        }
    }

    private Character findLastDigit(String line) {
        String lineToProcess = line;
        while (true) {
            if (Character.isDigit(lineToProcess.charAt(lineToProcess.length()-1))) {
                return lineToProcess.charAt(lineToProcess.length()-1);
            }

            if (lineToProcess.endsWith("one")) {
                return '1';
            }

            if (lineToProcess.endsWith("two")) {
                return '2';
            }

            if (lineToProcess.endsWith("three")) {
                return '3';
            }
            if (lineToProcess.endsWith("four")) {
                return '4';
            }

            if (lineToProcess.endsWith("five")) {
                return '5';
            }

            if (lineToProcess.endsWith("six")) {
                return '6';
            }

            if (lineToProcess.endsWith("seven")) {
                return '7';
            }

            if (lineToProcess.endsWith("eight")) {
                return '8';
            }

            if (lineToProcess.endsWith("nine")) {
                return '9';
            }

            lineToProcess = lineToProcess.substring(0, lineToProcess.length() - 1);
        }
    }
}
