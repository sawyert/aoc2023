package aoc2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    private List<String> lines = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public Day4(String[] testInput) {
        lines.addAll(Arrays.asList(testInput));
        for (String line : lines) {
            this.cards.add(new Card(line));
        }
    }

    public long execute1() {
        long totalPoints = 0;
        for (Card card : this.cards) {
            totalPoints += card.points();
        }
        return totalPoints;
    }

    public long execute2() {
        List<Card> newCards = new ArrayList<>();

        for (Card card : cards) {
            newCards.addAll(card.winners(this.cards));
        }

        return this.cards.size() + newCards.size();
    }
}
