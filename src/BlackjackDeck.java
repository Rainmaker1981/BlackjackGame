import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackDeck {

    private ArrayList<String> cardNames;
    private ArrayList<Integer> cardValues;
    private ArrayList<Boolean> wildCards;
    private ArrayList<String> drawQuotes;
    private ArrayList<String> winQuotes;
    private ArrayList<String> loseQuotes;

    public BlackjackDeck(String filePath) {
        cardNames = new ArrayList<String>();
        cardValues = new ArrayList<Integer>();
        wildCards = new ArrayList<Boolean>();
        drawQuotes = new ArrayList<String>();
        winQuotes = new ArrayList<String>();
        loseQuotes = new ArrayList<String>();

        loadDeck(filePath);
        shuffleDeck();
    }

    public void loadDeck(String filePath) {
        try {
            File deckFile = new File(filePath);
            Scanner fileScanner = new Scanner(deckFile);

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] parts = line.split(",");

                if (parts.length >= 8) {
                    String rank = cleanText(parts[0]);
                    String suit = cleanText(parts[1]);
                    String displayName = cleanText(parts[2]);
                    int value = Integer.parseInt(cleanText(parts[3]));
                    boolean wild = Boolean.parseBoolean(cleanText(parts[4]));
                    String drawQuote = cleanText(parts[5]);
                    String winQuote = cleanText(parts[6]);
                    String loseQuote = cleanText(parts[7]);

                    String fullCardName = displayName + " - " + rank + " of " + suit;

                    cardNames.add(fullCardName);
                    cardValues.add(value);
                    wildCards.add(wild);
                    drawQuotes.add(drawQuote);
                    winQuotes.add(winQuote);
                    loseQuotes.add(loseQuote);
                }
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading deck file: " + filePath);
            System.out.println("Make sure the deck is inside the decks folder.");
        }
    }

    public void shuffleDeck() {
        ArrayList<Integer> cardOrder = new ArrayList<Integer>();

        for (int i = 0; i < cardNames.size(); i++) {
            cardOrder.add(i);
        }

        Collections.shuffle(cardOrder);

        ArrayList<String> shuffledNames = new ArrayList<String>();
        ArrayList<Integer> shuffledValues = new ArrayList<Integer>();
        ArrayList<Boolean> shuffledWildCards = new ArrayList<Boolean>();
        ArrayList<String> shuffledDrawQuotes = new ArrayList<String>();
        ArrayList<String> shuffledWinQuotes = new ArrayList<String>();
        ArrayList<String> shuffledLoseQuotes = new ArrayList<String>();

        for (int i = 0; i < cardOrder.size(); i++) {
            int oldIndex = cardOrder.get(i);

            shuffledNames.add(cardNames.get(oldIndex));
            shuffledValues.add(cardValues.get(oldIndex));
            shuffledWildCards.add(wildCards.get(oldIndex));
            shuffledDrawQuotes.add(drawQuotes.get(oldIndex));
            shuffledWinQuotes.add(winQuotes.get(oldIndex));
            shuffledLoseQuotes.add(loseQuotes.get(oldIndex));
        }

        cardNames = shuffledNames;
        cardValues = shuffledValues;
        wildCards = shuffledWildCards;
        drawQuotes = shuffledDrawQuotes;
        winQuotes = shuffledWinQuotes;
        loseQuotes = shuffledLoseQuotes;
    }

    public int cardsLeft() {
        return cardNames.size();
    }

    public String drawCardName() {
        if (cardNames.size() > 0) {
            return cardNames.remove(0);
        } else {
            return "";
        }
    }

    public int drawCardValue() {
        if (cardValues.size() > 0) {
            return cardValues.remove(0);
        } else {
            return 0;
        }
    }

    public boolean drawWildCard() {
        if (wildCards.size() > 0) {
            return wildCards.remove(0);
        } else {
            return false;
        }
    }

    public String drawDrawQuote() {
        if (drawQuotes.size() > 0) {
            return drawQuotes.remove(0);
        } else {
            return "";
        }
    }

    public String drawWinQuote() {
        if (winQuotes.size() > 0) {
            return winQuotes.remove(0);
        } else {
            return "";
        }
    }

    public String drawLoseQuote() {
        if (loseQuotes.size() > 0) {
            return loseQuotes.remove(0);
        } else {
            return "";
        }
    }

    public void showDeckPreview() {
        System.out.println("\nDeck preview:");

        int cardsToShow = 5;

        if (cardNames.size() < 5) {
            cardsToShow = cardNames.size();
        }

        for (int i = 0; i < cardsToShow; i++) {
            System.out.println("- " + cardNames.get(i) + " (" + cardValues.get(i) + ")");
        }

        System.out.println("Cards in deck: " + cardsLeft());
    }

    public String cleanText(String text) {
        text = text.trim();

        if (text.startsWith("\"")) {
            text = text.substring(1);
        }

        if (text.endsWith("\"")) {
            text = text.substring(0, text.length() - 1);
        }

        return text;
    }
}