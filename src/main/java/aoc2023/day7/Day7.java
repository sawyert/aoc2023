package aoc2023.day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day7 {

    private List<Hand> hands = new ArrayList<>();

    public Day7(String[] testInput, boolean part2) {
        for (String eachLine : testInput) {
            this.hands.add(new Hand(eachLine, part2));
        }
    }

    public long execute1() {
        List<Hand> orderedHands = this.hands.stream().sorted(Comparator.comparing(Hand::getHandScore)).toList();
        long rank = 1;
        long winnings = 0;
        for (Hand eachHand : orderedHands) {
            long score = rank * eachHand.getBid();
            System.out.println(rank + "\t" + eachHand.cards() + "\t" + eachHand.handType().toString() + "\t" + eachHand.getBid() + "\t" +  eachHand.getHandScore());
            winnings += score;
            rank++;
        }
        return winnings;
    }

    public long execute2() {
        List<Hand> orderedHands = this.hands.stream().sorted(Comparator.comparing(Hand::getHandScore2)).toList();
        long rank = 1;
        long winnings = 0;
        for (Hand eachHand : orderedHands) {
            long score = rank * eachHand.getBid();
            System.out.println(rank + "\t" + eachHand.cards() + "\t" + eachHand.handType().toString() + "\t" + eachHand.getBid() + "\t" +  eachHand.getHandScore());
            winnings += score;
            rank++;
        }
        return winnings;
    }
}
