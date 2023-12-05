package aoc2023.day5;

public class SourceDestEntry {
    public final Long from;
    public final Long to;
    public final Long size;

    public SourceDestEntry(String line) {
        String[] split = line.split(" ");
        this.to = Long.parseLong(split[0]);
        this.from = Long.parseLong(split[1]);
        this.size = Long.parseLong(split[2]);
    }

    public boolean appliesTo(Long value) {
        boolean found = value >= from && value <= (from + size - 1);
        if (false) {
            System.out.println("Looking for " + value);
            System.out.println("from: " + this.from);
            System.out.println("to: " + this.to);
            System.out.println("size: " + this.size);
            System.out.println(value >= from);
            System.out.println(value <= (from + size));
        };
        return found;
    }

    public long apply(Long value) {
        long offset = value - from;
        long returnValue = to + offset;
        return returnValue;
    }
}
