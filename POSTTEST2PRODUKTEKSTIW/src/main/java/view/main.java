/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package view;

import java.util.Scanner;
import service.produkservice;
import service.userservice;

/**
 *
 * @author ASUS
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        userservice userService = new userservice();
        produkservice produkService = new produkservice();
    
        // login / registrasi
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.println("=== SISTEM LOGIN ===");
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.print("Pilih: ");
            String pilihan = sc.nextLine();

            switch (pilihan) {
                case "1" -> {
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    if (userService.login(username, password)) {
                        System.out.println("Login berhasil! Selamat datang, " + username);
                        loginBerhasil = true;
                    } else {
                        System.out.println("Username atau password salah!");
                    }
                }
                case "2" -> {
                    System.out.print("Buat username baru: ");
                    String userBaru = sc.nextLine();
                    System.out.print("Buat password baru: ");
                    String passBaru = sc.nextLine();
                    userService.registrasi(userBaru, passBaru);
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        // menu CRUD Produk
        int menu;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN PRODUK TEKSTIL ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Produk");
            System.out.println("3. Update Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            while (!sc.hasNextInt()) {
                System.out.println("Input harus angka!");
                sc.nextLine();
                System.out.print("Pilih menu: ");
            }
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> {
                    System.out.print("Nama produk: ");
                    String nama = sc.nextLine();
                    System.out.print("Kategori: ");
                    String kategori = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc.nextDouble();
                    sc.nextLine();
                    produkService.tambahProduk(nama, kategori, harga);
                }
                case 2 -> produkService.lihatProduk();
                case 3 -> {
                    System.out.print("Masukkan ID produk yang ingin diupdate: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nama baru: ");
                    String nama = sc.nextLine();
                    System.out.print("Kategori baru: ");
                    String kategori = sc.nextLine();
                    System.out.print("Harga baru: ");
                    double harga = sc.nextDouble();
                    sc.nextLine();
                    produkService.updateProduk(id, nama, kategori, harga);
                }
                case 4 -> {
                    System.out.print("Masukkan ID produk yang ingin dihapus: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    produkService.hapusProduk(id);
                }
                case 5 -> {
                    System.out.print("Masukkan keyword pencarian: ");
                    String keyword = sc.nextLine();
                    produkService.cariProduk(keyword);
                }
                case 6 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 6);

        sc.close();
    }
}