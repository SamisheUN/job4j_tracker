package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
            int rsl = -1;
            for (int index = 0; index < users.length; index++) {
                if (users[index].getUsername().equals(login)) {
                    rsl = index;
                    break;
                }
            }
            if (rsl < 0) {
                throw new UserNotFoundException("В массиве нет искомого элемента.");
            }
            return users[rsl];
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = false;
        if (user.isValid() | user.getUsername().length() > 3) {
            rsl = true;
        } else {
            throw new UserInvalidException("Невалидный пользователь");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден");
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный");
        }

    }
}