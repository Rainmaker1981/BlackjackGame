# Custom Blackjack Deck Game - CYBR 150

## How to Run

1. Open the project in IntelliJ or another Java IDE.
2. Make sure the `src` folder contains:
   - BlackjackGame.java
   - Card.java
   - Deck.java
   - Player.java
   - DeckRequestBuilder.java
3. Make sure the `decks` folder is in the main project folder.
4. Run `BlackjackGame.java`.

## Program Features

- Console-based Blackjack game.
- Uses multiple Java classes to show Object-Oriented Programming.
- Loads playable decks from CSV files stored in the `decks` folder.
- Main menu automatically updates when new CSV files are added to `decks`.
- Includes a custom deck request builder that creates a simple CSV file for AI deck generation.
- Each card can have a draw quote, win quote, lose quote, color, role, and image prompt.

## Menu

1. Build Deck Request
2. Play with any CSV deck found in the `decks` folder
0. Exit

## Notes

This project is intentionally written at a beginner Java level for CYBR 150. It uses classes, objects, ArrayLists, Scanner input, file input, and simple methods.
