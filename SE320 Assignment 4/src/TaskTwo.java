//*******************************************************
// Class: TaskTwo
// Author: Hugh Seeley
// Date Created: 20241029
// Modified:20241029
//
// Attributes: None
//
// Methods: +SortFile(): void -
//
//
//********************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TaskTwo {
    public void sortFile() {
        Set<String> words = new TreeSet<>();

        try {
            File file = new File("./src/TextFile.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();  // Converts to lowercase to ensure case insensitivity
                words.add(word);  // Adds word to TreeSet
            }

            scanner.close();

            System.out.println("Non-duplicate words in ascending order:");
            for (String word : words) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

