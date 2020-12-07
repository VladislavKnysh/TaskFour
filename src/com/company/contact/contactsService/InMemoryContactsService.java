package com.company.contact.contactsService;

import com.company.contact.Contact;
import com.company.contact.ContactsList;

public class InMemoryContactsService implements ContactsService {
    private ContactsList contactsList;

    public InMemoryContactsService() {
        contactsList = new ContactsList();
    }

    public InMemoryContactsService(ContactsList contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);

    }

    @Override
    public void add(Contact contact) {
        contactsList.add(contact);
    }
}
