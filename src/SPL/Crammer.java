package SPL;

import Determinan.Detkof;
import Input.readSPL;
import Output.writeSPLCRAINV;

import java.io.IOException;
import java.util.Scanner;

public class Crammer {
    public double[] crammer(double A[][],double B[]){
        //KAMUS
        Detkof detkof = new Detkof();
        int i,j,k;
        int N = A.length;
        double hasil[] = new double[N];
        double temp[][] = new double[N][N];

        //ALGORITMA
        for (k=0;k<N;k++){
            //Menyalin isi matriks A ke dalam temp
            for (i=0;i<N;i++)
                for (j=0;j<N;j++)
                    temp[i][j] = A[i][j];
            
            //Mengganti kolom-k temp dengan hasil B
            for (i=0;i<N;i++){
                temp[i][k] = B[i];
            }

            //Menghitung variabel dengan determinan & menyetornya di matriks hasil
            hasil[k] = detkof.determinan(temp)/detkof.determinan(A);
        }
        return hasil;
    }

    public static void main() throws IOException {
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        SPL.Crammer cram = new SPL.Crammer();
		writeSPLCRAINV SPLINVW = new writeSPLCRAINV();

        //PROGRAM UTAMA
        System.out.println("SPL Metode Crammer");
        readSPL read = new readSPL();
        double[][] matriks =  read.main();
        int N = matriks.length;
        int Nkol = matriks[0].length;
        if (N!=Nkol-1) {
			double hasil[] = new double[N];
			SPLINVW.write(hasil, "../Hasil SPL dengan Crammer.txt",0);
            System.out.println("Tidak bisa menggunakan Metode balikan karena matriks variabel tidak persegi");
        }
        else {

            double A[][] = new double[N][N];
            for (i = 0; i < N; i++)
                for (j = 0; j < N; j++)
                    A[i][j] = matriks[i][j];

            double B[] = new double[N];
            for (i = 0; i < N; i++)
                B[i] = matriks[i][N];

            double hasil[] = new double[N];
            hasil = cram.crammer(A, B);
            SPLINVW.write(hasil, "../Hasil SPL dengan Crammer.txt",1);
        }
    }
}