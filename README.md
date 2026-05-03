# Custom Blackjack Deck Game

**Name:** Mark Meyer  
**Class:** CYBR 150  
**Project:** Custom Blackjack Deck Game

## Project Overview

This project is a Java-based Blackjack game that uses a custom card deck loaded from CSV files. Instead of only using a standard 52-card deck, this program allows the player to use themed custom decks with unique card names, suits, values, quotes, roles, colors, and image prompt information.

The main purpose of the project is to show object-oriented programming concepts in Java while building something more interesting than a basic card game. The game separates the responsibilities into different classes so each part of the program has a clear job.

## Main Features

- Plays a command-line Blackjack game.
- Loads custom decks from CSV files.
- Supports custom card names, suits, values, and descriptions.
- Uses separate Java classes for cards, decks, hands, and deck request building.
- Allows the user to create a deck request file for future custom decks.
- Stores playable decks in the `decks` folder.
- Stores deck request files in the `deck_requests` folder.

## Project Structure

```text
BlackjackGame/
├── src/
│   ├── Card.java
│   ├── Deck.java
│   ├── BlackjackHand.java
│   ├── DeckRequestBuilder.java
│   └── driver.java
├── decks/
│   └── custom deck CSV files
├── deck_requests/
│   └── deck request CSV files
└── README.md
```

## File Descriptions

### `Card.java`

Represents one card in the game. Each card stores information such as rank, suit, display name, value, whether it is wild, quotes, role, color, and image prompt text.

### `Deck.java`

Handles the deck of cards. This class is responsible for loading cards from a CSV file, storing them, shuffling them, and dealing cards during the game.

### `BlackjackHand.java`

Represents a player's or dealer's hand. It keeps track of the cards in the hand and calculates the Blackjack value.

### `DeckRequestBuilder.java`

Allows the user to build a deck request file. This is useful when planning a new custom deck before turning it into a playable deck.

### `driver.java`

This is the main program file. It displays the menu, gets user input, starts the game, and connects the other classes together.

## How to Run the Program

### Option 1: Run in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Open the project folder.
3. Make sure the `src`, `decks`, and `deck_requests` folders are present.
4. Open `driver.java`.
5. Click the green Run button.
6. Use the menu in the console.

### Option 2: Run from the Command Line

From the main project folder, compile the Java files:

```bash
javac src/*.java
```

Then run the program:

```bash
java -cp src driver
```

## Menu Options

When the program starts, the user can choose from the main menu:

```text
1. Build Deck Request
2. Play with any CSV deck found in the decks folder
0. Exit
```

## CSV Deck Format

The game expects deck files to be stored as CSV files inside the `decks` folder. Each row represents one card. The deck can include custom information such as:

- Rank
- Suit
- Display name
- Blackjack value
- Wild card status
- Draw quote
- Win quote
- Lose quote
- Role
- Color
- Image prompt

This makes it possible to build themed decks instead of only using normal playing cards.

## Object-Oriented Programming Concepts Used

This project demonstrates several basic Java and object-oriented programming ideas:

- Classes and objects
- Constructors
- Private fields
- Getter methods
- ArrayLists
- File reading
- CSV data handling
- User input with Scanner
- Program organization across multiple files
- Separating responsibilities between classes

## What I Learned

While building this project, I practiced taking a simple game idea and organizing it into separate Java classes. I learned how a card game can be broken into smaller parts: one class for a card, one class for a deck, one class for a hand, and one main driver class to control the program.

I also worked with CSV files so the game can load data instead of having every card hard-coded into the program. That makes the project more flexible and allows custom decks to be added without rewriting the whole game.

## Future Improvements

Possible future improvements include:

- Adding a graphical user interface.
- Adding betting or chip tracking.
- Adding multiple players.
- Improving Ace handling.
- Adding stronger input validation.
- Adding card images based on the image prompt field.
- Creating more custom themed decks.

## Notes

This project was created for CYBR 150 as a custom Blackjack game using Java. It is meant to show both basic game logic and object-oriented programming structure.
