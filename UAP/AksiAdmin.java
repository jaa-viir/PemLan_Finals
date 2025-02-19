package UAP;

import java.util.Scanner;

public class AksiAdmin extends Aksi {
    public AksiAdmin(User user) {
        super(user);
    }

    @Override
    public void tampilanAksi() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.println("\u001B[34m+=--------------[Menu Admin]-------------=+\u001B[0m");
            System.out.println("1. Lihat Daftar Film");
            System.out.println("2. Tambah Film");
            System.out.println("3. Logout");
            System.out.println("4. Tutup Aplikasi");
            System.out.print("Pilih aksi: ");
            int pilihan = in.nextInt();
            in.nextLine();
            System.out.println("\u001B[34m+=----------------------------------=+\u001B[0m");

            switch (pilihan) {
                case 1:
                    lihatListFilm();
                    break;
                case 2:
                    tambahFilm(in);
                    break;
                case 3:
                    logout();
                    return;
                case 4:
                    tutupAplikasi();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void lihatListFilm() {
        super.lihatListFilm();
    }

    public void tambahFilm(Scanner in) {
        System.out.print("Nama Film: ");
        String name = in.nextLine();
        System.out.print("Deskripsi Film: ");
        String description = in.nextLine();
        System.out.print("Harga Tiket: ");
        double price = in.nextDouble();
        System.out.print("Stok Tiket: ");
        int stock = in.nextInt();
        in.nextLine();

        Film.addFilm(name, description, price, stock);
    }

    public void logout() {
        System.out.println("Anda telah logout.");
        Akun.logout();
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
