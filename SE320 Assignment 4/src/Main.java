//*******************************************************
// Class: Main
// Author: Hugh Seeley
// Date Created: 20241029
// Modified:20241029
//
// Attributes: None
//
// Methods: +main(String[]): void - main method, executes code
//********************************************************

public class Main {
    public static void main(String[] args) {
        TaskOne taskOne = new TaskOne();
        TaskTwo taskTwo = new TaskTwo();
        TaskThree taskThree = new TaskThree();

        taskOne.createHashSets();
        taskTwo.sortFile();
        taskThree.formatNumbersUk();
        taskThree.currencyFormatUs();
        taskThree.numberParse();
    }
}