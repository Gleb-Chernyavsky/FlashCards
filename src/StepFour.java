//package flashcards;

import java.util.*;

public class StepFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> cards = new LinkedHashMap<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("The card #" + count + ": ");
            String str1 = scanner.nextLine();
            while (cards.containsKey(str1)) {
                System.out.println("The card \"" + str1 + "\" already exists. Try again:\n");
                str1 = scanner.nextLine();
            }
            System.out.println("The definition of the card #" + count + ": ");
            String str2 = scanner.nextLine();
            while (cards.containsValue(str2)) {
                System.out.println("The definition \"" + str2 + "\" already exists. Try again:\n");
                str2 = scanner.nextLine();
            }
            cards.put(str1, str2);
            count++;
        }

        for (Map.Entry<String, String> item : cards.entrySet()) {
            System.out.println("Print the definition of \"" + item.getKey() + "\":");
            String string = scanner.nextLine();
            if (item.getValue().equals(string)) {
                System.out.println("Correct answer.");
            } else if (cards.containsValue(string)) {
                String oy = "";
                for (Map.Entry<String, String> b : cards.entrySet()) {
                    if (b.getValue().equals(string)) {
                        oy = b.getKey();
                    }
                }
                System.out.println("Wrong answer. The correct one is \"" + item.getValue() + "\", you've" +
                        " just written the definition of \"" + oy + "\".");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + item.getValue() + "\".");
            }
        }
    }
}