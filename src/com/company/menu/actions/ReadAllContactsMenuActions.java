package com.company.menu.actions;

import com.company.contact.Contact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.InMemoryContactsService;

import java.util.Scanner;

public class ReadAllContactsMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(InMemoryContactsService inMemoryContactsService) {
        ContactsList contactsList = inMemoryContactsService.getAll();
        if (contactsList.isEmpty()) {
            System.out.println("There is no contacts in your Memory Contacts Service");
        } else {
            for (int i = 0; i < contactsList.size(); i++) {
                Contact contactToDisplay = contactsList.get(i);
                System.out.println("#" + (i + 1) + " " + contactToDisplay.getName() + " " + contactToDisplay.getPhone());
            }
        }
    }

    @Override
    public String getName() {
        return "Read all contacts";
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
