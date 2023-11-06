package ru.job4j.tracker;

/**
 *
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
