package ru.job4j.queue;

/**
 * 1.3. Collections. Lite.
 * 1.3.3. Queue, Deque
 * 1. Интерфейс Queue
 * Модель данных, которая описывает клиента магазина
 * @param name имя клиента магазина
 * @param amount деньги клиента магазина
 */
public record Customer(String name, int amount) {
}
