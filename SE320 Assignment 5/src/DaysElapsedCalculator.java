//*******************************************************
// Class: DaysElapsedCalculator
// Author: Hugh Seeley
// Date Created: 20241124
// Modified:20241126
//
// Attributes: None
//
// Methods: +daysElapsed(): Void - calculates the days elapsed between two dates entered by the user, utilizes util.Day
//          -createDay(String): Day - method used by DaysElapsed to get Day objects from inputs by the user.
//*******************************************************

import java.util.InputMismatchException;
import java.util.Scanner;
public class DaysElapsedCalculator {
    /**
     * Prints the number of days between two selected days.
     */
    public void daysElapsed(){
        int elapsedDays;

        Day birthday = createDay("your birthday"); //In the future could be passed from a higher level, allowing this method to be used almost anywhere.
        Day today = createDay("this day");


        elapsedDays = today.daysFrom(birthday); //
        System.out.println("\nThe amount of days from your Birthday to the selected day are: " + elapsedDays + " days");
    }

    private Day createDay(String nameOfDay){
        Scanner s1 = new Scanner(System.in);
        int inptDay = 0;
        int inptMonth = 0;
        int inptYear = 0;

        System.out.println("Write a 2 digit integer for "+nameOfDay+"'s day"); //getting values
        try{
            inptDay = s1.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input! Please enter a valid 2-digit integer.");
            s1.next(); // Clear the invalid token from the scanner
        }

        System.out.println("Write a 2 digit integer for "+nameOfDay+"'s month");
        try{
            inptMonth = s1.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter a valid 2-digit integer.");
            s1.next(); // Clear the invalid token from the scanner

        }

        System.out.println("Write a 4 digit integer for "+nameOfDay+"'s year");
        try{
            inptYear = s1.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter a valid 4-digit integer.");
            s1.next(); // Clear the invalid token from the scanner
        }

        return new Day(inptYear, inptMonth, inptDay); //creation of the object and return
    }
}
