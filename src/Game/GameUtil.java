package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameUtil {

    /**
     * Generates random dragon name from a names text file.
     * @return String random name.
     * @throws IOException in case something goes wrong.
     */
    public static String generateName() throws IOException {

        String file = "C:\\Users\\Kevin Cordero Zúñiga\\IdeaProjects\\Game of Sorts\\src\\Game\\data\\names.txt";
        ArrayList<String> allNames = new ArrayList<>();
        Random r = new Random();

        BufferedReader in = new BufferedReader(new FileReader(file));
        while (in.ready()) {
            allNames.add( in.readLine() );
        }
        in.close();

        String randomName = allNames.get(r.nextInt(allNames.size()));
        return randomName;
    }
}
