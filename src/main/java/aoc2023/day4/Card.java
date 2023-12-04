package aoc2023.day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Card {
    List<Integer> winners = new ArrayList<>();
    List<Integer> entryNumbers = new ArrayList<>();

    int cardNumber = 0;

    public Card(String line) {
        String[] parts = line.split(":");
        this.cardNumber = Integer.parseInt(parts[0].substring("Card ".length()).trim());

        String[] winnerEntry = parts[1].trim().split("\\|");
        String winnersString = winnerEntry[0];
        String entryString = winnerEntry[1];

        String[] winnersSplit = winnersString.trim().split(" ");
        String[] entrySplit = entryString.trim().split(" ");

        for (String winningNumber : winnersSplit) {
            if (winningNumber.trim().length() > 0) {
                this.winners.add(Integer.parseInt(winningNumber.trim()));
            }
        }

        for (String entryNumber : entrySplit) {
            if (entryNumber.trim().length() > 0) {
                this.entryNumbers.add(Integer.parseInt(entryNumber.trim()));
            }
        }
    }

    public long points() {
        int matchCount = 0;
        for (Integer entry : this.entryNumbers) {
            if (this.winners.contains(entry)) {
                if (matchCount == 0) {
                    matchCount = 1;
                } else {
                    matchCount = matchCount * 2;
                }
            }
        }

        return matchCount;
    }

    public List<Card> winners(List<Card> originalCardSet) {
        List<Card> cardsWon = new ArrayList<>();

        int matchCount = 0;
        for (Integer entry : this.entryNumbers) {
            if (this.winners.contains(entry)) {
                matchCount++;
            }
        }

        for (int i=1; i<=matchCount; i++) {
            int wonCardId = this.cardNumber + i;
            Card wonCard = this.fetchCard(originalCardSet, wonCardId);
            if (wonCard != null) {
                cardsWon.add(wonCard);
                cardsWon.addAll(wonCard.winners(originalCardSet));
            }
        }

        return cardsWon;
    }

    private Card fetchCard(List<Card> originalCardSet, int wonCardId) {
        for (Card card : originalCardSet) {
            if (card.cardNumber == wonCardId) {
                return card;
            }
        }
        return null;
    }
}
