package ru.job4j.serialization.json;

import java.util.Arrays;

public class Patient  {
    private String name;
    private boolean male;
    private String[] emails;
    private int age;
    private Document document;

    public Patient(String name, boolean male, String[] emails, int age, Document document) {
        this.name = name;
        this.male = male;
        this.emails = emails;
        this.age = age;
        this.document = document;
    }


    @Override
    public String toString() {
        return "Patient{"
                + "name='" + name + '\''
                + ", male=" + male
                + ", age=" + age
                + ", emails=" + Arrays.toString(emails)
                + ", document=" + document
                + '}';
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }

    public String[] getEmails() {
        return emails;
    }

    public int getAge() {
        return age;
    }

    public Document getDocument() {
        return document;
    }
}
