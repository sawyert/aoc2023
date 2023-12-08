package aoc2023.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
    private final long bid;
    private char[] cards;
    private HandType handType = null;

    Map<Character, Integer> cardCount = new HashMap();

    public HandType handType() {
        return this.handType;
    }
    
    public Hand(String eachLine, boolean part2) {
        String[] parts = eachLine.split(" ");
        this.cards = parts[0].toCharArray();
        this.bid = Integer.parseInt(parts[1]);

        this.addCard(cards[0]);
        this.addCard(cards[1]);
        this.addCard(cards[2]);
        this.addCard(cards[3]);
        this.addCard(cards[4]);

        if (!part2) {
            this.handType = this.workOutHandType(false);
        } else {
            this.handType = this.workOutHandType(true);
        }

    }

    private void addCard(char card) {
        Integer existingCount = cardCount.get(card);
        if (existingCount == null) {
            existingCount = 0;
        }
        existingCount++;
        cardCount.put(card, existingCount);
    }

    private HandType workOutHandType(boolean withJoker) {
        HandType initialHandType = HandType.HIGH_CARD;
        switch (cardCount.size()) {
            case 1 -> {
                initialHandType = HandType.FIVE_OF_A_KIND;
            }
            case 2 -> {
                initialHandType = processTwoCardMatches();
            }
            case 3 -> {
                initialHandType = processThreeCardMatches();
            }
            case 4 -> {
                initialHandType = HandType.ONE_PAIR;
            }
            case 5 -> {
                initialHandType = HandType.HIGH_CARD;
            }
        }

        if (!withJoker) {
            return initialHandType;
        }

        Integer jokerCount = this.cardCount.get('J');
        if (jokerCount == null || jokerCount == 0) {
            return initialHandType;
        }
        switch (jokerCount) {
            case 0:
                return initialHandType;
            case 1:
                switch (initialHandType) {
                    case HIGH_CARD -> {
                        return HandType.ONE_PAIR;
                    }
                    case ONE_PAIR -> {
                        return HandType.THREE_OF_A_KIND;
                    }
                    case TWO_PAIR -> {
                        return HandType.FULL_HOUSE;
                    }
                    case THREE_OF_A_KIND -> {
                        return HandType.FOUR_OF_A_KIND;
                    }
                    case FOUR_OF_A_KIND ->  {
                        return HandType.FIVE_OF_A_KIND;
                    }
                }
                throw new UnsupportedOperationException();

            case 2:
                switch (initialHandType) {
                    case HIGH_CARD -> {
                        return HandType.THREE_OF_A_KIND;
                    }
                    case ONE_PAIR -> {
                        return HandType.THREE_OF_A_KIND;
                    }
                    case TWO_PAIR -> {
                        return HandType.FOUR_OF_A_KIND;
                    }
                    case FULL_HOUSE ->  {
                        return HandType.FIVE_OF_A_KIND;
                    }
                }
                throw new UnsupportedOperationException();

            case 3:
                if (initialHandType.equals(HandType.THREE_OF_A_KIND)) {
                    return HandType.FOUR_OF_A_KIND;
                }
                if (initialHandType.equals(HandType.FULL_HOUSE)) {
                    return HandType.FIVE_OF_A_KIND;
                }
                throw new UnsupportedOperationException();
            case 4,5:
                return HandType.FIVE_OF_A_KIND;
        }
        throw new UnsupportedOperationException();
    }

    private HandType processTwoCardMatches() {
        List<Integer> orderedList = this.cardCount.values().stream().sorted().toList();
        if (orderedList.get(1) == 3) {
            return HandType.FULL_HOUSE;
        } else if (orderedList.get(1) == 4) {
            return HandType.FOUR_OF_A_KIND;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private HandType processThreeCardMatches() {
        List<Integer> orderedList = this.cardCount.values().stream().sorted().toList();
        if (orderedList.get(2) == 3) {
            return HandType.THREE_OF_A_KIND;
        } else {
            return HandType.TWO_PAIR;
        }
    }

    private long getCharScore(Character character) {
        return switch (character) {
            case 'A' -> 14;
            case 'K' -> 13;
            case 'Q' -> 12;
            case 'J' -> 11;
            case 'T' -> 10;
            case '9' -> 9;
            case '8' -> 8;
            case '7' -> 7;
            case '6' -> 6;
            case '5' -> 5;
            case '4' -> 4;
            case '3' -> 3;
            case '2' -> 2;
            default -> throw new UnsupportedOperationException();
        };
    }

    private long getCharScore2(Character character) {
        return switch (character) {
            case 'A' -> 14;
            case 'K' -> 13;
            case 'Q' -> 12;
            case 'J' -> 1;
            case 'T' -> 10;
            case '9' -> 9;
            case '8' -> 8;
            case '7' -> 7;
            case '6' -> 6;
            case '5' -> 5;
            case '4' -> 4;
            case '3' -> 3;
            case '2' -> 2;
            default -> throw new UnsupportedOperationException();
        };
    }

    public long getBid() {
        return this.bid;
    }

    public Long getHandScore() {
        long handScore = 0;

        handScore += this.getCharScore(cards[4]);
        handScore += this.getCharScore(cards[3]) * 99L;
        handScore += this.getCharScore(cards[2]) * 9999L;
        handScore += this.getCharScore(cards[1]) * 999999L;
        handScore += this.getCharScore(cards[0]) * 99999999L;
        handScore += this.handType.getRank();

        return handScore;
    }

    public Long getHandScore2() {
        long handScore = 0;

        handScore += this.getCharScore2(cards[4]);
        handScore += this.getCharScore2(cards[3]) * 99L;
        handScore += this.getCharScore2(cards[2]) * 9999L;
        handScore += this.getCharScore2(cards[1]) * 999999L;
        handScore += this.getCharScore2(cards[0]) * 99999999L;
        handScore += this.handType.getRank();

        return handScore;
    }

    public String cards() {
        StringBuilder returnString = new StringBuilder();
        returnString.append(this.cards[0]);
        returnString.append(this.cards[1]);
        returnString.append(this.cards[2]);
        returnString.append(this.cards[3]);
        returnString.append(this.cards[4]);
        return returnString.toString();

    }
}
