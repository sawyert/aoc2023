package aoc2023.day15;

import java.util.ArrayList;
import java.util.List;

public class LensBox {
    private List<Lens> lenses = new ArrayList<>();
    private int boxNumber;

    public LensBox(int number) {
        this.boxNumber = number;
    }

    public long power() {
        long power = 0;
        int index = 1;
        for (Lens eachLens : this.lenses) {
            long lensPower = (long) (1 + this.boxNumber) * index * eachLens.lensPower();
            power += lensPower;
            index++;
        }
        return power;
    }

    public boolean hasLens(String label) {
        for (Lens eachLens : this.lenses) {
            if (eachLens.getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }

    public void replaceLens(String label, int value) {
        for (Lens eachLens : this.lenses) {
            if (eachLens.getLabel().equals(label)) {
                eachLens.setStrength(value);
            }
        }
    }

    public void addLens(String label, int value) {
        this.lenses.add(new Lens(label, value));
    }

    public void remove(String label) {
        List<Lens> newLensList = new ArrayList<>();
        for (Lens eachExistingLens : this.lenses) {
            if (eachExistingLens.getLabel().equals(label)) {
                continue;
            }
            newLensList.add(eachExistingLens);
        }
        this.lenses = newLensList;
    }

    public int boxNumber() {
        return this.boxNumber;
    }
}
