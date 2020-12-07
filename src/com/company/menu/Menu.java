package com.company.menu;

import com.company.contact.ContactsList;
import com.company.contact.contactsService.InMemoryContactsService;
import com.company.menu.actions.AddContactMenuActions;
import com.company.menu.actions.MenuActions;
import com.company.menu.actions.ReadAllContactsMenuActions;
import com.company.menu.actions.RemoveContactsMenuActions;

import java.util.Scanner;
import java.util.SortedMap;

public class Menu {
    private MenuActions[] menuActions = {
            new ReadAllContactsMenuActions(),
            new AddContactMenuActions(),
            new RemoveContactsMenuActions()};
    private InMemoryContactsService inMemoryContactsService;

    public Menu() {
        this.inMemoryContactsService = new InMemoryContactsService();
    }

    public Menu(InMemoryContactsService inMemoryContactsService) {
        this.inMemoryContactsService = inMemoryContactsService;
    }

    public void StartAction() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < menuActions.length; i++) {
            System.out.println((i + 1) + " - " + menuActions[i].getName());
        }

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= menuActions.length) {
            menuActions[choice - 1].doAction(inMemoryContactsService);

            if (!menuActions[choice - 1].closeAfter()) {
                StartAction();
            }
        } else {
            System.out.println("Oh, no! Something went wrong.");
            System.out.println("Emergency termination of the program");
        }
    }
}

