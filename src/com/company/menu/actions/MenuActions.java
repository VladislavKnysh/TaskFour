package com.company.menu.actions;

import com.company.contact.ContactsList;
import com.company.contact.contactsService.InMemoryContactsService;

import javax.security.auth.login.AccountLockedException;

public interface MenuActions {

    void doAction(InMemoryContactsService inMemoryContactsService);

    String getName();

    boolean closeAfter();
}
