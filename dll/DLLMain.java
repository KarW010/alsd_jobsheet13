package dll;

import java.util.Scanner;

public class DLLMain {
    public static void main(String[] args) {
        DoubleLinkedList09 list = new DoubleLinkedList09();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do{
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus dari awal");
            System.out.println("4. Hapus dari akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah data setelah NIM tertentu");
            System.out.println("8. Tambah data pada indeks tertentu");
            System.out.println("9. Hapus data pada indeks tertentu");
            System.out.println("10. Hapus data setelah NIM tertentu");
            System.out.println("11. Tampilkan data pada index tertentu");
            System.out.println("12. Tampilkan data pertama (head)");
            System.out.println("13. Tampilkan data terakhir (tail)");
            System.out.println("14. Tampilkan jumlah data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();
            
            switch (pilihan) {
                case 1: {
                    Mahasiswa09 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                    break;
                }
                case 2: {
                    Mahasiswa09 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                    break;
                }
                case 3:
                    list.removeFirst();
                    break;
                case 4:
                    list.removeLast();
                    break;
                case 5:
                    list.print();
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    Node09 found = list.search(nim);
                    if (found != null) {
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 7: 
                    System.out.print("Masukkan NIM yang dicari: ");
                    String key = scan.nextLine();
                    Mahasiswa09 mhs = inputMahasiswa(scan);
                    list.insertAfter(key, mhs);
                    break;
                case 8: {
                    System.out.print("Masukkan index: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    Mahasiswa09 mhsBaru = inputMahasiswa(scan);
                    list.add(mhsBaru, index);
                    break;
                }
                case 9: {
                    System.out.print("Masukkan index yang akan dihapus: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.remove(index);
                    break;
                }
                case 10: {
                    System.out.print("Masukkan NIM: ");
                    String keyNim = scan.nextLine();
                    list.removeAfter(keyNim);
                    break;
                }
                case 11: {
                    System.out.print("Masukkan index: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(index);
                    break;
                }
                case 12:
                    list.getFirst();
                    break;
                case 13:
                    list.getLast();
                    break;
                case 14:
                    list.tampilkanUkuran();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        scan.close();
    }

    public static Mahasiswa09 inputMahasiswa(Scanner sc) {
        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("Masukkan IPK   : ");
        double ipk = sc.nextDouble();
        sc.nextLine();
        return new Mahasiswa09(nim, nama, kelas, ipk);
    }
}
