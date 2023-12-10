package aoc2023.day10;

public class Node {
    private final char character;
    private final int line;
    private final int column;
    private char[][] grid;

    public Node(char[][] grid, Location location) {
        this.line = location.line;
        this.column = location.column;
        this.character = grid[this.line][this.column];
        this.grid = grid;
    }

    public boolean isSameLocationAs(Node other) {
        if (other == null) {
            return false;
        }
        return this.line == other.line && this.column == other.column;
    }

    public Directions getDirections() {
        switch (this.character) {
            case '|': return new Directions(true, false, true, false);
            case '-': return new Directions(false, true, false, true);
            case 'L': return new Directions(true, true, false, false);
            case 'J': return new Directions(true, false, false, true);
            case '7': return new Directions(false, false, true, true);
            case 'F': return new Directions(false, true, true, false);
            case '.': return new Directions(false, false, false, false);
            case 'S':
                boolean northValid = false;
                boolean eastValid = false;
                boolean southValid = false;
                boolean westValid = false;
                if (this.north() != null && this.north().getDirections().south) {
                    northValid = true;
                }
                if (this.east() != null && this.east().getDirections().west) {
                    eastValid = true;
                }
                if (this.south() != null && this.south().getDirections().north) {
                    southValid = true;
                }
                if (this.west() != null && this.west().getDirections().east) {
                    westValid = true;
                }
                return new Directions(northValid, eastValid, southValid, westValid);
            default:
                throw new UnsupportedOperationException("Don't know what this is:" + this.character);
        }
    }

    public Node north() {
        if (this.line > 0) {
            Location location = new Location(this.line - 1, this.column);
            return new Node(this.grid, location);
        }
        return null;
    }

    public Node east() {
        if (this.column < this.grid[0].length) {
            Location location = new Location(this.line, this.column + 1);
            return new Node(this.grid, location);
        }
        return null;
    }

    public Node south() {
        if (this.line < this.grid.length) {
            Location location = new Location(this.line + 1, this.column);
            return new Node(this.grid, location);
        }
        return null;
    }

    public Node west() {
        if (this.column > 0) {
            Location location = new Location(this.line, this.column - 1);
            return new Node(this.grid, location);
        }
        return null;
    }
}
