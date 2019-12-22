/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

PurchaseProperty.java
Purchase Property that inherits from Property.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
abstract class PurchaseProperty extends Property {

    //Purchase price of the house or condominium
    private double purchasePrice = 0;
    //Annual amount of taxes for the house or condominium
    private double annualAmountOfTaxes = 0;

    PurchaseProperty() {
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n" + "Purchase Price      === " + Common.format(purchasePrice)
                + "\n" + "Annual TAXES        === " + Common.format(annualAmountOfTaxes);
    }

    @Override
    public int promptForInformation() {
        int value = super.promptForInformation();
        if (value == 0) {
            return value;
        }
        enterPurchasePrice("Enter Purchase price of the house (type Abort to reset)");
        if (purchasePrice == -1) {
            return 0;
        }
        enterAnnualAmountOfTaxes("Enter Annual amount of taxes for the house (type Abort to reset)");
        if (annualAmountOfTaxes == -1) {
            return 0;
        }
        return 1;
    }

    //function that implements prompting user to enter Purchase price of the house or condominium
    public double enterPurchasePrice(String message) {
        purchasePrice = Common.enterDouble(message);
        return purchasePrice;
    }

    //function that implements prompting user to enter Annual amount of taxes for the house or condominium
    public double enterAnnualAmountOfTaxes(String message) {
        annualAmountOfTaxes = Common.enterDouble(message);
        return annualAmountOfTaxes;
    }

}
