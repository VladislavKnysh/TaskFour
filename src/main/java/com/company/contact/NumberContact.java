package com.company.contact;



public class NumberContact extends Contact {
    private String name;
    private String info;
    private Type type;


    public NumberContact(String name, String info, Contact.Type type) {
        super(name, info, type);
    }
}
