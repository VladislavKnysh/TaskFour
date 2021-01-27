package com.company.contact.contactsService;

import com.company.contact.Contact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.contactParser.ContactParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactsNioService implements ContactsService {
    private Path path;

    public ContactsNioService() {
        path = new File("Contacts.txt").toPath();
    }

    public ContactsNioService(Path path) {
        this.path = path;
    }

    @Override
    public ContactsList getAll() {
        try {
            List<String> lines = Files.readAllLines(path);
            ContactParser contactParser = new ContactParser();
            ContactsList contactsList = new ContactsList();
            for (String line : lines) {
                contactsList.add(contactParser.parse(line));
            }
            return contactsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int index) {
        try {
            int i = 1;
            StringBuilder stringBuilder = new StringBuilder();
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (i != index) {
                    stringBuilder.append(line).append("\n");

                }
                i++;
            }
            Files.write(path, stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void add(Contact contact) {
        String type;
        if (contact.getType().equals(Contact.Type.EMAIL)) {
            type = "Email";
        } else {
            type = "Phone";
        }
        String contactString = (contact.getName() +
                "[" + type + ": " + contact.getInfo() + "]\n");
        try {
            Files.write(path, contactString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchName(String string) {
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                Pattern pattern = Pattern.compile(string);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {

                    System.out.println(line);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchNumber(String string) {
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                Pattern pattern = Pattern.compile(string);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {

                    System.out.println(line);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printToFile() {
        try {
            Files.copy(path, new File("Contacts.txt").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
