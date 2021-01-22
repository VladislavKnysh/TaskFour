package com.company.contact.contactsService;

import com.company.contact.Contact;
import com.company.contact.ContactsList;

public interface ContactsService {
    ContactsList getAll();
    void remove(int index);
    void add(Contact contact);
    void searchName(String string);
    void searchNumber(String string);
    void printToFile();

}
