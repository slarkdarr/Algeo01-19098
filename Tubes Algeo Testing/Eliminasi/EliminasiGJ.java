package Eliminasi;

import java.util.Scanner;

public class EliminasiGJ {
    public static void main(String[] args)
    {
        int m, n;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris matriks: ");
        m = scan.nextInt();
        System.out.print("Masukkan jumlah kolom matriks: ");
        n = scan.nextInt();

        double[][] M = new double[m][n];
        double[][] Mres = new double[m][n];
        double[] res = new double[m];

        System.out.println("Masukkan elemen matriks:");
        readMatrix(m,n,M);
        copyMatrix(M,Mres);
        eliminasiGaussJordan(Mres);
        makeGauss(Mres);
        System.out.println("Matriks hasil eliminasi Gauss-Jordan:");
        printMatrix(Mres);
        backSub(Mres,res);
        System.out.println("Solusi persamaan:");
        printSolusi(n,res);
    }

    private static void eliminasiGaussJordan(double[][] M)
    {
        int i, j, k = 0, l;
        int m = M.length;
        int n = M[0].length;
        boolean nol;

        for (j = 0; j < m; j++) {
            //Menukar baris apabila elemen yang diinspeksi 0
            if (M[k][j] == 0) {
                double[] temp;
                nol = true;
                i = k + 1;
                while (nol && (i < m)) {
                    if (M[i][j] != 0) {
                        //Menukar di matriks biasa
                        temp = M[k];
                        M[k] = M[i];
                        M[i] = temp;
                        nol = false;
                    } else i += 1;
                }
            }

            if (M[k][j] != 0) {
                //Membuat elemen menjadi 1
                double pembagi = M[k][j];
                for (l = j; l < n; l++) {
                    M[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i = k + 1; i < m; i++) {
                    double faktor = M[i][j];
                    for (l = 0; l < n; l++) {
                        M[i][l] -= faktor * M[k][l];
                    }
                }
                k += 1;
            }
        }
        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j < (n - 1); j++){
            if (M[k][j] == 1){
                for (i = 0; i < k; i++){
                    double faktor = M[i][j];
                    for (l = 0; l < n; l++){
                        M[i][l] -= faktor * M[k][l];
                    }
                }
                k += 1;
            }
        }
    }

    public static void makeGauss(double[][] M) {
        double current;
        int loc;
        int m = M.length;
        int n = M[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                if(M[i][j] != 0) {
                    current = M[i][j];
                    loc = j;
                    for (int k = loc; k < n; k++) {
                        M[i][k] /= current;
                    }
                    break;
                }
            }
        }
    }

    // Back Substitution
    private static void backSub(double[][] M, double[] temp)
    {
        int i, j;
        int m = M.length;
        int n = M[0].length;

        for (i = (m - 1); i >= 0; i--)
        {
            temp[i] = M[i][n - 1];
            for (j = (i + 1); j < (n - 1); j++)
            {
                temp[i] -= temp[j] * M[i][j];
            }
            temp[i] /= M[i][i];
        }
    }

    // Membaca masukan ordo dan elemen matriks dari pengguna
    private static void readMatrix(int m, int n, double[][] M)
    {
        int i, j;

        Scanner scan = new Scanner(System.in);

        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                M[i][j] = scan.nextDouble();
            }
        }
    }

    // Salin matriks
    private static void copyMatrix(double[][] M1, double[][] M2)
    {
        int i, j;
        int m = M1.length;
        int n = M1[0].length;

        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                M2[i][j] = M1[i][j];
            }
        }
    }

    // Menampilkan matriks hasil
    private static void printMatrix(double[][] M)
    {
        int i, j;
        int m = M.length;
        int n = M[0].length;

        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                System.out.print(M[i][j]);
                if(j != n-1)
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            if(i == (m - 1))
            {
                System.out.print("\n");
            }
        }
    }

    // Menampilkan solusi dari matriks hasil
    private static void printSolusi(int n, double[] res)
    {
        for (int i = 0; i < (n - 1); i++)
        {
            System.out.println("x[" + (i + 1) + "] = " + res[i]);
        }
    }
}
