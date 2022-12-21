package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        boolean male = true;

        char namePrefix = 'K';
        byte age = 33;
        short height = 180;
        int accountNumber = 3443213;
        long inn = 7700123456L;
        float salary = 44678.50f;
        double balance = 1235647788.98d;

        LOG.debug("User info male: {}, namePrefix: {}, age : {}, height : {}, inn : {}, salary : {}, accountNumber : {}, balance : {}",
                male, namePrefix, age, height, inn, salary, accountNumber, balance);
    }
}