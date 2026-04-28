/*
 * Name: Mark Meyer
 * Class: CYBR 150
 * Project: Custom Blackjack Deck Game
 * File: BlackjackGame.java
 *
 * Purpose:
 * This class contains the main menu and the main Blackjack game logic.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("WELCOME TO CUSTOM BLACKJACK");

        while (keepRunning) {
            ArrayList<File> deckFiles = getDeckFiles();

            showMainMenu(deckFiles);

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                keepRunning = false;
                System.out.println("Thanks for playing!");
            } else if (input.equals("1")) {
                DeckRequestBuilder.buildDeckRequest(scanner);
            } else {
                try {
                    int choice = Integer.parseInt(input);

                    if (choice >= 2 && choice < deckFiles.size() + 2) {
                        File chosenDeck = deckFiles.get(choice - 2);
                        playDeckLoop(scanner, chosenDeck);
                    } else {
                        System.out.println("Invalid menu choice.");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }

        scanner.close();
    }

    public static void showMainMenu(ArrayList<File> deckFiles) {
        System.out.println("\nMAIN MENU");
        System.out.println("1) Build Deck Request");

        for (int i = 0; i < deckFiles.size(); i++) {
            System.out.println((i + 2) + ") Play with " + deckFiles.get(i).getName());
        }

        System.out.println("0) Exit");
    }

    public static ArrayList<File> getDeckFiles() {
        ArrayList<File> deckFiles = new ArrayList<File>();

        File deckFolder = new File("decks");

        if (!deckFolder.exists()) {
            deckFolder.mkdir();
        }

        File[] files = deckFolder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().toLowerCase().endsWith(".csv")) {
                    deckFiles.add(file);
                }
            }
        }

        return deckFiles;
    }

    public static void playDeckLoop(Scanner scanner, File deckFile) {
        boolean keepPlayingSameDeck = true;

        while (keepPlayingSameDeck) {
            Deck deck = new Deck(deckFile.getPath());

            if (deck.cardsLeft() < 10) {
                System.out.println("The deck did not load correctly or does not have enough cards.");
                return;
            }

            playOneHand(scanner, deck);

            System.out.print("\nPlay again with same deck? (y/n): ");
            String answer = scanner.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                keepPlayingSameDeck = false;
            }
        }
    }

    public static void playOneHand(Scanner scanner, Deck deck) {
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");

        System.out.println("\nStarting a new hand...");

        dealCard(player, deck);
        dealCard(dealer, deck);
        dealCard(player, deck);
        dealCard(dealer, deck);

        System.out.println();
        player.showHand();
        System.out.println();
        dealer.showDealerFirstCard();

        boolean playerTurn = true;

        while (playerTurn && !player.isBusted()) {
            System.out.print("\nHit or stay? (h/s): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                dealCard(player, deck);
                System.out.println();
                player.showHand();
            } else if (choice.equalsIgnoreCase("s")) {
                playerTurn = false;
            } else {
                System.out.println("Please type h or s.");
            }
        }

        if (player.isBusted()) {
            System.out.println("\nYou busted!");
            showEndQuote(player, false);
            return;
        }

        System.out.println("\nDealer reveals hand:");
        dealer.showHand();

        while (dealer.getHandValue() < 17) {
            System.out.println("\nDealer hits.");
            dealCard(dealer, deck);
            dealer.showHand();
        }

        decideWinner(player, dealer);
    }

    public static void dealCard(Player player, Deck deck) {
        Card card = deck.drawCard();

        if (card != null) {
            player.addCard(card);
            System.out.println(player.getName() + " drew: " + card);
            System.out.println("Quote: " + card.getDrawQuote());

            if (card.isWild()) {
                System.out.println("Wild card bonus: This card is special in this custom deck!");
            }
        }
    }

    public static void decideWinner(Player player, Player dealer) {
        int playerTotal = player.getHandValue();
        int dealerTotal = dealer.getHandValue();

        System.out.println("\nFINAL RESULTS");
        System.out.println("Player total: " + playerTotal);
        System.out.println("Dealer total: " + dealerTotal);

        if (dealer.isBusted()) {
            System.out.println("Dealer busted. You win!");
            showEndQuote(player, true);
        } else if (playerTotal > dealerTotal) {
            System.out.println("You win!");
            showEndQuote(player, true);
        } else if (playerTotal < dealerTotal) {
            System.out.println("You lose.");
            showEndQuote(player, false);
        } else {
            System.out.println("Push. It is a tie.");
        }
    }

    public static void showEndQuote(Player player, boolean won) {
        Card quoteCard = player.getBestQuoteCard();

        if (quoteCard != null) {
            if (won) {
                System.out.println("Win quote: " + quoteCard.getWinQuote());
            } else {
                System.out.println("Lose quote: " + quoteCard.getLoseQuote());
            }
        }
    }
}
