import java.util.ArrayList;

public class BlackjackHand {

    private String name;
    private ArrayList<String> cardNames;
    private ArrayList<Integer> cardValues;
    private ArrayList<Boolean> wildCards;
    private ArrayList<String> drawQuotes;
    private ArrayList<String> winQuotes;
    private ArrayList<String> loseQuotes;

    public BlackjackHand(String name) {
        this.name = name;
        cardNames = new ArrayList<String>();
        cardValues = new ArrayList<Integer>();
        wildCards = new ArrayList<Boolean>();
        drawQuotes = new ArrayList<String>();
        winQuotes = new ArrayList<String>();
        loseQuotes = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void addCard(String cardName, int cardValue, boolean wildCard,
                        String drawQuote, String winQuote, String loseQuote) {

        cardNames.add(cardName);
        cardValues.add(cardValue);
        wildCards.add(wildCard);
        drawQuotes.add(drawQuote);
        winQuotes.add(winQuote);
        loseQuotes.add(loseQuote);
    }

    public int getHandValue() {
        int total = 0;
        int aceCount = 0;

        for (int i = 0; i < cardValues.size(); i++) {
            total = total + cardValues.get(i);

            if (cardValues.get(i) == 11) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total = total - 10;
            aceCount--;
        }

        return total;
    }

    public boolean isBusted() {
        if (getHandValue() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public void showHand() {
        System.out.println(name + " hand:");

        for (int i = 0; i < cardNames.size(); i++) {
            System.out.println("- " + cardNames.get(i) + " (" + cardValues.get(i) + ")");
        }

        System.out.println("Total: " + getHandValue());
    }

    public void showDealerFirstCard() {
        System.out.println("Dealer is showing:");

        if (cardNames.size() > 0) {
            System.out.println("- " + cardNames.get(0) + " (" + cardValues.get(0) + ")");
            System.out.println("- Hidden card");
        }
    }

    public String getLastDrawQuote() {
        if (drawQuotes.size() > 0) {
            return drawQuotes.get(drawQuotes.size() - 1);
        } else {
            return "";
        }
    }

    public boolean lastCardWasWild() {
        if (wildCards.size() > 0) {
            return wildCards.get(wildCards.size() - 1);
        } else {
            return false;
        }
    }

    public String getBestWinQuote() {
        if (winQuotes.size() > 0) {
            return winQuotes.get(winQuotes.size() - 1);
        } else {
            return "";
        }
    }

    public String getBestLoseQuote() {
        if (loseQuotes.size() > 0) {
            return loseQuotes.get(loseQuotes.size() - 1);
        } else {
            return "";
        }
    }
}