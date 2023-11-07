package ru.job4j.polymorph;

/**
 * 1.2.5. Полиморфизм
 * 4.0. Что такое Interface.
 */
public interface Vehicle extends Fuel {

    void accelerate();

    void brake();

    void steer();

    void changeGear();
}
