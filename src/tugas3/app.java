package tugas3;

import java.util.InputMismatchException;
import java.util.Scanner;

class Kendaraan {
    double pajak;
    int harga;

    public Kendaraan(int harga){
        this.harga = harga;
    }

    public double cekPajak() {
        return pajak;
    }
}

class Mobil extends Kendaraan {
    public Mobil(int harga) {
        super(harga);
    }

    public double cekPajak() {
        this.pajak = 0.05 * this.harga;
        return super.cekPajak();
    }
}

class Motor extends Kendaraan {
    public Motor(int harga) {
        super(harga);
    }

    public double cekPajak() {
        this.pajak = 0.025 * harga;
        return super.cekPajak();
    }
}

class Bis extends Kendaraan {
    public Bis(int harga) {
        super(harga);
    }

    public double cekPajak() {
        this.pajak = 0.075 * harga;
        return super.cekPajak();
    }
}

public class app {
    public static void main(String[] args) {
        System.out.println("Selamat datang di Mesin Penghitung Pajak!\n" +
                "Berikut adalah daftar kendaraan yang dapat dicek,\n" +
                "- Mobil\n" +
                "- Motor\n" +
                "- Bis\n" +
                "Masukkan jumlah kendaraan yang dimiliki : ");

        Scanner scanner_jumlah = new Scanner(System.in);

        try {
            String[] listKendaraan = new String[scanner_jumlah.nextInt()];

            System.out.printf("Masukkan jenis kendaraan dan harga dalam format kendaraan, harga. Setiap kendaraan dipisah dengan enter:\n");
            Scanner scanner_kendaraan = new Scanner(System.in);

            for (int i=0; i < listKendaraan.length; i++) {
                listKendaraan[i] = scanner_kendaraan.nextLine();
            }

            double total = 0;
            for (String input : listKendaraan) {
                String[] kendaraan = input.split(", ");
                int harga = 0;

                if(kendaraan[0].toLowerCase().equals("mobil")){
                    harga = Integer.parseInt(kendaraan[1]);
                    Mobil mobil = new Mobil(harga);
                    total += mobil.cekPajak();
                }
                else if(kendaraan[0].toLowerCase().equals("motor")){
                    harga = Integer.parseInt(kendaraan[1]);
                    Motor motor = new Motor(harga);
                    total += motor.cekPajak();
                }
                else if(kendaraan[0].toLowerCase().equals("bis")){
                    harga = Integer.parseInt(kendaraan[1]);
                    Bis bis = new Bis(harga);
                    total += bis.cekPajak();
                }
                else {
                    System.out.println("Maaf, jenis kendaraan belum terdaftar atau input yang dimasukkan tidak sesuai format.\n" +
                            "Berikut contoh input yang sesuai:\n" +
                            "Mobil, 80000000\n" +
                            "Motor, 10000000");
                }
            }
            System.out.println("Berikut adalah total pajak kamu : Rp" + total);
        }
        catch (InputMismatchException e){
            System.out.println("Maaf, pengecekan gagal. Masukkan jumlah kendaraan dalam angka (cth: 5)");
        }
        catch (NumberFormatException ex){
            System.out.println("Maaf, pengecekan gagal. Masukkan harga mobil dalam angka (cth: 100000000)");
        }
        catch (ArrayIndexOutOfBoundsException exe){
            System.out.println("Maaf, pengecekan gagal. Masukkan jenis dan harga kendaraan sesuai jumlah kendaraan yang dimiliki");
        }

    }
}
