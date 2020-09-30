package Determinan;

import java.util.Scanner;

public class Detobe {
    public double determinan(double M[][]){
        //KAMUS LOKAL
        int i,j,k,l;
        int tukar = 0;
        int N = M.length;
        boolean nol;
        double temp[] = new double[N];

        //ALGORITMA
        for (j=0; j<N; j++){
            // Menukar apabila baris pertama 0            
            if (M[j][j] == 0){
                nol = true;
                i = j+1;
                while ((nol==true) && (i<N)){
                    if (M[i][j] != 0){
                    temp = M[j];
                    M[j] = M[i];
                    M[i] = temp;
                    tukar += 1;
                    nol = false;
                    } 
                    else i+=1;
                }
            }
            
            if (M[j][j] != 0){
                //Operasi pengurangan
                for (i=j+1; i<N; i++){
                    double faktor = M[i][j]/M[j][j];
                    for (k=j; k<N; k++)
                        M[i][k] -= faktor*M[j][k];
                }
            }
        }

        //Menghitung determinan
        double det = M[0][0];
        for (i=1; i<N; i++)
            det *= M[i][i];
        if (tukar%2 == 1)
            det *= -1;
        return det;
    }

    public static void main(String[] args) {
        // KAMUS
        int i,j;
        double hasil;
        Scanner scan = new Scanner(System.in);
        Detobe detobe = new Detobe();

        //PROGRAM UTAMA
        System.out.println("Determinan Reduksi Baris");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        double M[][] = new double[N][N];
        System.out.println("Masukkan Koefisien Matriks : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++)
              M[i][j] = scan.nextDouble();
        
        hasil = detobe.determinan(M);
        System.out.print("Determinan : " + hasil);
    }
}