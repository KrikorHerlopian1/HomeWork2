/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

Apartment.java
Apartment Property that inherits from RentalProperty.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
public class Apartment extends RentalProperty {

    Apartment() {
        this.type = "Apartment";
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
