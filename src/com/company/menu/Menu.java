package com.company.menu;

import com.company.contact.contactsService.ContactsService;
import com.company.contact.contactsService.InMemoryContactsService;
import com.company.menu.actions.MenuActions;

import java.util.Scanner;

public class Menu {
    private MenuActions[] actions;
    private Scanner scanner;
    private ContactsService contactsService;

    public Menu(MenuActions[] actions, Scanner scanner) {
        this.actions = actions;
        this.scanner = scanner;
        contactsService = new InMemoryContactsService();
    }

    public Menu(MenuActions[] actions, Scanner scanner, ContactsService contactsService) {
        this.actions = actions;
        this.scanner = scanner;
        this.contactsService = contactsService;
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = getMenuIndexFromUser();
            if (!validateMenuIndex(choice)) {
                System.out.println("Invalid input");
                continue;
            }


            actions[choice].doAction(contactsService);
            if (actions[choice].closeAfter()) break;
        }
    }


    private boolean validateMenuIndex(int choice) {
        return choice >= 0 && choice < actions.length;
    }

    private int getMenuIndexFromUser() {
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice - 1;
    }


    private void showMenu() {
        for (int i = 0; i < actions.length; i++) {

            System.out.printf("%d - %s\n", (i + 1), actions[i].getName());
        }

    }

}

