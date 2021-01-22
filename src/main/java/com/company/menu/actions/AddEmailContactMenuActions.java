package com.company.menu.actions;

import com.company.contact.Contact;
import com.company.contact.contactsService.ContactsService;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddEmailContactMenuActions implements MenuActions {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void doAction(ContactsService contactsService) {
        System.out.println("Enter name of contact");
        String name = scanner.nextLine();

        System.out.println("Enter email of contact");
        String email = scanner.nextLine();
        String result = Stream.of(email)
                .filter(s -> (s.matches("\\w+[.]*\\w+[@]{1}\\w+([.]{1}\\w{2,3})")))
                .collect(Collectors.joining());

        if (Objects.nonNull(result)) {
            contactsService.add(new Contact(name, result, Contact.Type.EMAIL) {
            });
        } else {
            System.out.println("Incorrect email");
        }
    }


    @Override
    public String getName() {
        return "Add contact using email";
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
