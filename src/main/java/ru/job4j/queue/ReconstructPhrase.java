package ru.job4j.queue;

import java.util.Deque;

/**
 * 1.3. Collections. Lite.
 * 1.3.3. Queue, Deque
 * 2. Интерфейс Deque
 */
public class ReconstructPhrase {

    /**
     * Очередь, из которой составляем строку в обратном порядке
     */
    private final Deque<Character> descendingElements;

    /**
     * Очередь, из которой берем четные символы
     */
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    /**
     * Метод должен взять из очереди evenElements только четные символы и
     * все их соберет в результирующую строку.
     * Для реализации вам понадобится цикл fori, строку формируйте с помощью StringBuilder.
     * Эта очередь всегда имеет четное число элементов
     * @return возвращает строку состоящую и четных символов очереди
     */
    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int startSize = evenElements.size();
        for (int i = 0; i < startSize; i++) {
            if (i % 2 == 0) {
                rsl.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return rsl.toString();
    }

    /**
     * Метод должен брать символы начиная с последнего символа и
     * так пока не заберет их все.
     * Каждый символ мы добавляем в результирующую строку, формируем с помощью StringBuilder.
     * @return возвращает строку состоящую из символов очереди в обратном порядке
     */
    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        int startSize = descendingElements.size();
        for (int i = 0; i < startSize; i++) {
            rsl.append(descendingElements.pollLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
