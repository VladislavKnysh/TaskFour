package com.company.contact;

import lombok.experimental.SuperBuilder;


public class EmailContact extends Contact {
    private String name;
    private String info;
    private Type type;

    public EmailContact(String name, String info, Contact.Type type) {
        super(name, info, type);
    }
}

