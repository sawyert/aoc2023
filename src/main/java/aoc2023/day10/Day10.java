package aoc2023.day10;

public class Day10 {

    private final char[][] grid;

    public Day10(char[][] testInput) {
        this.grid = testInput;
    }

    public long execute1() {
        Location start = this.findStart();

        Node currentNode1 = new Node(this.grid, start);
        Node currentNode2 = new Node(this.grid, start);
        PipeRun pipe1 = new PipeRun(currentNode1);
        PipeRun pipe2 = new PipeRun(currentNode2);

        while (true) {
            currentNode1 = pipe1.progressA(currentNode1);
            currentNode2 = pipe2.progressB(currentNode2);

            if (pipe1.hasMetWith(pipe2)) {
                break;
            }
        }

        return pipe1.length() - 1;
    }

    private Location findStart() {
        for (int line=0;line<grid.length;line++) {
            for (int column=0;column<grid[0].length;column++) {
                if (this.grid[line][column] == 'S') {
                    return new Location(line,column);
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    public long execute2() {
        return 0;
    }
}
