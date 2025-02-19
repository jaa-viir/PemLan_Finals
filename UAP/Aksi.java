package UAP;

public abstract class Aksi implements TampilanInterface {
    protected User currentUser;

    public Aksi(User currentUser) {
        this.currentUser = currentUser;
    }

    public void keluar() {
        System.out.println("Keluar dari aplikasi.");
    }

    public void lihatListFilm() {
        for (Film film : Film.getFilms().values()) {
            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + film.getPrice()
                    + " - Stok: " + film.getStock());
        }
    }

    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    public void welcome() {
        System.out.print("Selamat datang di Aplikasi Pemesanan Tiket Film!");
    }
}
