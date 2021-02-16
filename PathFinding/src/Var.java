import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Var {
    public int height;
    public int width;
    public int numberOfObstacle;

    // constructor method
    public Var() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("var.cfg"))) {
            String string = bufferedReader.readLine();
            height = Integer.parseInt(string.split(": ")[1]);
            string = bufferedReader.readLine();
            width = Integer.parseInt(string.split(": ")[1]);
            string = bufferedReader.readLine();
            numberOfObstacle = Integer.parseInt(string.split(": ")[1]);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


}
