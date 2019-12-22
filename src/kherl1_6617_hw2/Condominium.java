/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

Condominium.java
Condominium Property that inherits from PurchaseProperty.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
public class Condominium extends PurchaseProperty {

    //Monthly management fee charged by the condominium association
    private double monthlyManagementFee;

    Condominium() {
        this.type = "Condominium";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Monthly FEE         === " + Common.format(monthlyManagementFee);
    }
    
    @Override
    public int promptForInformation() {
        int value = super.promptForInformation();
        if (value == 0) {
            return value;
        }
        enterMonthlyManagementFee("Enter Monthly management fee charged by the condominium association (type Abort to reset)");
        if (monthlyManagementFee == -1) {
            return 0;
        }
        return 1;
    }

    //function that implements feature to enter monthly management fee when user Selects to add Condominium Property.
    public double enterMonthlyManagementFee(String message) {
        monthlyManagementFee = Common.enterDouble(message);
        return monthlyManagementFee;
    }
}
