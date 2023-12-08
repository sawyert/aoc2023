package aoc2023.day8;

public class Element {
    private final String source;
    private final String leftDestination;
    private final String rightDestination;

    public Element(String from, String left, String right) {
        this.source = from;
        this.leftDestination = left;
        this.rightDestination = right;
    }

    public String getLeft() {
        return this.leftDestination;
    }

    public String getRight() {
        return this.rightDestination;
    }
}
