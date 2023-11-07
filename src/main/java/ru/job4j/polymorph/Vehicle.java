package ru.job4j.polymorph;

/**
 * 1.2.5. Полиморфизм
 * 4.0. Что такое Interface.
 */
public interface Vehicle extends Fuel {

    int WHEELS = 4;

    void accelerate();

    void brake();

    void steer();

    void changeGear();

    static void getDragCoefficient() {
        System.out.println("Формула расчета коэффициента аэродинамического сопротивления автомобиля");
    }

    default void chargeBattery() {
        System.out.println("Аккумулятор под капотом. Зарядить.");
    }
}
