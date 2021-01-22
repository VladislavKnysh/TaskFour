package com.company;

import com.company.contact.Contact;
import com.company.contact.EmailContact;
import com.company.contact.NumberContact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.InMemoryContactsService;
import com.company.menu.Menu;
import com.company.menu.actions.*;

import java.util.Scanner;

public class Telephone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryContactsService contactsService = new InMemoryContactsService(makeContactsList());
        MenuActions[] menuActions = {new AddPhoneContactMenuActions(), new AddEmailContactMenuActions(),
                new ReadAllContactsMenuActions(), new RemoveContactsMenuActions(),
                new SearchContactMenuAction(), new ExportContactsInFileMenuActions()};
        Menu menu = new Menu(menuActions,scanner,contactsService);
        menu.run();
    }

    static ContactsList makeContactsList(){
        ContactsList contactsList = new ContactsList();
        contactsList.add(new NumberContact("Vasya", "+380663123411", Contact.Type.PHONE));
        contactsList.add(new NumberContact("Petya","+380991231231", Contact.Type.PHONE));
        contactsList.add(new NumberContact("Vanya","+380991435345", Contact.Type.PHONE));
        contactsList.add(new NumberContact("Kostya","+380345345345", Contact.Type.PHONE));
        contactsList.add(new EmailContact("Kostya","123sdfsd@mail.ru", Contact.Type.EMAIL));


        return contactsList;
    }
}
