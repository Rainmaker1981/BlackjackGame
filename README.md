# Mark Meyer
# Cyber 150
# Custom Blackjack Deck Game

## How to Run

1. Open the project in IntelliJ
2. Make sure the `src` folder contains:
   - driver.java
   - Card.java
   - Deck.java
   - Player.java
   - DeckRequestBuilder.java
3. Make sure the `decks` folder is in the main project folder.
4. Run `driver.java`.

## Program Features

- You get to play the game Blackjack with a custom deck.
- Uses multiple Java classes to show Object-Oriented Programming.
- Loads playable decks from CSV files stored in the `decks` folder.
- Main menu automatically updates when new CSV files are added to `decks`.
- Includes a custom deck request builder that creates a simple CSV file for AI deck generation.
- Each card can have a draw quote, win quote, lose quote, color, role, and image prompt.

## Menu

1. Build Deck Request
2. Play with any CSV deck found in the `decks` folder
0. Exit

## AI Notes

Add the AI.txt and deck_request.csv and a generic prompt like, "Generate a CSV file for card deck using the attached files."
