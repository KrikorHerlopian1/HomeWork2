/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

Common.java
Common functions implemented in this class

 */
package kherl1_6617_hw2;

import java.util.Scanner;

/**
 *
 * @author krikorherlopian
 */
public final class Common {

    /*
        function that implements prompting user to enter double number.
        IF Abort is typed, -1 is returned. 
        If value entered is double, and number below 0 prompt user to enter again.If number above 0 return the number.
        If value entered is not double, prompt user to enter again.
     */
    static double enterDouble(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String valueEntered = sc.nextLine();
        if (checkForAbort(valueEntered)) {
            return -1;
        } else if (isNumericDouble(valueEntered)) {
            double val = Double.parseDouble(valueEntered);
            if (val < 0) {
                return enterDouble("You entered " + valueEntered + " . Please enter a number equal or above 0. (type Abort to reset)");
            }
            return Double.parseDouble(valueEntered);
        } else {
            return enterDouble("You entered " + valueEntered + " . Please enter a valid input. no  string. (type Abort to reset)");
        }
    }

    /*
        function that implements prompting user to enter int number.
        IF Abort is typed, -1 is returned. 
        If value entered is int, and number below 0 prompt user to enter again.If number above 0 return the number.
        If value entered is not int, prompt user to enter again.
     */
    static int enterInt(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String valueEntered = sc.next();
        if (checkForAbort(valueEntered)) {
            return -1;
        } else if (isNumeric(valueEntered)) {
            int val = Integer.parseInt(valueEntered);
            if (val < 0) {
                return enterInt("You entered " + valueEntered + " . Please enter a number equal or above 0. (type Abort to reset)");
            }
            return Integer.parseInt(valueEntered);
        } else {
            return enterInt("You entered " + valueEntered + " . Please enter a valid input. Only int. no double or string. (type Abort to reset)");
        }
    }

    /*
        This function checks if first 5 letters typed by user is abort
     */
    static Boolean checkForAbort(String value) {
        return !value.trim().equals("")
                && value.trim().length() >= 5
                && value.trim().substring(0, 5).toLowerCase().equals("abort");
    }

    //function that implements prompting user to enter String.
    static String enterString(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String valueEntered = sc.nextLine();
        if (valueEntered == null || valueEntered.trim().equals("")) {
            return enterString("Please enter an input.Empty values are not allowed. (type Abort to reset)");
        }
        return valueEntered;
    }

    //function that check if string is of type double.
    static boolean isNumericDouble(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    //function that check if string is of type int.
    static boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    //format a double number into two places
    static String format(double number) {
        number = Math.round(number * 100);
        number = number / 100;
        return String.format("%.2f", number);
    }
}
