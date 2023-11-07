package ru.job4j.polymorph;

/**
 * 1.2.5. Полиморфизм
 * 4.0. Что такое Interface.
 */
public class Main {
    public static void main(String[] args) {
        Vehicle sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();
        sportCar.refill();
        Vehicle.getDragCoefficient();
    }

}