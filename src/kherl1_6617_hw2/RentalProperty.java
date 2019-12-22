/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

RentalProperty.java
Rental Property that inherits from Property.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
abstract class RentalProperty extends Property {

    //Monthly rental fee
    private double monthlyFee = 0;
    //The number of months for the lease period
    private int numberOfMonthsLease = 0;

    RentalProperty() {
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n" + "Monthly Rental Fee  === " + Common.format(monthlyFee)
                + "\n" + "NO of LEASE MONTHS  === " + numberOfMonthsLease;
    }

    @Override
    public int promptForInformation() {
        int value = super.promptForInformation();
        if (value == 0) {
            return value;
        }
        enterMonthlyFee("Enter Monthly rental fee for the apartment (type Abort to reset)");
        if (monthlyFee == -1) {
            return 0;
        }
        enterNumberOfMonthsLease("Enter The number of months for the lease period (type Abort to reset)");
        if (numberOfMonthsLease == -1) {
            return 0;
        }
        return 1;
    }

    //function that implements prompting user to enter The number of months for the lease period.
    public int enterNumberOfMonthsLease(String message) {
        numberOfMonthsLease = Common.enterInt(message);
        return numberOfMonthsLease;
    }

    //function that implements prompting user to enter The Monthly rental fee
    public double enterMonthlyFee(String message) {
        monthlyFee = Common.enterDouble(message);
        return monthlyFee;
    }

}
