package aoc2023.day7;

public enum HandType {
    FIVE_OF_A_KIND(14),
    FOUR_OF_A_KIND(12),
    FULL_HOUSE(10),
    THREE_OF_A_KIND(8),
    TWO_PAIR (6),
    ONE_PAIR (4),
    HIGH_CARD (2);

    private long rank;

    private HandType(long ranking) {
        this.rank = ranking * 99999999999L;
    }

    public long getRank() {
        return this.rank;
    }
}
