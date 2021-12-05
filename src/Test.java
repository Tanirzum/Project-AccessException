import java.util.*;

public class Test {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.next();
        System.out.println("Введите пароль");
        String password = scanner.next();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);
        System.out.println("Доступ предстволен");

    }


    public static User[] getUser() {
        User firstUser = new User("Tanirbergen", "tanir@mail.ru", "pass", 8);
        User SecondUser = new User("Almas", "almas@mail.ru", "pass1", 24);
        User thridUser = new User("Aman", "aman@mail.ru", "pass2", 19);
        return new User[]{firstUser, SecondUser};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User users[] = getUser();
        for (User user : users) {
            if (user.getEmail().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Такого аккаунта нету");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("у вас нет 18");
        }
    }
}
