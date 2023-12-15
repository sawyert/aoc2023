package aoc2023.day13;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    private int maxLine = 0;
    private int maxColumn = 0;
    private char[][] data = new char[50][50];
    public boolean isVerticalReflection = false;
    public boolean isHorizontalReflection = false;
    public int verticalLinesToLeftOfReflection;
    public int horizontalRowsAboveReflection;

    public void addLine(String eachLine) {
        this.data[this.maxLine] = eachLine.toCharArray();
        this.maxLine++;
        this.maxColumn = eachLine.length();
    }

    public void detectReflect(boolean part2) {
        this.printData();

        for (int column=0;column<this.maxColumn;column++) {
            if (this.isVerticalReflectionAt(column, part2)) {
                this.isVerticalReflection = true;
                this.verticalLinesToLeftOfReflection = column + 1;
                break;
            }
        }
        if (!this.isVerticalReflection) {
            for (int row=0;row<this.maxLine;row++) {
                if (this.isHorizontalReflectionAt(row, part2)) {
                    this.isHorizontalReflection = true;
                    this.horizontalRowsAboveReflection = row + 1;
                    break;
                }
            }
        }

        if (this.isVerticalReflection) {
            System.out.println("Vertical reflection at " + this.verticalLinesToLeftOfReflection);
        }
        if (this.isHorizontalReflection) {
            System.out.println("Horizontal reflection at " + this.horizontalRowsAboveReflection);
        }

        System.out.println();
    }

    private void printData() {
        for (int line=0;line<this.maxLine;line++) {
            for (int column=0; column<this.maxColumn; column++) {
                System.out.print(this.data[line][column]);
            }
            System.out.println();
        }
    }

    private boolean isVerticalReflectionAt(int startColumn, boolean part2) {
        for (int column=0; column<this.maxColumn/2;column++) {
            try {
                if (this.areColumnsDifferent(column, startColumn - column, startColumn + 1 + column, part2)) {
                    return false;
                }
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                if (column == 0) {
                    if (this.areColumnsDifferent(column, startColumn - column, startColumn - 1 + column, part2)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                break;
            }
        }
        return true;
    }

    private boolean areColumnsDifferent(int index, int leftColumn, int rightColumn, boolean part2) throws ArrayIndexOutOfBoundsException {
        if (rightColumn >= this.maxColumn) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int differences = 0;
        for (int line=0; line<this.maxLine;line++) {
            if (this.data[line][leftColumn] != this.data[line][rightColumn])
                differences++;
        }
        if (index == 0 && part2) {
            return differences != 1;
        }
        return differences != 0;
    }

    private boolean isHorizontalReflectionAt(int startLine, boolean part2) {
        for (int line=0; line<this.maxLine/2;line++) {
            try {
                if (this.areLinesDifferent(line,startLine-line, startLine+1+line, part2)) {
                    return false;
                }
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                if (line == 0) {
                    if (this.areLinesDifferent(line, startLine - line, startLine - 1 + line, part2)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                break;
           }
        }
        return true;
    }

    private boolean areLinesDifferent(int index, int leftLine, int rightLine, boolean part2) throws ArrayIndexOutOfBoundsException {
        if (rightLine >= this.maxLine) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int differences = 0;
        for (int column=0; column<this.maxColumn-1;column++) {
            if (this.data[leftLine][column] != this.data[rightLine][column])
                differences++;
        }
        if (index == 0 && part2) {
            return differences != 1;
        }
        return differences != 0;
    }
}
