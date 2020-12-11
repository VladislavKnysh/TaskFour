package com.company.menu.actions;

import com.company.contact.ContactsList;
import com.company.contact.contactsService.ContactsService;
import com.company.contact.contactsService.InMemoryContactsService;

import java.util.Scanner;

public class RemoveContactsMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(ContactsService contactsService) {
        System.out.println("Enter index to delete");
        int index = scanner.nextInt();

        scanner.nextLine();


        if (contactsService.getAll().isEmpty()) {
            System.out.println("There is no contacts to delete.");
        } else if (index >= contactsService.getAll().size()) {
            contactsService.remove(contactsService.getAll().size() - 1);
        } else {
            contactsService.remove(index);
        }

    }

    @Override
    public String getName() {
        return "Remove contact";
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
