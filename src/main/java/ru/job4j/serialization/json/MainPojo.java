package ru.job4j.serialization.json;

import org.json.JSONObject;

public class MainPojo {
    public static void main(String[] args) {
        Document doc = new Document("passport", "1312", "456789");
        Patient patient = new Patient("Andy", true, "andy@mail.ru andy@gmail.com".split(" "), 21 ,doc);
        System.out.println(new JSONObject(patient));
    }
}
