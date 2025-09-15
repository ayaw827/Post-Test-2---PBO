/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.user;

/**
 *
 * @author ASUS
 */
public class userservice {
    private final ArrayList<user> daftarUser = new ArrayList<>();

    // const akun default
    public userservice() {
        daftarUser.add(new user("ayawWw", "088022"));
    }

    // cons registrasi
    public void registrasi(String username, String password) {
        for (user u : daftarUser) {
            if (u.getUsername().equals(username)) {
                System.out.println("username sudah dipakai!");
                return;
            }
        }
        daftarUser.add(new user(username, password));
        System.out.println("Registrasi berhasil! Silakan login.");
    }

    // cons login
    public boolean login(String username, String password) {
        for (user u : daftarUser) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}