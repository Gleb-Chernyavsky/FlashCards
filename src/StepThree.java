
import java.util.Arrays;
import java.util.Scanner;

public class StepThree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] array = new String[n * 2];
        int count = 1;
        char quotes = '"';
//        for (int i = 0; i < array.length; i++){
//            array[i] = scanner.nextLine();
//        }

        for (int i = 0; i < array.length; i += 2) {
            System.out.println("The card #" + count + ": ");
            array[i] = scanner.nextLine();
            System.out.println("The definition of the card #" + quotes + count + quotes + ": ");
            array[i + 1] = scanner.nextLine();
            count++;
        }

        for (int i = 0; i < array.length; i += 2) {
            System.out.println("Print the definition of " + quotes + array[i] + quotes + ": ");
            if (scanner.next().equals(array[i + 1])) {
                System.out.println("Correct answer.");
            } else System.out.println("Wrong answer. The correct one is " + quotes + array[i + 1] + quotes + ".");
        }
    }
}

