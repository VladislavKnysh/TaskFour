package com.company.contact;

import java.util.Arrays;

public class ContactsList {
    private Contact[] contacts;
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private int newCapacity = DEFAULT_CAPACITY;

    public ContactsList() {
        contacts = new Contact[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    public void add(Contact contact) {
        if (contact != null) {
            if (size < newCapacity) {
                contacts[size] = contact;
                size++;
            } else {
                newCapacity = (int) (newCapacity * 1.5);
                Contact[] tempData = new Contact[newCapacity];
                System.arraycopy(contacts, 0, tempData, 0, contacts.length);
                tempData[size] = contact;
                contacts = Arrays.copyOf(tempData, newCapacity);
                size++;
            }
        }
    }

    public Contact get(int index) {
        checkIndex(index);
        return contacts[index];
    }

    public void set(int index, Contact element) {
        checkIndex(index);
        Contact prev = contacts[index];
        contacts[index] = element;
    }

    public void remove(int index) {
        checkIndex(index);
        Contact e = contacts[index];
        System.arraycopy(contacts, (index + 1), contacts, index, (--size - index));
        contacts[size] = null;
    }



    public void clear() {
        int size = size();
        for (int i = 0; i <= size - 1; i++) {
            contacts[i] = null;
        }

        this.size = 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i <= size - 1; i++) {
            if (contacts[i].equals(o)) {
                return i;
            } else if (contacts[i] == o) {
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException("");
        }
    }
}


