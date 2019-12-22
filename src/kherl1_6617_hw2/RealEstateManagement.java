/*

CSCI 6617 S2 Fall 2019
Java Programming
KRIKOR HERLOPIAN
Kherl1@unh.newhaven.edu
Instructor: Sheehan

RealEstateManagement.java
Application for a realty company that helps the company manage the properties they sell or rent to potential buyers.

 */
package kherl1_6617_hw2;

import java.util.*;

/**
 *
 * @author krikorherlopian
 */
public class RealEstateManagement {

    static ArrayList<Property> listOfProperties = new ArrayList<Property>();

    /**
     * @param args the command line arguments. Main function that loops for ever
     * until user selects Exit from menu and exit check function returns 0. if
     * user selects menu D show listings function is called. if user selects a b
     * or c add new property function IS called.If it returns 0 in add new
     * property, it means user aborted the process thus return to main menu.Else
     * property added successfully to the list.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Real Estate Management Application");
        OUTER:
        while (true) {
            System.out.println("Select one of choices below in the menu \na. Create house listing\n"
                    + "b. Create condominium listing\n"
                    + "c. Create apartment listing\n"
                    + "d. Show listings\n"
                    + "e. Exit");
            int selectedMenu = selectMenu();
            switch (selectedMenu) {
                case 0:
                    if (exitCheck() == 0) {
                        break OUTER;
                    }
                    break;
                case 4:
                    showListings();
                    break;
                default:
                    int status = addNewProperty(selectedMenu);
                    if (status == 0) {
                        System.out.println("You aborted, all new property data entered are deleted.You can start newly.");
                        //listOfProperties = new ArrayList<>(); This line was deleting all properties when aborted. thats why commented.
                        break;
                    } else {
                        System.out.println("Successfully added new Property");
                    }
                    break;
            }
        }
    }

    //function that asks user if he wants to exit application, if he types y or Y 0 is returned to exit else 1 is returned.
    static int exitCheck() {
        System.out.println("Are you sure you want to exit?(Y or y to exit)");
        Scanner sc = new Scanner(System.in);
        String valueEntered = sc.nextLine();
        //if user types lets say yes or yeh or ye or yay.First character is checked, if y exit app.
        if (valueEntered != null && !valueEntered.trim().equals("")
                && valueEntered.trim().toLowerCase().charAt(0) == 'y') {
            System.out.println("We are sad to see you go");
            return 0;
        } else {
            System.out.println("You didnt enter Y or y, but " + valueEntered + " so continue.");
        }
        return 1;
    }

    /*
        function that adds new property.if option selected is a, its house.If b, its Condominium else its apartment.
        It calls the promptForInformation function ( in case of house it will call promptForInformation function in house class)      
        If promptForInformation returns  0  it means user aborted so  dont add the property to arraylist 
        else add  it to arraylist and return 1.
     */
    static int addNewProperty(int selectedMenu) {
        Property newProperty;
        switch (selectedMenu) {
            case 1:
                newProperty = new House();
                break;
            case 2:
                newProperty = new Condominium();
                break;
            default:
                newProperty = new Apartment();
                break;
        }
        //if 0 is returned, means user typed abort.So return 0
        if (newProperty.promptForInformation() == 0) {
            return 0;
        }
        listOfProperties.add(newProperty);
        return 1;
    }

    //function that prints out all properties added by the user.
    static void showListings() {
        //if no property added , print no properties added and return.
        if (listOfProperties.isEmpty()) {
            System.out.println("No Properties added.");
            return;
        }
        System.out.println("==========================================");
        //loop all over properties one by one and print their information on scree.
        for (int i = 0; i < listOfProperties.size(); i++) {
            Property property = listOfProperties.get(i);
            System.out.println("Property Index      === " + (i + 1));
            System.out.println(property);
            System.out.println("==========================================");
        }

    }

    //function thats expects user to select one of menu choices.if no valid input entered, user prompted to enter again.
    static int selectMenu() {
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.nextLine();
        if (menuChoice != null && menuChoice.trim().toLowerCase().equals("a")) {
            return 1;
        } else if (menuChoice != null && menuChoice.trim().toLowerCase().equals("b")) {
            return 2;
        } else if (menuChoice != null && menuChoice.trim().toLowerCase().equals("c")) {
            return 3;
        } else if (menuChoice != null && menuChoice.trim().toLowerCase().equals("d")) {
            return 4;
        } else if (menuChoice != null && menuChoice.trim().toLowerCase().equals("e")) {
            return 0;
        }else {
            System.out.println("Wrong Input " + menuChoice + " .Please enter one letter of a, b, c, d, or e");
            return selectMenu();
        }
    }
}
