package Invers;

import Output.writeINV;

import java.io.IOException;
import java.util.Scanner;

public class Inobe {
    public void invers(double M[][], double I[][]){
        //KAMUS
        int i,j,k,l;
        final int N = M.length;
        boolean nol;
        double temp[] = new double[N];
        Inobe inobe = new Inobe();

        //ALGORITMA
        //Pembuatan matriks eselon
        k =0;
        for (j=0;j<N;j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            inobe.pembulatan(M);
            inobe.pembulatan(I);

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
                double pembagi = M[k][j];
                for (l=0;l<N;l++){
                    M[k][l] /= pembagi; 
                    I[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i=k+1; i<N; i++){
                    double faktor = M[i][j];
                    for (l=0; l<N; l++){
                        M[i][l] -= faktor*M[k][l];
                        I[i][l] -= faktor*I[k][l];
                    }
                }
                k += 1;
            }
        }
        //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
        inobe.pembulatan(M);
        inobe.pembulatan(I);

        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<N; j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            inobe.pembulatan(M);
            inobe.pembulatan(I);
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
        inobe.pembulatan(M);
        inobe.pembulatan(I);
    }

    public void pembulatan(double A[][]){
        //KAMUS
        int i,j;
        int N = A.length;
        int M = A[0].length;
        //ALGORITMA
        for (i=0; i<N; i++){
            for(j=0; j<M; j++){
                if ((Math.abs(A[i][j])%1>0.99999) || (Math.abs(A[i][j])%1<0.00001)){
                    A[i][j] = Math.round(A[i][j]);
                }
            }
        }
    }

    public static void main(double[][] M,int length) throws IOException {
        // KAMUS
        int i,j;
        final Scanner scan = new Scanner(System.in);
        final Inobe inobe = new Inobe();
        writeINV DETINVW = new writeINV();

        //PROGRAM UTAMA
        final int N = length;
        double I[][] = new double[N][N];
        for (i=0; i<N; i++){
            for (j=0; j<N; j++){
                if (i==j)
                    I[i][j] = 1;
                else 
                    I[i][j] = 0;
            }
        }

        inobe.invers(M,I);
        boolean identitas = true;
        for (i=0; i<N; i++){
            for (j=0; j<N; j++){
                if ((i==j) && (M[i][j] != 1)){
                    identitas = false;
                }
            }
        }
        if (identitas == true){
            System.out.println("Hasil balikan matriks:");
            DETINVW.write(I,"Hasil Inverse Identitas dan OBE.txt");
        }
        else{
            System.out.println("Matriks tidak memiliki balikan");
        }
    }    
}