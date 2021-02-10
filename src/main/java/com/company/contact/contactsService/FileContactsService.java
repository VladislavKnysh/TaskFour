package com.company.contact.contactsService;

import com.company.contact.Contact;
import com.company.contact.ContactsList;
import com.company.contact.contactsService.contactParser.ContactParser;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor

public class FileContactsService implements ContactsService {
    private final String fileName;

    public FileContactsService() {
        this.fileName = "Contacts.txt";
    }

    @Override
    public ContactsList getAll() {
        String line;
        ContactsList contactsList = new ContactsList();
        try (BufferedReader br = new BufferedReader
                (new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
                ContactParser contactParser = new ContactParser();
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
        String lineOfFile;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader
                (new FileReader(fileName))) {
            while ((lineOfFile = br.readLine()) != null) {
                lines.add(lineOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            if (i != index) {
                stringBuilder.append(line).append("\n");

            }
            i++;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
                writer.write(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append(contactString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchName(String string) {

        String lineOfFile;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader
                (new FileReader(fileName))) {
            while ((lineOfFile = br.readLine()) != null) {
                lines.add(lineOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String line : lines) {
            Pattern pattern = Pattern.compile(string);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(line);
            }
        }

    }

    @Override
    public void searchNumber(String string) {

        String lineOfFile;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader
                (new FileReader(fileName))) {
            while ((lineOfFile = br.readLine()) != null) {
                lines.add(lineOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String line : lines) {
            Pattern pattern = Pattern.compile(string);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(line);
            }
        }

    }


    @Override
    public void printToFile() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Contacts.txt"))) {
            while ((line = reader.readLine()) != null) {
                {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
