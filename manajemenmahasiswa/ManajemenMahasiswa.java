package com.mycompany.manajemenmahasiswa;

import java.util.Scanner;

class Node {
    String nim;
    String nama;
    int nilai;
    Node next;

    public Node(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addMahasiswa(String nim, String nama, int nilai) {
        Node newNode = new Node(nim, nama, nilai);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public void deleteMahasiswa(String nim) {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang bisa dihapus.");
            return;
        }

        if (head.nim.equals(nim)) {
            head = head.next;
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.nim.equals(nim)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        } else {
            previous.next = current.next;
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
        }
    }

    public void updateNilaiMahasiswa(String nim, int nilaiBaru) {
        Node current = head;
        while (current != null) {
            if (current.nim.equals(nim)) {
                current.nilai = nilaiBaru;
                System.out.println("Nilai mahasiswa dengan NIM " + nim + " berhasil diupdate.");
                return;
            }
            current = current.next;
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    public void tampilkanMahasiswa() {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        Node current = head;
        int no = 1;
        System.out.println("\nDaftar Mahasiswa:");
        while (current != null) {
            System.out.println(no + ". NIM: " + current.nim + ", Nama: " + current.nama + ", Nilai: " + current.nilai);
            current = current.next;
            no++;
        }
    }
}

public class ManajemenMahasiswa {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;
            
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Hapus Mahasiswa");
                System.out.println("3. Update Nilai Mahasiswa");
                System.out.println("4. Tampilkan Daftar Mahasiswa");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                
                while (!scanner.hasNextInt()) {
                    System.out.println("Input harus berupa angka. Coba lagi.");
                    System.out.print("Pilih menu: ");
                    scanner.next();
                }
                pilihan = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan NIM: ");
                        String nim = scanner.nextLine();
                        System.out.print("Masukkan Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Nilai: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Nilai harus berupa angka. Coba lagi.");
                            System.out.print("Masukkan Nilai: ");
                            scanner.next();
                        }
                        int nilai = scanner.nextInt();
                        scanner.nextLine();
                        list.addMahasiswa(nim, nama, nilai);
                    }
                    case 2 -> {
                        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                        String nimHapus = scanner.nextLine();
                        list.deleteMahasiswa(nimHapus);
                    }
                    case 3 -> {
                        System.out.print("Masukkan NIM mahasiswa yang akan diupdate nilainya: ");
                        String nimUpdate = scanner.nextLine();
                        System.out.print("Masukkan nilai baru: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Nilai harus berupa angka. Coba lagi.");
                            System.out.print("Masukkan nilai baru: ");
                            scanner.next();
                        }
                        int nilaiBaru = scanner.nextInt();
                        scanner.nextLine();
                        list.updateNilaiMahasiswa(nimUpdate, nilaiBaru);
                    }
                    case 4 -> list.tampilkanMahasiswa();
                    case 5 -> System.out.println("Keluar dari program...");
                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } while (pilihan != 5);
        }
    }
}