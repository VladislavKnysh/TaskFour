package com.company.menu.actions;

import com.company.contact.ContactsList;
import com.company.contact.contactsService.ContactsService;
import com.company.contact.contactsService.InMemoryContactsService;

import javax.security.auth.login.AccountLockedException;

public interface MenuActions {

    void doAction(ContactsService contactsService);

    String getName();

    boolean closeAfter();
}
