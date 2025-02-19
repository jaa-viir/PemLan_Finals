package UAP;

import java.util.HashMap;
import java.util.Map;

public class User {
    private boolean isAdmin;
    private String password;
    private Map<String, Pesanan> pesanan;
    private double saldo;
    private String username;
    private static Map<String, User> users = new HashMap<>();

    public User(String username, String password, boolean isAdmin, double saldo) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.saldo = saldo;
        this.pesanan = new HashMap<>();
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Pesanan> getPesanan() {
        return pesanan;
    }

    public void addPesanan(Film film, int kuantitas) {
        Pesanan pesananBaru = new Pesanan(film, kuantitas);
        this.pesanan.put(film.getName(), pesananBaru);
    }

    public static User getUser(String username) {
        return users.get(username);
    }

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    static {
        addUser(new User("user", "123", false, 100000));
        addUser(new User("admin", "admin", true, 0));
    }
}
