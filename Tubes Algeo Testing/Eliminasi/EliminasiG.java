package src.Eliminasi;

import java.util.Scanner;

public class EliminasiG {

    public static void main(String[] args)
    {
        int m, n;
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah baris: ");
        m = scan.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        n = scan.nextInt();

        double[][] M = new double[m][n];
        double[][] Mres = new double[m][n];
        System.out.println("Masukkan elemen matriks:");
        readMatrix(m,n,M);
        copyMatrix(m,n,M,Mres);
        eliminasiGauss(m,n,Mres);
        System.out.println("Matriks hasil eliminasi Gauss adalah:");
        printMatrix(m,n,Mres);
        backSub(m,n,Mres);
    }

    public static void eliminasiGauss(int m, int n, double[][] M)
    {
        int i, j, k;
        for(i = 0; i < m-1; i++)
        {
            for(k = i + 1; k < m; k++)
            {
                double temp = M[k][i] / M[i][i];
                for(j = 0; j < n; j++)
                {
                    M[k][j] -= temp * M[i][j];
                }
            }
        }
    }

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
            if(i == m-1)
            {
                System.out.print("\n");
            }
        }
    }

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

    private static void backSub(int m, int n, double[][] M)
    {
        int i, j;
        double[] res = new double[m];

        for(i = m - 2; i >= 0; i--)
        {
            res[i] = M[i][m-1];
            for(j = i + 1; j < n; j++)
            {
                res[i] -= res[j] * M[i][j];
            }
            res[i] /= M[i][i];
        }

        System.out.println("Solusi persamaan tersebut adalah:");
        for(i = 0; i < m-1; i++)
        {
            System.out.println("x[" + (i+1) + "] = " + res[i]);
        }
    }
}
