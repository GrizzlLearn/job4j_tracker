package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var intIndex = 0;
        for (var taskValue : tasks) {
            if (taskValue.getPriority() > task.getPriority()) {
                break;
            }
            intIndex++;
        }
        this.tasks.add(intIndex, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
