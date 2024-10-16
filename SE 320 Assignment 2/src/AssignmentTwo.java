//*******************************************************
// Class: AssignmentTwo
// Author: Hugh Seeley
// Date Created: 20241014
// Modified:20241015
//
// Attributes: None
//
// Methods: +main(String[]): void - main method, executes code
//          -isInRange() : void - checks if user input is within a specified range with assertion.
//
//********************************************************
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentTwo {

    public static void main(String[] args) {
        //creating objects of all classes
        Exercise19_03 exer19 = new Exercise19_03();
        AssignmentTwo assign2 = new AssignmentTwo();

        exer19.Exercise19();
        assign2.isInRange();
    }

    private void isInRange() {
        int intVal = 0;
        java.util.Scanner scan = new java.util.Scanner(System.in); //creates scanner object

        System.out.println("\n\nEnter a number between 1 and 10: ");
        intVal = scan.nextInt();

        assert ((intVal <= 10) && (intVal >= 0)) : " The entered number is out of range"; //assertion (must be enabled using -ea)
    }


}