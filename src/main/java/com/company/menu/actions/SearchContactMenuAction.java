package com.company.menu.actions;

import com.company.contact.contactsService.ContactsService;

import java.util.Scanner;

public class SearchContactMenuAction implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(ContactsService contactsService) {
        SearchBy searchBy = chooseSearch();
        String string = getUsersString();
        switch (searchBy) {
            case INFO:
                contactsService.searchNumber(string);
                break;
            case NAME:
                contactsService.searchName(string);
                break;
            default:
                System.out.println("Emergency termination of the action.");
        }
    }


    @Override
    public String getName() {
        return "Perform search";
    }

    @Override
    public boolean closeAfter() {
        {
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

    private SearchBy chooseSearch() {

        System.out.println("1 - Perform search by contact`s info." +
                "\n2 - Perform search by contact`s name.");
        switch (scanner.nextInt()) {
            case 1:
                scanner.nextLine();
                return SearchBy.INFO;
            case 2:
                scanner.nextLine();
                return SearchBy.NAME;
            default:
                scanner.nextLine();
                System.out.println("Oh, no! Something went wrong.");

                return SearchBy.DEFAULT;
        }

    }

    private String getUsersString() {
        System.out.println("Enter your search request: ");
        return scanner.nextLine();
    }

    private enum SearchBy {
        NAME, INFO, DEFAULT;
    }
}

