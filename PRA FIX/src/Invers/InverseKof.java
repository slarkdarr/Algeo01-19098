package Invers;

import Determinan.Detkof;
import Output.writeINV;

import java.io.IOException;

public class InverseKof
{
    public static void main(String[] args)
    {
        /*
        Scanner masup = new Scanner(System.in);
        int baris,kolom;
        baris = masup.nextInt();
        kolom = masup.nextInt();
        double[][] a = new double[baris][kolom];
        for (int i=0;i<baris;i++)
        {
            for (int j=0;j<kolom;j++)
            {
                a[i][j] = masup.nextDouble();
            }
        }
        double adj[][] = new double[baris][kolom];
        adj = InKof(a);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }

         */
    }

    public static double[][] minor(double[][] a, int i, int j, int baris, int kolom)
    {
        double[][] temp = new double[baris][kolom];
        for (int x=0;x<baris;x++) {
            for (int y=0;y<kolom;y++)
            {
                temp[x][y] = -999;
            }
        }
        double[][] b = new double[baris-1][kolom-1];
        for (int x=0;x<baris;x++)
        {
            if (x==i)
            {
                continue;
            }
            for (int y=0;y<kolom;y++)
            {
                if (y==j)
                {
                    continue;
                }
                temp[x][y] = a[x][y];
            }
        }
        int markb=-1,markk=-1;
        boolean gotem = false;
        for (int x=0;x<baris;x++)
        {
            for (int y=0;y<kolom;y++)
            {
                if(temp[x][y]!=-999)
                {
                    markb = x;
                    markk = y;
                    gotem = true;
                    break;
                }
            }
            if(gotem)
            {
                break;
            }
        }
        int currmb=markb, currmk=0;
        for (int x=0;x<baris-1;x++)
        {
            currmk = markk;
            for (int y=0;y<baris-1;y++)
            {
                b[x][y] = temp[currmb][currmk];
                currmk++;
                int cekval = currmk;
                if (cekval==kolom)
                {
                    break;
                }
                else {
                    if(temp[currmb][currmk]==-999)
                    {
                        currmk++;
                    }
                }
            }
            currmb++;
            int cekbar = currmb;
            if (cekbar==baris)
            {
                break;
            }
            else {
                if(temp[currmb][markk]==-999)
                {
                    currmb++;
                }
            }
        }
        return b;
    }

    public static void InKof(double M[][]) throws IOException {
        int baris = M.length;
        int kolom = M.length;
        Detkof detkof = new Detkof();
        writeINV DETINVW = new writeINV();
        if (detkof.determinan(M) != 0) {
            double[][] adj = new double[baris][kolom];
            for (int i = 0; i < baris; i++) {
                for (int j = 0; j < kolom; j++) {
                    double[][] tesm = new double[baris - 1][kolom - 1];
                    tesm = minor(M, i, j, baris, kolom);
                    adj[i][j] = detkof.determinan(tesm);
                    if ((i % 2 == 1 && j % 2 == 0) || (i % 2 == 0 && j % 2 == 1)) {
                        adj[i][j] *= -1;
                    }
                }
            }
            double det = detkof.determinan(M);
            for (int i = 0; i < baris; i++) {
                for (int j = i; j < kolom; j++) {
                    if (i != j) {
                        double temp = adj[i][j];
                        adj[i][j] = adj[j][i];
                        adj[j][i] = temp;
                    }
                }
            }
            for (int i = 0; i < baris; i++) {
                for (int j = 0; j < kolom; j++) {
                    adj[i][j] /= det;
                }
            }
            System.out.println("Hasil balikan matriks:");
            DETINVW.write(adj,"Hasil Inverse Adjoin.txt");
        }
        else {
            System.out.println("Tidak ada Matriks SPL.Balikan");
        }
    }
}
