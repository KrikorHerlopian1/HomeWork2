/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

House.java
House Property that inherits from PurchaseProperty.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
public class House extends PurchaseProperty {

    House() {
        this.type = "House";
    }

    @Override
    public int promptForInformation() {
        return super.promptForInformation();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
