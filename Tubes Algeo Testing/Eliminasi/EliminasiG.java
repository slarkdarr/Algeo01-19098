package src.Eliminasi;

public class EliminasiG {
    static void Eliminasi_Gauss(float[][] M){
        int i, j, k;
        int maks;
        float temp, obe, sum;

        int n = M.length;

        float[n] P;

        for (j = 0; j < n; j++){
            //Tukar baris
            maks = j;
            for (i = j + 1; i < n; i++){
                if (M[i][j] > M[maks][j]){
                    maks = i;
                }
                temp = M[i][j];
                M[i][j] = M[maks][j];
                M[maks][j] = temp;

            //Membuat matriks segitiga atas
                obe = M[i][j] / M[j][j];
                for (k = 0; k <= n; k++){
                    M[i][k] -= obe * M[j][k];
            }
            }
        }

        P[n] = M[n][n+1] / M[n][n];

        //Teknik backward substitution
        for (i = n - 1; i >= 0; i--){
            sum = 0;
            for (j = i + 1; j < n; j++){
                sum += M[i][j] * P[j];
            }
            P[i] = (M[i][n+1] - sum) / M[i][i];
        }
        System.out.println("\nHasil matriksnya adalah:\n");
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                System.out.println(M[i][j]);
            }
            System.out.println("| " + P[i]);
        }
        System.out.println();
        System.out.println("Solusinya adalah:\n");
        for (i = 0; i < n; i++){
            System.out.println("X" + (i+1) + " = " + P[i]);
        }
    }
}
