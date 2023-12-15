package aoc2023.day15;

public class Lens {
    private int strength;
    private String label;

    public Lens(String label, int value) {
        this.label = label;
        this.strength = value;
    }

    public int lensPower() {
        return strength;
    }

    public String getLabel() {
        return label;
    }

    public void setStrength(int value) {
        this.strength = value;
    }
}
