package aoc2023.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int gameId = 0;
    private List<Round> rounds = new ArrayList<>();

    public Game(String line) {
        String[] parts = line.split(":");
        String gameNumber = parts[0].substring("Game ".length()).trim();
        this.gameId = Integer.parseInt(gameNumber);

        String[] roundTexts = parts[1].split(";");
        for (String roundText : roundTexts) {
            Round round = new Round(roundText);
            this.rounds.add(round);
        }
    }

    public long getId() {
        return this.gameId;
    }

    public boolean possible(int redMax, int greenMax, int blueMax) {
        for (Round round : this.rounds) {
            if (!round.possible(redMax, greenMax, blueMax)) {
                return false;
            }
        }
        return true;
    }

    public long power() {
        long red = 0;
        long green = 0;
        long blue = 0;

        for (Round round : this.rounds) {
            if (round.red > red)  {
                red = round.red;
            }
            if (round.green > green)  {
                green = round.green;
            }
            if (round.blue > blue)  {
                blue = round.blue;
            }
        }

        return red * green * blue;
    }
}
