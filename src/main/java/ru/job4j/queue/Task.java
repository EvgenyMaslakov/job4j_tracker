package ru.job4j.queue;

/**
 * модель данных
 * @param position позиция
 * @param description описание
 * @param urgency срочность
 */
public record Task(Position position,
                   String description,
                   int urgency) {
}