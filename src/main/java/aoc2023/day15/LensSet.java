package aoc2023.day15;

public class LensSet {

    LensBox[] boxes = new LensBox[256];

    public LensSet() {
        for (int i=0;i<this.boxes.length;i++) {
            this.boxes[i] = new LensBox(i);
        }
    }

    public long totalPower() {
        long totalPower = 0;
        for (LensBox eachBox : this.boxes) {
            System.out.println(eachBox.boxNumber() + " " + eachBox.power());
            totalPower += eachBox.power();
        }
        return totalPower;
    }

    public void put(int box, String label, int value) {
        if (this.boxes[box].hasLens(label)) {
            this.boxes[box].replaceLens(label, value);
        } else {
            this.boxes[box].addLens(label, value);
        }
    }

    public void remove(int box, String label) {
        this.boxes[box].remove(label);
    }
}
