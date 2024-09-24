//*******************************************************
// Class: AssignmentOne
// Author: Hugh Seeley
// Date Created: 20240923
// Modified:20240923
//
// Attributes: None
//
// Methods: +main(String[]): void - main method, executes code
//          -sumOfIntegers(): void - Adds two integers, prints result. Checks for exception
//          -arrayElement(): void - Fills array with random numbers, displays desired element. Checks for Exception
//
//********************************************************

import java.util.Scanner;
import java.util.Random;

    public class AssignmentOne {

        public static void main(String[] args) {
            AssignmentOne ClassObject = new AssignmentOne();
            ClassObject.sumOfIntegers();
            ClassObject.arrayElement();
        }
        private void sumOfIntegers() {
            int userInputOne = 0;
            int userInputTwo = 0;
            int sumOfInputs = 0;
            boolean ExceptionChecker = false;

            Scanner ScannerOne = new Scanner(System.in);
                while(!ExceptionChecker) {
                try {
                    System.out.print("Input first integer\n");
                    userInputOne = ScannerOne.nextInt();
                    System.out.print("Input second integer\n");
                    userInputTwo = ScannerOne.nextInt();
                    sumOfInputs = userInputOne + userInputTwo;
                    System.out.println("The sum of the inputs is: " + sumOfInputs);
                    ExceptionChecker = true; //breakout condition met when true
                } catch (Exception inputMismatchException) {
                    System.out.println("Error: Incorrect data type entered. Please enter an integer IDIOT.");
                    ScannerOne.next(); // Clears the invalid input to avoid an infinite loop
                }
            }
        }

        //I could include a second try-catch for Input Mismatch but it is not asked for.
        private void arrayElement() {
            int arrayOffset = -1; //offsets the users input to account for Java array numbering 0-99
            int userArrayInput;
            int[] randomArray = new int[100];
            Random randomClassObject = new Random(1000);
            Scanner ScannerTwo = new Scanner(System.in);

            try{
                for(int i = 0; i < randomArray.length; i++) {
                    randomArray[i] = randomClassObject.nextInt();
                   }
                System.out.println("Input an array element number between 1 and 100\n");
                userArrayInput = ScannerTwo.nextInt();
                userArrayInput += arrayOffset; //applying offset
                System.out.println("The value at the selected element is: " + randomArray[userArrayInput]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of Bounds");
            }
        }
    }
