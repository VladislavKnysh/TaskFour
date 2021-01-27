package com.company.contact.contactsService;

import com.company.contact.Contact;
import com.company.contact.ContactsList;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public void searchName(String string) {
        for (int i = 0; i < contactsList.size(); i++) {
            Pattern pattern = Pattern.compile(string.toLowerCase());
            Matcher matcher = pattern.matcher(contactsList.get(i).getName().toLowerCase());
            while (matcher.find()) {

                System.out.println(contactsList.get(i).getName() +
                        " - " + contactsList.get(i).getInfo());

            }
        }
    }


    @Override
    public void searchNumber(String string) {
        for (int i = 0; i < contactsList.size(); i++) {
            Pattern pattern = Pattern.compile(string);
            Matcher matcher = pattern.matcher(contactsList.get(i).getInfo());
            while (matcher.find()) {

                System.out.println(contactsList.get(i).getName() +
                        " - " + contactsList.get(i).getInfo());

            }
        }
    }

    @Override
    public void printToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.txt"))) {
            for (int i = 0; i < contactsList.size(); i++) {
                String type;
                if (contactsList.get(i).getType().equals(Contact.Type.EMAIL)) {
                    type = "Email";
                } else {
                    type = "Phone";
                }
                writer.write(contactsList.get(i).getName()+
                        "["+type+ ": "+contactsList.get(i).getInfo()+"]\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}