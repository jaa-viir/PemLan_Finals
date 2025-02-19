package UAP;

import java.util.HashMap;
import java.util.Map;

public class Film {
    private String description;
    private static Map<String, Film> films = new HashMap<>();
    private String name;
    private double price;
    private int stock;

    public Film(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public static void addFilm(String name, String description, double price, int stock) {
        if (films.containsKey(name)) {
            System.out.println("Film " + name + " sudah ada.");
            return;
        }
        films.put(name, new Film(name, description, price, stock));
        System.out.println("Film " + name + " berhasil ditambahkan.");
    }

    public static Map<String, Film> getFilms() {
        return films;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    static {
        addFilm("Film A", "Deskripsi A", 50000, 10);
        addFilm("Film B", "Deskripsi B", 60000, 5);
    }
}
