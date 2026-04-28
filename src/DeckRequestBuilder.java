/*
 * Name: Mark Meyer
 * Class: CYBR 150
 * Project: Custom Blackjack Deck Game
 * File: DeckRequestBuilder.java
 *
 * Purpose:
 * This class asks the user a few simple questions and creates a deck_request.csv
 * file that can be pasted into AI with the AI instructions file.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class DeckRequestBuilder {

    public static void buildDeckRequest(Scanner scanner) {
        try {
            System.out.println("\nCUSTOM DECK BUILDER");
            System.out.println("This creates a deck_request.csv file that can be pasted into AI.");

            System.out.print("What group do you want your card deck to be modeled from? ");
            String group = scanner.nextLine();

            System.out.print("What are a few favorite or associated colors with the group? ");
            String colors = scanner.nextLine();

            System.out.print("What websites should AI use for research? Separate with commas: ");
            String websites = scanner.nextLine();

            System.out.print("What are a few individuals you would like to include? Separate with commas: ");
            String people = scanner.nextLine();

            System.out.print("Add any AI prompt to customize this deck: ");
            String prompt = scanner.nextLine();

            PrintWriter output = new PrintWriter("deck_requests/deck_request.csv");

            output.println("field,value");
            output.println("group,\"" + group + "\"");
            output.println("colors,\"" + colors + "\"");
            output.println("websites,\"" + websites + "\"");
            output.println("people,\"" + people + "\"");
            output.println("prompt,\"" + prompt + "\"");

            output.close();

            createInstructionsFile();

            System.out.println("\nDeck request created:");
            System.out.println("deck_requests/deck_request.csv");
            System.out.println("deck_requests/AI_INSTRUCTIONS_TO_PASTE_WITH_DECK_REQUEST.txt");
            System.out.println("\nPaste both files into AI to generate a final playable deck CSV.");
            System.out.println("Then save the final CSV into the decks folder.");

        } catch (Exception e) {
            System.out.println("Error creating deck request: " + e.getMessage());
        }
    }

    private static void createInstructionsFile() {
        try {
            PrintWriter output = new PrintWriter("deck_requests/AI_INSTRUCTIONS_TO_PASTE_WITH_DECK_REQUEST.txt");

            output.println("Use the uploaded deck_request.csv to generate a complete playable Blackjack deck CSV.");
            output.println();
            output.println("AI generate a card deck file that will be used in my Java Blackjack game.");
            output.println("Output only the final CSV FILE. Do not add markdown or explanation.");
            output.println();
            output.println("Required final CSV columns:");
            output.println("rank,suit,displayName,value,wild,drawQuote,winQuote,loseQuote,role,color,imagePrompt");
            output.println();
            output.println("Rules:");
            output.println("1. Generate exactly 52 cards: A,2,3,4,5,6,7,8,9,10,J,Q,K for Hearts, Diamonds, Clubs, and Spades.");
            output.println("2. K, Q, and J must be people only.");
            output.println("3. Aces may be a person or a place.");
            output.println("4. Cards 10 through 2 must not be people. Use places, traditions, objects, sayings, events, mascots, symbols, or concepts related to the theme.");
            output.println("5. Every card must include a drawQuote, winQuote, and loseQuote. Do not use a Result column.");
            output.println("6. If websites are provided, use them to infer realistic details, history, tone, and imagePrompt ideas.");
            output.println("7. imagePrompt should describe a future playing-card image concept, not a URL.");
            output.println("8. CSV values containing commas must be wrapped in quotes.");
            output.println("9. Blackjack values: A=11, K=10, Q=10, J=10, number cards equal their number.");
            output.println("10. Keep the deck fun, funny, and playful.");
            output.println("11. Generate humorous drawQuote, winQuote, and loseQuote lines for every card.");
            output.println("12. Try to assign female names to Queen cards first when possible.");
            output.println("13. Try to assign male names to King or Jack cards when possible.");
            output.println("14. Do not force gender if the name is unclear.");
            output.println("15. Assign quotes and names that will match the associated number, like Seventh inning stretch = 7 card or Double = 2 card. ");
            output.println();

            output.close();
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println("Error creating deck request.");
        }

        }
    }
