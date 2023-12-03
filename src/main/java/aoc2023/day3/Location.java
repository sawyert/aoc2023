package aoc2023.day3;

public class Location {
    public int line;
    public int column;

    public Location(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public Location tl() {
        return new Location(line-1, column-1);
    }
    public Location t() {
        return new Location(line-1, column);
    }
    public Location tr() {
        return new Location(line-1, column+1);
    }
    public Location r() {
        return new Location(line, column+1);
    }
    public Location br() {
        return new Location(line+1, column+1);
    }
    public Location b() {
        return new Location(line+1, column);
    }
    public Location bl() {
        return new Location(line+1, column-1);
    }
    public Location l() {
        return new Location(line, column-1);
    }
}
