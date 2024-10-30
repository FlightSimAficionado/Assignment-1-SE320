//*******************************************************
// Class: TaskThree
// Author: Hugh Seeley
// Date Created: 20241029
// Modified:20241029
//
// Attributes: None
//
// Methods: +formatNumbersUk(): void -
//          +currencyFormatUs(): void -
//          +numberParse(): void -
//
//********************************************************

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

    public class TaskThree{
        public void formatNumbersUk() {
            double number = 12345.678;

            // United Kingdom Locale with two decimal places
            NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);
            ukFormat.setMinimumFractionDigits(2);
            ukFormat.setMaximumFractionDigits(2);
            String formattedUK = ukFormat.format(number);

            System.out.println("Formatted in UK locale: " + formattedUK);
        }

            public void currencyFormatUs() {
                double number = 12345.678;

                // U.S. Currency format
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
                String formattedUSCurrency = usCurrencyFormat.format(number);

                System.out.println("Formatted in U.S. currency: " + formattedUSCurrency);
            }

        public void numberParse() {
            String numberString = "12,345.678";

            try {
                // Parse using the default locale for English (U.S.)
                NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
                Number parsedNumber = numberFormat.parse(numberString);

                System.out.println("Parsed number: " + parsedNumber);
            } catch (ParseException e) {
                System.out.println("Error parsing the number.");
                e.printStackTrace();
            }
        }
    }
