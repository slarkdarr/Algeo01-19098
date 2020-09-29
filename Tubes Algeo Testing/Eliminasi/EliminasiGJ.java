package src.Eliminasi;

import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class EliminasiGJ {
    public static void main(String[] args)
    {
        int m, n;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris matriks: ");
        m = scan.nextInt();
        System.out.print("Masukkan jumlah kolom matriks: ");
        n = scan.nextInt();

        double[][] M = new double[n][n];
        double[][] Mres = new double[n][n];
        double[] res = new double[n];

        System.out.println("Masukkan elemen matriks:");
        readMatrix(m,n,M);
        copyMatrix(m,n,M,Mres);
        eliminasiGaussJordan(m,n,Mres);
        System.out.println("Matriks hasil eliminasi Gauss-Jordan:");
        printMatrix(m,n,Mres);
        backSub(m,n,Mres,res);
        System.out.println("Solusi persamaan:");
        printSolusi(n,res);
    }

    private static void eliminasiGaussJordan(int m, int n, double[][] M)
    {
        int i, j, k, l;
        double temp;

        // Pivoting matriks
        for(i = 0; i < (m - 1); i++)
        {
            for(k = (i + 1); k < m; k++)
            {
                // Jika nilai mutlak dari elemen diagonal lebih kecil dari nilai
                // mutlak elemen di bawahnya, maka kedua elemen tersebut ditukar
                if(abs(M[i][i]) < abs(M[k][i]))
                {
                    for(j = 0; j < n; j++)
                    {
                        swap(M[i][j], M[k][j]);
                    }
                }
            }
            // Eliminasi Gauss
            for(k = (i + 1); k < m; k++)
            {
                temp = M[k][i] / M[i][i];
                for(j = 0; j < n; j++)
                {
                    M[k][j] -= temp * M[i][j];
                }
            }
        }

        // Membuat matriks eselon baris tereduksi
        k = 0;
        for (j = 0; j < n; j++){
            if (M[k][j] == 1){
                for (i = 0; i < k; i++){
                    double faktor = M[i][j];
                    for (l = 0; l <= n; l++){
                        M[i][l] -= faktor * M[k][l];
                    }
                }
                k += 1;
            }
        }
    }

    // Back Substitution
    private static void backSub(int m, int n, double[][] M, double[] temp)
    {
        int i, j;

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

    // Menukar elemen matriks
    private static void swap(double arg1, double arg2)
    {
        double temp;

        temp = arg1;
        arg1 = arg2;
        arg2 = temp;
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
    private static void copyMatrix(int m, int n, double[][] M1, double[][] M2)
    {
        int i, j;
        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                M2[i][j] = M1[i][j];
            }
        }
    }

    // Menampilkan matriks hasil
    private static void printMatrix(int m, int n, double[][] M)
    {
        int i, j;
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
