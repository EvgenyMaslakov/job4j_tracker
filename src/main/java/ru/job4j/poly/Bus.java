package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        boolean b = true;
    }

    @Override
    public void passengers(int number) {
    number += number;
    }

    @Override
    public double refuel(double numberOfLiters) {
        double price = 30;
        return price * numberOfLiters;
    }
}
