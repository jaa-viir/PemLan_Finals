package UAP;

public class Akun {
    private static ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static void login(User user) {
        currentUser.set(user);
    }

    public static void logout() {
        currentUser.remove();
    }

    public static User getCurrentUser() {
        return currentUser.get();
    }
}
