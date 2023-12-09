package aoc2023.day9;

import java.util.ArrayList;
import java.util.List;

public class HistoryLine {

    private List<Long> numbers = new ArrayList<>();

    public HistoryLine(String eachLine) {
        String[] numberSplit = eachLine.trim().split(" ");
        for (String eachNumber : numberSplit) {
            this.numbers.add(Long.parseLong(eachNumber.trim()));
        }
    }

    public long nextNumber() {
        String diffSequence = "";

        for (int i=1; i<this.numbers.size();i++) {
            Long lastNumber = this.numbers.get(i - 1);
            Long thisNumber = this.numbers.get(i);

            Long diff = thisNumber - lastNumber;
            diffSequence += diff;
            diffSequence += " ";
        }

        System.out.println(diffSequence);
        HistoryLine subSequence = new HistoryLine(diffSequence);
        if (subSequence.allZeroes()) {
            return this.lastValue();
        }

        long value = subSequence.nextNumber();
        long total = this.lastValue() + value;
        System.out.println("Returning " + total);
        return total;
    }

    private long lastValue() {
        return this.numbers.get(this.numbers.size() - 1);
    }

    private long firstValue() {
        return this.numbers.get(0);
    }

    private boolean allZeroes() {
        for (Long eachNumber : this.numbers) {
            if (eachNumber != 0) {
                return false;
            }
        }
        return true;
    }

    public long previousNumber() {
        String diffSequence = "";

        for (int i=1; i<this.numbers.size();i++) {
            Long lastNumber = this.numbers.get(i - 1);
            Long thisNumber = this.numbers.get(i);

            Long diff = thisNumber - lastNumber;
            diffSequence += diff;
            diffSequence += " ";
        }

        System.out.println(diffSequence);
        HistoryLine subSequence = new HistoryLine(diffSequence);
        if (subSequence.allZeroes()) {
            return this.firstValue();
        }

        long value = subSequence.previousNumber();
        long total = this.firstValue() - value;
        System.out.println("Returning " + total);
        return total;
    }
}
