package com.company.menu.actions;

import com.company.contact.Contact;
import com.company.contact.contactsService.ContactsService;

import java.util.Scanner;

public class AddContactMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(ContactsService contactsService) {
        System.out.println("Enter name of contact");
        String name = scanner.nextLine();

        System.out.println("Enter phone number of contact");
        String number = scanner.nextLine();
        switch (checkNumber(number)) {
            case CORRECT:
                contactsService.add(new Contact(name, number));
            break;
            case INCORRECT:
            System.out.println("Incorrect number");
            break;
            case MEDIOCRE:
                contactsService.add(new Contact(name, ("+38"+number)));
                break;

        }


    }


    @Override
    public String getName() {
        return "Add contact";
    }

    @Override
    public boolean closeAfter() {
        System.out.println("Do you want to close program?(1 - yes,2 - no)");

        switch (scanner.nextInt()) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Oh, no! Something went wrong.");
                System.out.println("Emergency termination of the program");
                return true;
        }
    }

    private NumberCondition checkNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return NumberCondition.INCORRECT;
            }
        }
        if (number.matches("(\\+380)[\\d]{9}")) {
            return NumberCondition.CORRECT;
        }else if (number.matches("(0)[\\d]{9}")){
            return NumberCondition.MEDIOCRE;
        }else {return NumberCondition.INCORRECT;}
    }

    enum NumberCondition{
        CORRECT, INCORRECT, MEDIOCRE;
    }
}
