package UAP;

import java.util.Scanner;

public class AksiUser extends Aksi {
    public AksiUser(User user) {
        super(user);
    }

    @Override
    public void tampilanAksi() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.println("\u001B[34m+=--------------[Menu User]--------------=+\u001B[0m");
            System.out.println("1. Lihat Saldo");
            System.out.println("2. Lihat Daftar Film");
            System.out.println("3. Pesan Film");
            System.out.println("4. Lihat Pesanan");
            System.out.println("5. Logout");
            System.out.println("6. Tutup Aplikasi");
            System.out.print("Pilih aksi: ");
            int pilihan = in.nextInt();
            in.nextLine();
            System.out.println("\u001B[34m+=---------------------------------------=+\u001B[0m");
            switch (pilihan) {
                case 1:
                    lihatSaldo();
                    break;
                case 2:
                    lihatListFilm();
                    break;
                case 3:
                    pesanFilm(in);
                    break;
                case 4:
                    lihatPesanan();
                    break;
                case 5:
                    logout();
                    return;
                case 6:
                    tutupAplikasi();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public void lihatSaldo() {
        System.out.println("Saldo Anda: " + currentUser.getSaldo());
    }

    public void lihatPesanan() {
        if (currentUser.getPesanan().isEmpty()) {
            System.out.println("Kamu belum pernah melakukan pemesanan.");
        } else {
            for (Pesanan pesanan : currentUser.getPesanan().values()) {
                System.out.println("Film: " + pesanan.getFilm().getName() + " - Jumlah: " + pesanan.getKuantitas()
                        + " - Total Harga: " + (pesanan.getFilm().getPrice() * pesanan.getKuantitas()));
            }
        }
    }

    public void pesanFilm(Scanner in) {
        System.out.print("Nama Film yang ingin dipesan: ");
        String namaFilm = in.nextLine();
        Film film = Film.getFilms().get(namaFilm);

        if (film == null) {
            System.out.println("Film yang dicari tidak ditemukan.");
            return;
        }

        System.out.print("Jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = in.nextInt();
        in.nextLine();

        if (jumlahTiket > film.getStock()) {
            System.out.println("Stok tiket tidak mencukupi.");
            return;
        }

        double totalHarga = film.getPrice() * jumlahTiket;
        System.out.println("Harga satuan tiket: " + film.getPrice());
        System.out.println("Total harga: " + totalHarga);

        if (currentUser.getSaldo() < totalHarga) {
            System.out.println("Saldo tidak mencukupi, saldo yang dimiliki: " + currentUser.getSaldo());
            return;
        }

        currentUser.addPesanan(film, jumlahTiket);
        film.setStock(film.getStock() - jumlahTiket);
        currentUser.setSaldo(currentUser.getSaldo() - totalHarga);

        System.out.println("Tiket berhasil dipesan.");
    }

    public void logout() {
        System.out.println("Anda telah logout.");
        Akun.logout();
    }

    @Override
    public void lihatListFilm() {
        super.lihatListFilm();
    }

    @Override
    public void keluar() {
        super.keluar();
    }

    @Override
    public void tutupAplikasi() {
        super.tutupAplikasi();
    }
}
