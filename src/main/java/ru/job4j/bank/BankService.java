package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Класс описывает модель банковского сервиса
 * @author EVGENY MASLAKOV
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение всех пользователей банка со всеми их счетами осуществляется в коллекции типа Map.
     * Хранение счетов пользователей осуществляется в коллекции типа List.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в банковский сервис с пустым списком счетов.
     * При этом проверяется, что данного пользователя нет в банковском сервисе.
     * Если он есть, то нового добавлять не надо.
     * @param user пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет банковский счет пользователю.
     * Вначале в банковском сервисе ищем пользователя по номеру паспорта.
     * Для этого нужно использовать метод {@findByPassport}.
     * Выполняется проверка, что пользователь не null
     * и что такого счета у пользователя еще нет.
     * Если такой счет есть, то добавлять не нужно.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * @param passport номер паспорта пользователя
     * @param account номер аккаунта, который мы хотим добавить пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * Получаем список всех номеров паспортов всех пользователей.
     * Поочередно сравниваем номер паспорта со всеми номерами паспортов в списке.
     * Если мы нашли нужный номер паспорта, прерываем цикл.
     * Возвращаем пользователя найденного по номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return пользователя, если такой пользователь существует
     * и null, если такого пользователя нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Вначале в банковском сервисе ищем пользователя по номеру паспорта.
     * Для этого нужно использовать метод {@findByPassport}.
     * Выполняется проверка, что пользователь не null.
     * После этого получаем список счетов пользователя.
     * Поочередно сравниваем номер счета со всеми номерами счетов в списке.
     * Если мы нашли нужный номер счета, прерываем цикл.
     * Возвращаем банковский счет найденный по номеру счета.
     * @param passport номер паспорта пользователя
     * @param requisite номер счета пользователя
     * @return возвращает банковский счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Ищем счет пользователя, с которого будем переводить деньги
     * по номеру паспорта и номеру счета.
     * Ищем счет пользователя, кому будем переводить деньги
     * по номеру паспорта и номеру счета.
     * Проверяем что такие счета существуют и баланс счета, с которого планируется
     * переводить деньги больше суммы, которую планируется переводить.
     * Если счёт не найден или не хватает денег на счёте с которого планируется
     * переводить деньги, то метод возвращает false.
     * Если счёта найдены и на счете с которого планируется переводить деньги
     * достаточно денег, то из баланса счета, с которого переводят деньги,
     * вычитается текущая сумма, и прибавляется к балансу счета на который переводят деньги.
     * @param srcPassport паспорт пользователя, который переводит деньги
     * @param srcRequisite номер счета пользователя, с которого переводят деньги
     * @param destPassport паспорт пользователя, кому переводит деньги
     * @param destRequisite номер счета пользователя, с кому переводят деньги
     * @param amount сумма денег, которую планируется перевести
     * @return возвращает false или true в зависимости от того, удалось ли перевести деньги
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAaccount = findByRequisite(srcPassport, srcRequisite);
        Account destAaccount = findByRequisite(destPassport, destRequisite);
        if (srcAaccount != null && destAaccount != null && srcAaccount.getBalance() >= amount) {
            rsl = true;
            srcAaccount.setBalance(srcAaccount.getBalance() - amount);
            destAaccount.setBalance(destAaccount.getBalance() + amount);
        }
        return rsl;
    }
}