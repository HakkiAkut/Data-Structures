import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hakkı Can Akut
 */
public class NgramExtractor {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[2]);
        String input= args[0];
        String output= args[1];
        ngram(n, input, output);
    }

    /**
     * Firstly resets output file, then gets string from input file and removes surplus space and punctuation also turns
     * string to lowercase then splits words and adds group of n words to HashMap as key initially value is 0.
     * Then splits input string by hashMap keys. If there is one item, it will split string to two. If there 2 item
     * then it will split string to three. So number of items would be (split string size -1). Then we add this number as
     * value to HashMap. After that it will sort and print result in order by value descendingly.
     *
     * @param n          is number of words in hashmap keys
     * @param inputFile  input file path
     * @param outputFile output file path
     */
    public static void ngram(int n, String inputFile, String outputFile) {
        resetResultFile(outputFile);
        String str = "";
        int token = 0;
        File input = new File(inputFile);
        try {
            Scanner scanner = new Scanner(input);
            str = scanner.nextLine();
            while (scanner.hasNextLine()) {
                str = str + " " + scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        str = str.trim().replaceAll(" +", " ");
        str = str.replaceAll("\\p{Punct}", "");
        str = str.toLowerCase();
        String[] array = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length - (n - 1); i++) {
            String key = array[i];
            token++;
            if (n > 1) {
                for (int j = 1; j < n; j++) {
                    key = key + " " + array[i + j];
                }
            }
            map.put(key, 0);
        }
        String str2 = "  " + str + "  ";
        for (String key : map.keySet()) {
            map.replace(key, str2.split(" " + key + " ").length - 1);
        }
        LinkedList<Map.Entry<String, Integer>> sortedMap =
                new LinkedList<>(map.entrySet());
        sortedMap.sort(Map.Entry.comparingByValue());
        System.out.println("Total number of tokens: " + token);
        writeResultToFile(outputFile, "Total number of tokens: " + token);
        System.out.println("ngram,count,frequency");
        writeResultToFile(outputFile, "ngram,count,frequency");
        for (int k = sortedMap.size() - 1; k >= 0; k--) {
            System.out.println(sortedMap.get(k).getKey() + "," + sortedMap.get(k).getValue() + "," + ((double) sortedMap.get(k).getValue() / token) * 100);
            writeResultToFile(outputFile, sortedMap.get(k).getKey() + "," + sortedMap.get(k).getValue() + "," + ((double) sortedMap.get(k).getValue() / token) * 100);
        }
    }

    /**
     * method for writing result to file
     *
     * @param filename output file path
     * @param str      string will be writing
     */
    public static void writeResultToFile(String filename, String str) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(str + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * resets output file
     *
     * @param filename output file path
     */
    public static void resetResultFile(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write("");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

}
