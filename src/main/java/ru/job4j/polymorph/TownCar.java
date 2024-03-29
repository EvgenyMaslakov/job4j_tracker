package ru.job4j.polymorph;

/**
 * 1.2.5. Полиморфизм
 * 4.0. Что такое Interface.
 */
public class TownCar implements Vehicle {

    @Override
    public void changeGear() {
        System.out.println("Коробка передач автомат. Поставить селектор в режим D.");
    }

    @Override
    public void accelerate() {
        System.out.println("Нажатие на педаль газа механически открывает дроссельную заслонку");
    }

    @Override
    public void steer() {
        System.out.println("Стандартное рулевое управление");
    }

    @Override
    public void brake() {
        System.out.println("Стандартная тормозная система");
    }

    @Override
    public void refill() {
        System.out.println("Заправить 60л бензина");
    }

    @Override
    public void chargeBattery() {
        Vehicle.super.chargeBattery();
    }

}
