import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String inputFile = args[0];
        String outputFile = args[1];
        resetResultFile(outputFile);
        File input = new File(inputFile);
        try {
            Scanner scanner = new Scanner(input);
            SplayTree splayTree = new SplayTree(null);

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (!str.equals("") && !str.equals(" ")) {
                    switch (str.split(" ")[0]) {
                        case "insert":
                            splayTree.insert(Integer.parseInt(str.split(" ")[1]));
                            splayTree.print(outputFile);
                            break;
                        case "find":
                            splayTree.findNode(Integer.parseInt(str.split(" ")[1]));
                            splayTree.print(outputFile);
                            break;
                        case "remove":
                            splayTree.remove(splayTree.findNode(Integer.parseInt(str.split(" ")[1])));
                            splayTree.print(outputFile);
                            break;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
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
            fileWriter.write(str);
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
