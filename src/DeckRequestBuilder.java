import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DeckRequestBuilder {

    public static void buildDeckRequest(Scanner scanner) {

        try {
            System.out.println("\nCUSTOM AI DECK BUILDER");
            System.out.println("This creates a deck_request.txt file.");
            System.out.println("Paste the file into AI to generate a custom Blackjack CSV deck.");

            System.out.print("\nWhat group or theme do you want the deck modeled from? ");
            String group = scanner.nextLine();

            System.out.print("What colors match this group or theme? ");
            String colors = scanner.nextLine();

            System.out.print("What websites should AI use for research? Separate with commas: ");
            String websites = scanner.nextLine();

            System.out.print("What people, characters, or names do you want included? Separate with commas: ");
            String people = scanner.nextLine();

            File requestFolder = new File("deck_requests");

            if (!requestFolder.exists()) {
                requestFolder.mkdir();
            }

            FileWriter writer = new FileWriter("deck_requests/deck_request.txt");

            writer.write("Generate a custom Blackjack card deck as a CSV file.\n\n");

            writer.write("Theme or group:\n");
            writer.write(group + "\n\n");

            writer.write("Preferred colors:\n");
            writer.write(colors + "\n\n");

            writer.write("Websites for research:\n");
            writer.write(websites + "\n\n");

            writer.write("People, characters, or names to include:\n");
            writer.write(people + "\n\n");

            writer.write("Important instructions:\n");
            writer.write("- Make the deck funny and creative.\n");
            writer.write("- Keep the quotes short.\n");
            writer.write("- Avoid commas inside quote fields because the Java program uses simple CSV splitting.\n");
            writer.write("- Try to make female names Queens first when it makes sense.\n");
            writer.write("- Use standard Blackjack values.\n");
            writer.write("- Aces should have a value of 11.\n");
            writer.write("- Jacks, Queens, and Kings should have a value of 10.\n");
            writer.write("- Number cards should use their normal number value.\n");
            writer.write("- Use true or false for the wild column.\n\n");

            writer.write("Required CSV header:\n");
            writer.write("rank,suit,displayName,value,wild,drawQuote,winQuote,loseQuote,role,color,imagePrompt\n\n");

            writer.write("Return exactly 52 card rows plus the header row.\n");
            writer.write("Return only the CSV content.\n");
            writer.write("Do not add extra explanation before or after the CSV.\n\n");

            writer.write("Example row:\n");
            writer.write("Ace,Spades,Ace of Spades,11,false,The big dog showed up,That ace saved the day,You wasted an ace,High card,Black,Classic ace of spades playing card\n");

            writer.close();

            System.out.println("\nDeck request created successfully.");
            System.out.println("File saved at: deck_requests/deck_request.txt");

        } catch (Exception e) {
            System.out.println("\nSomething went wrong while creating the deck request.");
        }
    }
}