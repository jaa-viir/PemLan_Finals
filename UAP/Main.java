package UAP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\u001B[34m+=----------------=+\u001B[0m");
            System.out.println("Silakan login >_<");
            System.out.print("Username: ");
            String username = in.nextLine();
            System.out.print("Password: ");
            String password = in.nextLine();

            User user = authenticate(username, password);
            if (user != null) {
                System.out.println("\u001B[34m+=----------------=+\u001B[0m");
                System.out.println("Selamat datang " + username);

                Akun.login(user);

                if (user.isAdmin()) {
                    handleAksiAdmin(user);
                } else {
                    handleAksiUser(user);
                }
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        }
    }

    public static User authenticate(String username, String password) {
        User user = User.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public static void handleAksiAdmin(User user) {
        AksiAdmin aksiAdmin = new AksiAdmin(user);
        aksiAdmin.welcome();
        aksiAdmin.tampilanAksi();
    }

    public static void handleAksiUser(User user) {
        AksiUser aksiUser = new AksiUser(user);
        aksiUser.welcome();
        aksiUser.tampilanAksi();
    }
}
