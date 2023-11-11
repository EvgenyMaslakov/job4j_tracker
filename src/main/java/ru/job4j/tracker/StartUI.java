package ru.job4j.tracker;

import java.util.List;

/**
 * Объект класса управляет меню.
 * В нем используется цикл, который опрашивает пользователя о выбранном
 * пункте меню.
 * Если пользователь выбрал пункт "Выйти", то цикл завершается и программа
 * закрывается.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Метод инициализирует приложение и запускает выполнение различных
     * пользовательских действий.
     * @param input
     * @param tracker хранилище заявок
     * @param actions список возможных действий в меню
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Метод выводит на экран меню доступных пользовательских действий.
     * @param actions
     */
    private void showMenu(List<UserAction> actions) {
        out.println("Меню:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    /**
     * Метод запускает приложение.
     * @param args
     */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(output),
                new FindAllAction(output), new ReplaceAction(output),
                new DeleteAction(output), new FindActionById(output),
                new FindActionByName(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}
