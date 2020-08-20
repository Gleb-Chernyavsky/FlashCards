import java.io.*;
import java.util.*;

public class StepSix {
    public  static List<String>  list = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    static String readingInfo() {
        String string12 = scanner.nextLine();
        list.add(string12);
        return string12;
    }
    static void writingInfo(String g) {

        list.add(g);
        System.out.println(g);
    }
    public static void main(String[] args) {
        String str = "";
        Map<String, String> cards = new LinkedHashMap<>();
        Map<String, Integer> errors = new LinkedHashMap<>();

        Random random = new Random();
        do {
            writingInfo("Input the action (add, remove, import, export, ask, exit," +
                    " log, hardest card, reset stats): ");
            str = readingInfo();
            String rem = "";

            switch (str) {
                case ("add"):
                    writingInfo("The card: ");
                    String str1 = readingInfo();

                    if (cards.containsKey(str1)) {
                        writingInfo("The card \"" + str1 + "\" already exists.");
                        continue;
                    }
                    writingInfo("The definition of the card: ");
                    String str2 = readingInfo();
                    if (cards.containsValue(str2)) {
                        writingInfo("The definition \"" + str2 + "\" already exists.");
                        continue;
                    }
                    cards.put(str1, str2);
                    errors.put(str1, 0);
                    writingInfo("The pair (\"" + str1 + "\":\"" + str2 + "\") has been added.");
                    break;
                case ("remove"):
                    writingInfo("The card: ");
                    rem = readingInfo();
                    if (cards.containsKey(rem)) {
                        cards.remove(rem);
                        errors.remove(rem);
                        writingInfo("The card has been removed.");
                    } else writingInfo("Can't remove \"" + rem + "\": there is no such card.");
                    break;
                case ("import"):
                writingInfo("File name: ");
                    String filename = readingInfo();
                    File file = new File(filename);
                    int bfr = cards.size();
                    try {
                        Scanner scanner1 = new Scanner(file);
                        int count = cards.size();
                        int counter = 0;
                        String s1 = "";
                        String s2 = "";
                        String s3 = "";

                        while (scanner1.hasNext()) {
                            s1 = scanner1.nextLine();
                            s2 = scanner1.nextLine();
                            s3 = scanner1.nextLine();
                            cards.put(s1, s2);
                            errors.put(s1, Integer.parseInt(s3));
                            counter++;
                        }
                        writingInfo((counter) + " cards have been loaded.");
                    } catch (FileNotFoundException e) {
                        writingInfo("File not found.");
                    }
                    break;
                case ("export"):
                    writingInfo("File name: ");
                    String strOut = readingInfo();
                    File file1 = new File(strOut);
                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter(file1);
                        for (Map.Entry entry : cards.entrySet()) {
                            fileWriter.write(entry.getKey().toString());
                            fileWriter.write("\n");
                            fileWriter.write(entry.getValue().toString());
                            fileWriter.write("\n");
                            fileWriter.write(errors.get(entry.getKey()).toString());
                            fileWriter.write("\n");
                        }
                    } catch (Exception e) {

                    }
                    try {
                        fileWriter.close();
                    } catch (Exception e) {

                    }
                    writingInfo(cards.size() + " cards have been saved.");
                    break;
                case ("ask"):
                    List<String> listKey = new ArrayList<>();
                    List<String> listValue = new ArrayList<>();
                    for (Map.Entry entry : cards.entrySet()) {
                        listKey.add(entry.getKey().toString());
                        listValue.add(entry.getValue().toString());
                    }
                    writingInfo("How many times to ask? ");
                    int times = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < times; i++) {
                        int rnd = random.nextInt(cards.size());
                        writingInfo("Print the definition of \"" + listKey.get(rnd) + "\":");
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
                            errors.put(listKey.get(rnd), errors.get(listKey.get(rnd)) + 1);
                            writingInfo("Wrong answer. The correct one is \"" + listValue.get(rnd) + "\", you've" +
                                    " just written the definition of \"" + oy + "\".");

                        } else {
                            errors.put(listKey.get(rnd), errors.get(listKey.get(rnd)) + 1);
                            writingInfo("Wrong answer. The correct one is \"" + listValue.get(rnd) + "\".");
                        }
                    }
                    break;
                case ("exit"):
                    writingInfo("Bye bye!");
                    break;
                case ("log"):
                    writingInfo("File name:");
                    String nf = readingInfo();
                    File file2 = new File(nf);
                    FileWriter fileWriter2 = null;
                    try {
                        fileWriter2 = new FileWriter(file2);
                        for (String item : list) {
                            fileWriter2.write(item);
                            fileWriter2.write("\n");
                        }
                    } catch (Exception e) {

                    }
                    try {
                        fileWriter2.close();
                    } catch (Exception e) {

                    }
                    writingInfo("The log has been saved.");
                    break;
                case ("hardest card"):
                    int max = 0;
                    String key = "";
                    for (Map.Entry item : errors.entrySet()) {
                        if (Integer.parseInt(item.getValue().toString()) > max) {
                            max = Integer.parseInt(item.getValue().toString());
                            key = item.getKey().toString();
                        }
                    }
                    if (max == 0) {
                        writingInfo("There are no cards with errors.");
                    } else {
                        int count2 = 0;
                        for (Map.Entry item : errors.entrySet()) {
                            if (Integer.parseInt(item.getValue().toString()) == max) {
                                count2++;
                            }
                        }
                        if (count2 == 1) {
                            System.out.print("The hardest card is ");
                            list.add("The hardest card is ");
                            for (Map.Entry item : errors.entrySet()) {
                                if (Integer.parseInt(item.getValue().toString()) == max) {
                                    writingInfo("\"" + item.getKey().toString() + "\". You have " +
                                            max + " errors answering it.");
                                }
                            }
                        } else {
                            System.out.print("The hardest cards are ");
                            list.add("The hardest cards are ");
                            int count3 = 0;
                            for (Map.Entry item : errors.entrySet()) {
                                if (Integer.parseInt(item.getValue().toString()) == max) {
                                    count3++;
                                    if (count3 == 1) {
                                        System.out.print("\"" + item.getKey().toString() + "\"");
                                        list.add("\"" + item.getKey().toString() + "\"");
                                    } else {
                                        System.out.print(", \"" + item.getKey().toString() + "\"" );
                                        list.add("\"" + Integer.parseInt(item.getValue().toString()) + "\"");
                                    }
                                }
                            }
                            writingInfo(". You have " + max + " errors answering them.");
                        }
                    }
                    break;
                case ("reset stats"):
                    for (Map.Entry item : errors.entrySet()) {
                        errors.put(item.getKey().toString(), 0);
                    }
                    writingInfo("Card statistics has been reset.");
                    break;
                default:
                    break;
            }
        } while (!str.equals("exit"));
    }
}
