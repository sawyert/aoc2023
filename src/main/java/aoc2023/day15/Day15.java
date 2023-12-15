package aoc2023.day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {
    List<String> operations = new ArrayList<>();

    public Day15(String[] testInput) {
        String[] parts = testInput[0].split(",");
        this.operations.addAll(List.of(parts));
    }

    public long execute1() {
        long value = 0;

        for (String op : this.operations) {
            long hash = this.hash(op);
            System.out.println(op + " " + hash);
            value += hash;
        }

        return value;
    }

    private int hash(String op) {
        int value = 0;

        char[] chars = op.toCharArray();

        for (int i=0; i<chars.length;i++) {
            value += chars[i];
            value *= 17;
            value = value % 256;
        }
        return value;
    }

    public long execute2() {
        LensSet lensSet = new LensSet();

        for (String op : this.operations) {
            String label = this.getLabel(op);
            Type type = this.getType(op);
            String value = this.getValue(op);
            int box = this.hash(label);

            System.out.println(op + " " + label + " " + type + " " + value + " " + box);

            if (type == Type.DASH) {
                lensSet.remove(box, label);
            } else if (type == Type.EQUALS) {
                lensSet.put(box, label, Integer.parseInt(value));
            }
        }

        return lensSet.totalPower();
    }

    private String getValue(String op) {
        if (op.endsWith("-")) {
            return null;
        }
        if (op.contains("=")) {
            return op.substring(op.indexOf("=") + 1);
        }
        throw new UnsupportedOperationException();
    }

    private Type getType(String op) {
        if (op.endsWith("-")) {
            return Type.DASH;
        }
        if (op.contains("=")) {
            return Type.EQUALS;
        }
        throw new UnsupportedOperationException();
    }

    private String getLabel(String op) {
        if (op.endsWith("-")) {
            return op.substring(0, op.indexOf("-"));
        }
        if (op.contains("=")) {
            return op.substring(0, op.indexOf("="));
        }
        throw new UnsupportedOperationException();
    }


}
