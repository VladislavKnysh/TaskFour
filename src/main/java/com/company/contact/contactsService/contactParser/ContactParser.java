package com.company.contact.contactsService.contactParser;


import com.company.contact.Contact;
import com.company.contact.EmailContact;
import com.company.contact.NumberContact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactParser {


    public Contact parse(String user) {
        String name = getData(user, DataPart.NAME);
        String info = getData(user, DataPart.INFO);
        String typeString = getData(user, DataPart.TYPE);
        if (typeString.equalsIgnoreCase("Email")) {
            return createContact(name, info, Contact.Type.EMAIL);
        } else return createContact(name, info, Contact.Type.PHONE);


    }


    private Contact createContact(String name, String info, Contact.Type type) {
        if (type.equals(Contact.Type.EMAIL)) {
            return new EmailContact(name, info, type);
        } else
            return new NumberContact(name, info, type);
    }


    private String getData(String string, DataPart dataPart) {
        Matcher matcher = dataPart.getPattern().matcher(string);
        matcher.find();
        return matcher.group();
    }


    private enum DataPart {
        NAME("(\\w*\\d*)((?=[\\[]))"),
        TYPE("(?<=[\\[])\\w+(?=[:])"),
        INFO("(?<=: ).(\\S)+(?=[\\]])");
        private final String REGEX;

        DataPart(String regex) {
            this.REGEX = regex;
        }

        Pattern getPattern() {
            return Pattern.compile(REGEX);

        }

    }
}
