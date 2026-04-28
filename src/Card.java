public class Card {
    private String rank;
    private String suit;
    private String displayName;
    private int value;
    private boolean wild;
    private String drawQuote;
    private String winQuote;
    private String loseQuote;
    private String role;
    private String color;
    private String imagePrompt;

    public Card(String rank, String suit, String displayName, int value, boolean wild,
                String drawQuote, String winQuote, String loseQuote,
                String role, String color, String imagePrompt) {

        this.rank = rank;
        this.suit = suit;
        this.displayName = displayName;
        this.value = value;
        this.wild = wild;
        this.drawQuote = drawQuote;
        this.winQuote = winQuote;
        this.loseQuote = loseQuote;
        this.role = role;
        this.color = color;
        this.imagePrompt = imagePrompt;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }

    public boolean isWild() {
        return wild;
    }

    public boolean isAce() {
        return rank.equalsIgnoreCase("A");
    }

    public String getDrawQuote() {
        return drawQuote;
    }

    public String getWinQuote() {
        return winQuote;
    }

    public String getLoseQuote() {
        return loseQuote;
    }

    public String getRole() {
        return role;
    }

    public String getColor() {
        return color;
    }

    public String getImagePrompt() {
        return imagePrompt;
    }

    public String toString() {
        String cardText = rank + " of " + suit + " - " + displayName;

        if (wild) {
            cardText += " [WILD]";
        }

        return cardText;
    }
}
