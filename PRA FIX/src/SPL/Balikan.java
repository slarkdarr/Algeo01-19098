package SPL;

import Input.readSPL;
import Output.writeSPLCRAINV;

import java.io.IOException;
import java.util.Scanner;

public class Balikan {
    public void invers(double M[][], double I[][]){
        //KAMUS
        int i,j,k,l;
        final int N = M.length;
        boolean nol;
        double temp[] = new double[N];
        Balikan balikan = new Balikan();
        //ALGORITMA
        //Pembuatan matriks eselon
        k =0;
        for (j=0;j<N;j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            balikan.pembulatan(M);
            balikan.pembulatan(I);

            //Menukar baris apabila elemen yang diisnpeksi 0
            if (M[k][j] == 0){
                nol = true;
                i = k+1;
                while ((nol==true) && (i<N)){
                    if (M[i][j] != 0){
                        //Menukar di matriks biasa
                        temp = M[k];
                        M[k] = M[i];
                        M[i] = temp;
                        //Menukar di matriks identitas
                        temp = I[k];
                        I[k] = I[i];
                        I[i] = temp;
                        nol = false;
                    } 
                    else i+=1;
                }
            }

            if (M[k][j] != 0){
                //Membuat elemen menjadi 1
                final double pembagi = M[k][j];
                for (l=0;l<N;l++){
                    M[k][l] /= pembagi; 
                    I[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i=k+1; i<N; i++){
                    final double faktor = M[i][j];
                    for (l=0; l<N; l++){
                        M[i][l] -= faktor*M[k][l];
                        I[i][l] -= faktor*I[k][l];
                    }
                }
                k += 1;
            }
        }
        //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
        balikan.pembulatan(M);
        balikan.pembulatan(I);

        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<N; j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            balikan.pembulatan(M);
            balikan.pembulatan(I);
            //Membuat 0 elemen di atas elemen 1
            if (M[k][j] == 1){
                for (i=0; i<k; i++){
                    double faktor = M[i][j];
                    for (l=0; l<N; l++){
                        I[i][l] -= faktor * I[k][l];
                        M[i][l] -= faktor * M[k][l];
                    }
                }
                k += 1;
            }
        }
        //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
        balikan.pembulatan(M);
        balikan.pembulatan(I);
    }

    public void pembulatan(double A[][]){
        //KAMUS
        int i,j;
        int N = A.length;
        int M = A.length;
        //ALGORITMA
        for (i=0; i<N; i++){
            for(j=0; j<M; j++){
                if ((Math.abs(A[i][j])%1>0.99999) || (Math.abs(A[i][j])%1<0.00001)){
                    A[i][j] = Math.round(A[i][j]);
                }
            }
        }
    }

    public double[] kali(double M[][], double B[]){
        //KAMUS
        int i,j;
        int N = M.length;
        double hasil[] = new double[N];

        //ALGORITMA
        for (i=0; i<N; i++){
            hasil[i] = 0;
            for (j=0; j<N; j++){
                hasil[i] += M[i][j] * B[j];
            }
        }
        return hasil;
    }

    public static void main() throws IOException {
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        Balikan balikan = new Balikan();

        //PROGRAM UTAMA
        System.out.println("SPL Metode Matriks Balikan");
        readSPL read = new readSPL();
        double[][] matriks =  read.main();
        int N = matriks.length;
        int Nkol = matriks[0].length;
        if (N!=Nkol-1) {
            System.out.println("Tidak bisa menggunakan Metode balikan karena matriks variabel tidak persegi");
        }

        else {
            //Pembuatan matriks identitas
            double I[][] = new double[N][N];
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (i == j)
                        I[i][j] = 1;
                    else
                        I[i][j] = 0;
                }
            }

            double A[][] = new double[N][N];
            for (i = 0; i < N; i++)
                for (j = 0; j < N; j++)
                    A[i][j] = matriks[i][j];

            double B[] = new double[N];
            for (i = 0; i < N; i++)
                B[i] = matriks[i][N];


            //Menginverskan matriks
            balikan.invers(A, I);

            //Mengecek apakah matriks ada balikan atau tidak
            boolean identitas = true;
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if ((i == j) && (A[i][j] != 1)) {
                        identitas = false;
                    }
                }
            }

            int abc = 0;
            double hasil[] = new double[N];
            hasil = balikan.kali(I, B);
            writeSPLCRAINV SPLINVW = new writeSPLCRAINV();
            //Menuliskan output
            if (identitas == true) {
                abc = 1;
                SPLINVW.write(hasil, "Hasil SPL dengan Invers.txt", abc);
            } else {
                System.out.println("Tidak dapat menyelesaikan SPL karena matriks tidak memiliki balikan");
                SPLINVW.write(hasil, "Hasil SPL dengan Invers.txt", abc);
            }
        }
    }
}