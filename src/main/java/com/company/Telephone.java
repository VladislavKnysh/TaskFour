package com.company;

import com.company.contact.Contact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.ContactsService;
import com.company.contact.contactsService.InMemoryContactsService;
import com.company.menu.Menu;
import com.company.menu.actions.*;

import java.util.Scanner;

public class Telephone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryContactsService contactsService = new InMemoryContactsService(makeContactsList());
        MenuActions[] menuActions = {new AddContactMenuActions(), new ReadAllContactsMenuActions(),
                new RemoveContactsMenuActions(), new SearchContactMenuAction()};
        Menu menu = new Menu(menuActions,scanner,contactsService);
        menu.run();
    }

    static ContactsList makeContactsList(){
        ContactsList contactsList = new ContactsList();
        contactsList.add(new Contact("Vasya","+380663123411"));
        contactsList.add(new Contact("Petya","+380991231231"));
        contactsList.add(new Contact("Vanya","+380991435345"));
        contactsList.add(new Contact("Kostya","+380345345345"));

        return contactsList;
    }
}
