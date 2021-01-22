package com.company.menu.actions;

import com.company.contact.Contact;
import com.company.contact.NumberContact;
import com.company.contact.contactsService.ContactsService;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddPhoneContactMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(ContactsService contactsService) {
        System.out.println("Enter name of contact");
        String name = scanner.nextLine();

        System.out.println("Enter phone number of contact");
        String number = scanner.nextLine();
        String result = Stream.of(number)
                .filter(s -> (s.matches("(\\+380)[\\d]{9}") || s.matches("(0)[\\d]{9}")))
                .map(s -> {
                    if (s.matches("(\\+380)[\\d]{9}")) {
                        return s;
                    } else {
                        return "+38" + s;
                    }
                })
                .collect(Collectors.joining());

        if (Objects.nonNull(result)) {
            contactsService.add(new Contact(name, result, Contact.Type.PHONE) {
            });
        } else {
            System.out.println("Incorrect number");
        }
    }


    @Override
    public String getName() {
        return "Add contact using phone number";
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