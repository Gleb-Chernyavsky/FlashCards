import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.*;

public class StepFive {
    public static void main(String[] args) {
        String str = "";
        Map<String, String> cards = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        do {
            System.out.println("Input the action (add, remove, import, export, ask, exit): ");
            str = scanner.nextLine();
            String rem = "";

            switch (str) {
                case ("add"):
                    System.out.println("The card: ");
                    String str1 = scanner.nextLine();
                    if (cards.containsKey(str1)) {
                        System.out.println("The card \"" + str1 + "\" already exists.");
                        continue;
                    }
                    System.out.println("The definition of the card: ");
                    String str2 = scanner.nextLine();
                    if (cards.containsValue(str2)) {
                        System.out.println("The definition \"" + str2 + "\" already exists.");
                        continue;
                    }
                    cards.put(str1, str2);
                    System.out.println("The pair (\"" + str1 + "\":\"" + str2 + "\") has been added.");
                    break;
                case ("remove"):
                    System.out.println("The card: ");
                    rem = scanner.nextLine();
                    if (cards.containsKey(rem)) {
                        cards.remove(rem);
                        System.out.println("The card has been removed.");
                    } else System.out.println("Can't remove \"" + rem + "\": there is no such card.");
                    break;
                case ("import"):
                    System.out.println("File name: ");
                    String filename = scanner.nextLine();
                    File file = new File(filename);
                    int bfr = cards.size();
                    try {
                        Scanner scanner1 = new Scanner(file);
                        int count = 0;
                        String s1 = "";
                        String s2 = "";
                        while (scanner1.hasNext()) {
                            if (count % 2 == 0) {
                                s1 = scanner1.nextLine();
                            } else {
                                s2 = scanner1.nextLine();
                                cards.put(s1, s2);
                            }
                            count++;
                        }
                        System.out.println((count / 2) + " cards have been loaded.");
                    } catch (Exception e) {
                        System.out.println("File not found.");
                    }
                    break;
                case ("export"):
                    System.out.println("File name: ");
                    String strOut = scanner.nextLine();
                    File file1 = new File(strOut);
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter(file1);
                        for (Map.Entry entry : cards.entrySet()) {
                            fileWriter.write(entry.getKey().toString());
                            fileWriter.write("\n");
                            fileWriter.write(entry.getValue().toString());
                            fileWriter.write("\n");
                        }
                    } catch (Exception e) {

                    }
                    try {
                        fileWriter.close();
                    } catch (Exception e) {

                    }
                    System.out.println(cards.size() + " cards have been saved.");
                    break;
                case ("ask"):
                    List<String> listKey = new ArrayList<>();
                    List<String> listValue = new ArrayList<>();
                    for (Map.Entry entry : cards.entrySet()) {
                        listKey.add(entry.getKey().toString());
                        listValue.add(entry.getValue().toString());
                    }
                    System.out.println("How many times to ask? ");
                    int times = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < times; i++) {
                        int rnd = random.nextInt(cards.size());
                        System.out.println("Print the definition of \"" + listKey.get(rnd) + "\":");
                        String string23 = scanner.nextLine();
                        if (listValue.get(rnd).equals(string23)) {
                            System.out.println("Correct answer.");
                        } else if (cards.containsValue(string23)) {
                            String oy = "";
                            for (Map.Entry<String, String> b : cards.entrySet()) {
                                if (b.getValue().equals(string23)) {
                                    oy = b.getKey();
                                }
                            }
                            System.out.println("Wrong answer. The correct one is \"" + listValue.get(rnd) + "\", you've" +
                                    " just written the definition of \"" + oy + "\".");
                        } else {
                            System.out.println("Wrong answer. The correct one is \"" + listValue.get(rnd) + "\".");
                        }
                    }
                    break;
                case ("exit"):
                    System.out.println("Bye bye!");
                default:
                    break;
            }
        } while (!str.equals("exit"));
    }
}
