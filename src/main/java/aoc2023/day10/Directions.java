package aoc2023.day10;

public class Directions {
    public boolean north = false;
    public boolean east = false;
    public boolean south = false;
    public boolean west = false;

    public Directions(boolean north, boolean east, boolean south, boolean west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }
}
