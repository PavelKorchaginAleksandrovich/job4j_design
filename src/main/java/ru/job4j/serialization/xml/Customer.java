package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean male;
    public Customer(String name, boolean male) {
        this.name = name;
        this.male = male;
    }
    public Customer() { };

    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + ", male=" + male
                + '}';
    }


}
