/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import model.produk;

/**
 *
 * @author ASUS
 */
public final class produkservice {
    private final ArrayList<produk> daftarProduk = new ArrayList<>();
    private int idCounter = 1;

    public produkservice() {
        // --- produk yang ada sejak awal program ---
        daftarProduk.add(new produk(idCounter++, "Pakaian", "Fashion", 120000));
        daftarProduk.add(new produk(idCounter++, "Selimut", "Perlengkapan Rumah", 75000));
        daftarProduk.add(new produk(idCounter++, "Celana Jeans", "Fashion", 200000));
        daftarProduk.add(new produk(idCounter++, "Batik", "Fashion", 150000));
}

    // method tambah
    public void tambahProduk(String nama, String kategori, double harga) {
        produk p = new produk(idCounter++, nama, kategori, harga);
        daftarProduk.add(p);
        System.out.println("Produk berhasil ditambahkan!");
    }
    
    // method lihat
    public void lihatProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk.");
        } else {
            System.out.println("\n=== DAFTAR PRODUK ===");
            System.out.printf("%-5s %-20s %-20s %-20s\n", "ID", "Nama Produk", "Kategori", "Harga");
            System.out.println("---------------------------------------------------------------");

            NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(new Locale ("id", "ID"));

            for (produk p : daftarProduk) {
                System.out.printf("%-5d %-20s %-20s %-20s\n",
                        p.getId(), p.getNama(), p.getKategori(), rupiahFormat.format(p.getHarga()));
            }
        }
    }

    // method update
    public void updateProduk(int id, String nama, String kategori, double harga) {
        for (produk p : daftarProduk) {
            if (p.getId() == id) {
                p.setNama(nama);
                p.setKategori(kategori);
                p.setHarga(harga);
                System.out.println("Produk berhasil diupdate!");
                return;
            }
        }
        System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
    }

    // method hapus
    public void hapusProduk(int id) {
        for (produk p : daftarProduk) {
            if (p.getId() == id) {
                daftarProduk.remove(p);
                System.out.println("Produk berhasil dihapus!");
                return;
            }
        }
        System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
    }

    // method cari
    public void cariProduk(String keyword) {
        boolean ditemukan = false;
        System.out.println("\n=== HASIL PENCARIAN ===");
        for (produk p : daftarProduk) {
            if (p.getNama().toLowerCase().contains(keyword.toLowerCase()) ||
                p.getKategori().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.printf("%-5d %-20s %-25s Rp%-15.2f%n",
                        p.getId(), p.getNama(), p.getKategori(), p.getHarga());
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}