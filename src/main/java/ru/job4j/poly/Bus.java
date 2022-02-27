package ru.job4j.poly;

import java.sql.SQLOutput;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int number) {
    number += number;
        System.out.println("Количество пассажиров " + number);
    }

    @Override
    public double refuel(double numberOfLiters) {
        double price = 30;
        return price * numberOfLiters;
    }
}
