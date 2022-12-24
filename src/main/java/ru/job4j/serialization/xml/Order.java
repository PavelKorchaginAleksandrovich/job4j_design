package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlAttribute
    private String number;
    @XmlAttribute
    private double sum;
    @XmlAttribute
    private boolean active;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] goods;
    private Customer customer;

    public Order(String number, double sum, boolean active, String[] goods, Customer customer) {
        this.number = number;
        this.sum = sum;
        this.active = active;
        this.goods = goods;
        this.customer = customer;
    }
    public Order() { };

    @Override
    public String toString() {
        return "Order{"
                + "number='" + number + '\''
                + ", sum=" + sum
                + ", active=" + active
                + ", goods=" + Arrays.toString(goods)
                + '}';
    }
}
