package src.Eliminasi;

public class EliminasiGJ {
    static int Eliminasi_Gauss_Jordan(float[][] M)
    {
        int i, j, k;
        int flag = 0, n = M.length;
        float obe, temp;

        for (i = 0; i < n; i++)
        {
            if (M[i][i] == 0)
            {
                int l = 1;
                while ((i + l) < n && M[i + l][i] == 0)
                {
                    l++;
                }
                if ((i + l) == n)
                {
                    flag = 1;
                    break;
                }
                for (k = 0; k <= n; k++)
                {
                    j = i;
                    temp = M[j][k];
                    M[j][k] = M[j+1][k];
                    M[j+1][k] = temp;
                }
            }

            for (j = 0; j < n; j++)
            {
                // Ketika baris tidak sama dengan kolom (bukan diagonal)
                if (i != j)
                {
                    // Mengubah matriks ke dalam bentuk matriks eselon baris
                    obe = M[j][i] / M[i][i];
                    for (k = 0; k <= n; k++)
                    {
                        M[j][k] -= M[i][k] * obe;
                    }
                }
            }
        }
        return flag;
    }

    // Fungsi untuk mengeprint hasil matriks
    static void Print_Hasil(float M[][], int flag)
    {
        int i, n = M.length;

        if (flag == 2)
        {
            System.out.println("Solusi tak hingga\n");
        }
        else if (flag == 3)
        {
            System.out.println("Tidak ada solusi\n");
        }
        else
        {
            // Print solusi dengan membagi setiap konstanta dengan elemen diagonalnya
            for (i = 0; i < n; i++)
            {
                float hasil = M[i][n] / M[i][i];
                System.out.println(hasil);
                // Mengecek ketika i bukan elemen terakhir
                if (i != (n - 1))
                {
                    System.out.println(" ");
                }
            }
        }
    }

    // Fungsi untuk mengecek apakah solusinya tak hingga atau nol
    static int Cek(float M[][], int flag)
    {
        int i, j, n = M.length;
        float sum = 0;

        flag = 3;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                sum += M[i][j];
            }
            if (sum == M[i][j])
            {
                flag = 2;
            }
        }
        return flag;
    }
}
