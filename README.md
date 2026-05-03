# Custom AI Blackjack Deck Game

**Name:** Mark Meyer  
**Class:** CYBR 150  
**Project:** Custom AI Blackjack Deck Game

## Project Overview

This Blackjack game uses a custom CSV card deck. Instead of a normal deck in the program, the game loads playable card data from the `decks` folder. This allows the game to use themed decks with custom card names, Blackjack values, wild card flags, and short quotes. Which brings us to the AI portion the deck request builder. That part of the program creates a `deck_request.txt` file that can be pasted into an AI tool to help generate a new custom Blackjack CSV deck.

I started this project with just building a game but found that to be easy so how could I make it better. By answering a few questions you get to create content that is tailored to an individual.

## Instructions for making a deck

Once you complete the `deck_request.txt` Upload it into a AI program along with “Convert my uploaded .txt into a downloadable CSV file” for the prompt.  This should output a CSV file in the correct format which you will place into the decks folder. Just hit return to update the menu and then select your newly created deck. 

## Main Features

- Plays Blackjack game.
- Automatically finds CSV deck files in the `decks` folder.
- Lets the user select which custom deck to play within the menu.
- Loads card names, values, wild card status, and quotes from the CSV file.
- Shuffles the deck before each hand.
- Deals cards to the player and dealer.
- Allows the player to hit or stay.
- Dealer hits until reaching at least 17.
- Handles Ace values by reducing an Ace from 11 to 1 when needed.
- Displays draw quotes, win quotes, and lose quotes from the custom deck.
- Includes a deck request builder for creating future AI-generated decks.

## Project Structure

```text
BlackjackGame/
├── src/
│   ├── BlackjackDeck.java
│   ├── BlackjackHand.java
│   ├── DeckRequestBuilder.java
│   └── driver.java
├── decks/
│   └── custom playable CSV deck files
├── deck_requests/
│   └── deck_request.txt
└── README.md
```

## Java File Descriptions

### `BlackjackDeck.java`

This class handles the custom deck. It loads the CSV file, stores the card information in ArrayLists, shuffles the deck, and provides methods for drawing card names, values, wild card flags, and quotes.

The deck uses separate ArrayLists for:

- Card names
- Card values
- Wild card status
- Draw quotes
- Win quotes
- Lose quotes

It also includes a `showDeckPreview()` method that displays the first few cards and shows how many cards are loaded.

### `BlackjackHand.java`

This class represents either the player's hand or the dealer's hand. It stores the cards dealt to that hand and calculates the current Blackjack total.

Important jobs handled by this class include:

- Adding a card to a hand
- Calculating the hand value
- Adjusting Aces from 11 to 1 if the hand would bust
- Checking whether the hand busted
- Showing the full hand
- Showing only the dealer's first card
- Returning win, lose, and draw quotes

### `DeckRequestBuilder.java`

This class creates a deck request text file. It asks the user for a theme, colors, websites for research, and names or characters to include.

It then writes a file to:

```text
deck_requests/deck_request.txt
```

That file contains instructions for generating a 52-card custom Blackjack CSV deck.

### `driver.java`

This is the main program file. It contains the `main()` method and controls the overall game flow.

The driver file handles:

- Displaying the main menu
- Finding CSV deck files in the `decks` folder
- Letting the user choose a deck
- Starting a new hand
- Handling hit or stay input
- Running the dealer turn
- Deciding the winner
- Displaying end-of-hand quotes

## Future Improvements

Possible future improvements include:

- Add a graphical user interface.
- Add betting or chip tracking.
- Add multiple players.
- Improve CSV parsing so commas inside quoted text work correctly.
- Use the `role`, `color`, and `imagePrompt` fields during gameplay or card display.
- Add card images.
- Add more custom themed decks.
- Rename `driver.java` to follow normal Java class naming style, such as `Driver.java` or `BlackjackGame.java`.

## Notes

This project was created for CYBR 150 as a custom Java Blackjack game. It is meant to show basic Blackjack game logic and object-oriented programming structure.
