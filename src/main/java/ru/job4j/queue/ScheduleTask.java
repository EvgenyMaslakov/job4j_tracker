package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleTask {
    private PriorityQueue<Task> queue;

    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    /**
     * addTask() просто добавляет переданную задачу в очередь
     * @param task задача
     */
    public void addTask(Task task) {
        queue.offer(task);
    }

    /**
     * readTask() просто читает элемент из головы очереди без удаления
     * @return возвращает элемент из головы очереди
     */
    public Task readTask() {
        return queue.peek();
    }

    /**
     * getTask() просто возвращает задачу из головы очереди с удалением
     * @return возвращает задачу из головы очереди
     */
    public Task getTask() {
        return queue.poll();
    }
}