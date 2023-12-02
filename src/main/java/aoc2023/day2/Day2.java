package aoc2023.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    private List<String> lines = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    public Day2(String[] testInput) {
        lines.addAll(Arrays.asList(testInput));

        for (String line: lines) {
            Game game = new Game(line);
            this.games.add(game);
        }
    }

    public long execute1() {
        int redMax = 12;
        int greenMax = 13;
        int blueMax = 14;
        long resultTotal = 0;
        for (Game game: this.games) {
            if (game.possible(redMax, greenMax, blueMax)) {
                resultTotal += game.getId();
            }
        }
        return resultTotal;
    }

    public long execute2() {
        long resultTotal = 0;
        for (Game game: this.games) {
            resultTotal += game.power();
        }
        return resultTotal;
    }
}
