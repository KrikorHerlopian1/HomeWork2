/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

Property.java
Property Class.

 */
package kherl1_6617_hw2;

/**
 *
 * @author krikorherlopian
 */
abstract class Property {

    private String streetAddress = "";
    private String city = "";
    private String state = "";
    private String postalCode = "";
    private int numberOfBedrooms = 0;
    private int numberOfBathrooms = 0;
    protected String type = "";
    
    Property() {
    }

    //function that prompts for default property information, like street city state postalcode 
    //number of bedrooms/bathrooms. If any part of the process user types abort , the entire process to be stopped 
    // 0 is returned.
    public int promptForInformation() {
        enterStreetAddr("Enter Street address of the property(type Abort to reset)");
        if (streetAddress != null && Common.checkForAbort(streetAddress)) {
            return 0;
        }

        enterCity("Enter City where the property is located(type Abort to reset)");
        if (city != null && Common.checkForAbort(city)) {
            return 0;
        }

        enterState("Enter State where the property is located(type Abort to reset)");
        if (state != null && Common.checkForAbort(state)) {
            return 0;
        }

        enterPostalCode("Enter The postal code of the property (type Abort to reset)");
        if (postalCode != null && Common.checkForAbort(postalCode)) {
            return 0;
        }

        enterNumOfBedrooms("Enter The number of bedrooms the property has (type Abort to reset)");
        if (numberOfBedrooms == -1) {
            return 0;
        }
        enterNumOfBathrooms("Enter The number of bathrooms the property has (type Abort to reset)");
        if (numberOfBathrooms == -1) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        String result = "Type                === " + type
                + "\n" + "Street              === " + streetAddress
                + "\n" + "City                === " + city
                + "\n" + "State               === " + state
                + "\n" + "Postal Code         === " + postalCode
                + "\n" + "Number of bedrooms  === " + numberOfBedrooms
                + "\n" + "Number of bathrooms === " + numberOfBathrooms;
        return result;
    }

    //function that implements prompting user to enter number of bedrooms.
    public int enterNumOfBedrooms(String message) {
        numberOfBedrooms = Common.enterInt(message);
        return numberOfBedrooms;
    }

    //function that implements prompting user to enter street address.
    public String enterStreetAddr(String message) {
        streetAddress = Common.enterString(message);
        return streetAddress;
    }

    //function that implements prompting user to enter city.
    public String enterCity(String message) {
        city = Common.enterString(message);
        return city;
    }

    //function that implements prompting user to enter state.
    public String enterState(String message) {
        state = Common.enterString(message);
        return state;
    }

    //function that implements prompting user to enter postal code.
    public String enterPostalCode(String message) {
        postalCode = Common.enterString(message);
        return postalCode;
    }

    //function that implements prompting user to enter number of bathrooms.
    public int enterNumOfBathrooms(String message) {
        numberOfBathrooms = Common.enterInt(message);
        return numberOfBathrooms;
    }

}
