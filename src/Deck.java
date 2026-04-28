/*
 * Name: Mark Meyer
 * Class: CYBR 150
 * Project: Custom Blackjack Deck Game
 * File: Deck.java
 *
 * Purpose:
 * This class loads a custom deck from a CSV file, stores the cards,
 * shuffles them, and allows the game to draw cards.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(String filePath) {
        cards = new ArrayList<Card>();
        loadDeckFromCSV(filePath);
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() == 0) {
            return null;
        }

        return cards.remove(0);
    }

    public int cardsLeft() {
        return cards.size();
    }

    private void loadDeckFromCSV(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // skip header row
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.trim().length() > 0) {
                    ArrayList<String> parts = splitCSVLine(line);

                    if (parts.size() >= 11) {
                        String rank = parts.get(0);
                        String suit = parts.get(1);
                        String displayName = parts.get(2);
                        int value = Integer.parseInt(parts.get(3));
                        boolean wild = Boolean.parseBoolean(parts.get(4));
                        String drawQuote = parts.get(5);
                        String winQuote = parts.get(6);
                        String loseQuote = parts.get(7);
                        String role = parts.get(8);
                        String color = parts.get(9);
                        String imagePrompt = parts.get(10);

                        Card card = new Card(rank, suit, displayName, value, wild,
                                drawQuote, winQuote, loseQuote, role, color, imagePrompt);

                        cards.add(card);
                    }
                }
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading deck file: " + e.getMessage());
        }
    }

    /*
     * This method splits a CSV line while respecting commas inside quotation marks.
     * It is a little longer than line.split(",") but prevents quotes with commas from breaking the deck file.
     */
    private ArrayList<String> splitCSVLine(String line) {
        ArrayList<String> parts = new ArrayList<String>();
        String current = "";
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);

            if (letter == '"') {
                insideQuotes = !insideQuotes;
            } else if (letter == ',' && !insideQuotes) {
                parts.add(current);
                current = "";
            } else {
                current += letter;
            }
        }

        parts.add(current);

        return parts;
    }
}
