package Determinan;
import java.util.Scanner;

public class Detkof{
    public double determinan(double M[][]){
        //KAMUS LOKAL
        int i,j,k;
        int N =M.length;
        double det = 0;
        double temp[][] = new double[N-1][N-1];
        //ALGORITMA
        if (N == 2){
            return ((M[0][0]*M[1][1]) - (M[1][0]*M[0][1]));
        }
        else{
            for (i=0; i<N; i++){
                for (j=1;j<N;j++){
                    for (k=0;k<N;k++){
                        if (i>k)
                            temp[k][j-1] = M[k][j];
                        else if (i<k)
                            temp[k-1][j-1] = M[k][j];
                    }
                }
            
                if (i%2 == 0)
                    det += determinan(temp) * M[i][0];
                else
                    det -= determinan(temp) * M[i][0];   
            }
            return det;
        }
    }

    public static void main(String[] args) {
        // KAMUS
        int i,j;
        double hasil;
        Scanner scan = new Scanner(System.in);
        Detkof kof = new Detkof();

        //PROGRAM UTAMA
        System.out.println("Determinan Menggunakan Kofaktor");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        double M[][] = new double[N][N];
        System.out.println("Masukkan Koefisien Matriks : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++)
              M[i][j] = scan.nextDouble();
        
        hasil = kof.determinan(M);
        System.out.print("Determinan : " + hasil);
    }
}