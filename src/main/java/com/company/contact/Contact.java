package com.company.contact;

import lombok.Data;

@Data
public abstract class Contact {
    private String name;
    private String info;
    private Type Type;

    public Contact(String name, String info, Contact.Type type) {
        this.name = name;
        this.info = info;
        Type = type;
    }

    public enum Type{
        PHONE,
        EMAIL;
    }
}
