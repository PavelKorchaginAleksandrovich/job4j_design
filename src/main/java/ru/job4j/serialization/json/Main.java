package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Document document = new Document("passport", "1212", "123456");
        String[] emails = new String[2];
        emails[0] = "first@mail.ru";
        emails[1] = "second@mail.ru";
        Patient patient = new Patient("Pavel", true, emails, 30, document);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(patient));
        StringBuilder patientJSon = new StringBuilder();
        patientJSon.append("{\"name\":\"Pavel\",")
                .append("\"male\":true,")
                .append("\"emails\":[\"first@mail.ru\",\"second@mail.ru\"],")
                .append("\"age\":30,")
                .append("\"document\":{\"type\":\"passport\",\"series\":\"1212\",\"number\":\"123456\"}}");
        final Patient patientMod = gson.fromJson(patientJSon.toString(), Patient.class);
        System.out.println(patientMod);
    }
}
