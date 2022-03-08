package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = users[i];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User not found in the list.");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("The user is not valid or the username is less than 3 characters.");
        }
        return user.isValid();
    }

    public static void main(String[] args) {
        try {
        User[] users = {
                new User("Evgeny Maslakov", true)
        };
        User user = findUser(users, "Evgeny Maslakov");
           if (validate(user)) {
               System.out.println("This user has an access");
           }
       } catch (UserInvalidException e) {
           e.printStackTrace();
       } catch (UserNotFoundException ex) {
           ex.printStackTrace();
       }

    }
}
