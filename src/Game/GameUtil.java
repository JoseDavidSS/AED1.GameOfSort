package Game;

import Logic.Lists.QList;

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

        String file = "src/Game/data/names.txt";
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

    /**
     * Sorts by age
     * @param list QList with numbers
     */
    public static void quickSort(QList list){
        quickSort(list, 0, list.getLength()-1);
    }

    private static void quickSort(QList list, int low, int high){
        // Check for empty or null array
        if (list == null || list.getLength() == 0){
            return;
        }
        if (low >= high){
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = list.index(middle); //remember to add get age

        // Make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j)
        {
            // Check until all values on left side array are lower than pivot
            while (list.index(i) < pivot) {
                i++;
            }
            // Check until all values on left side array are greater than pivot
            while (list.index(j) > pivot) {
                j--;
            }
            // Comparing values from both side of lists to swap them if necessary
            if (i <= j)
            {
                swap (list, i, j);
                i++;
                j--;
            }
        }
        // Sort the subarrays recursively
        if (low < j){
            quickSort(list, low, j);
        }
        if (high > i){
            quickSort(list, i, high);
        }
    }

    /**
     *Swap the positions of two nodes
     * @param list List to modify
     * @param i Position of Node 1
     * @param j Position of Node 2
     */

    private static void swap(QList list, int i, int j){
        int tmp = list.index(i);
        list.setIndex(i, list.index(j));
        list.setIndex(j, tmp);
    }

    /**
     * Randomize the order of the list
     * @param list a Dragons ArrayList
     */
    public static void unSort(QList list){
        Random r = new Random();
        for (int i = 0; i < list.getLength(); i++){
            int rand = r.nextInt(list.getLength());
            swap(list, i, rand);
        }
    }
}
