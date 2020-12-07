package com.company.menu.actions;

import com.company.contact.Contact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.InMemoryContactsService;

import java.util.Scanner;

public class AddContactMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(InMemoryContactsService inMemoryContactsService) {
        System.out.println("Enter name of contact");
        String name = scanner.nextLine();

        System.out.println("Enter phone number of contact");
        String number = scanner.nextLine();


        inMemoryContactsService.add(new Contact(name, number));

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
}
