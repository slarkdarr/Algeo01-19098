package SPL;
import java.util.Scanner;

public class GaussJ {
    public double[][] eselonred(double A[][]){
        //KAMUS
        int i,j,k,l;
        int N = A.length;
        int M = A[0].length;
        boolean nol;

        //ALGORITMA
        //Menukar baris apabila nilai elemen yang diinspeksi 0
        k =0;
        for (j=0;j<M-1;j++){
            if (A[k][j] == 0){
                double temp[] = new double[N];
                nol = true;
                i = k+1;
                while ((nol==true) && (i<N)){
                    if (A[i][j] != 0){
                        //Menukar di matriks biasa
                        temp = A[k];
                        A[k] = A[i];
                        A[i] = temp;
                        nol = false;
                    } 
                    else i+=1;
                }
            }
 
            if (A[k][j] != 0){
                //Membuat elemen menjadi 1
                double pembagi = A[k][j];
                for (l=0;l<M;l++){
                    A[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i=k+1; i<N; i++){
                    double faktor = A[i][j];
                    for (l=0; l<M; l++){
                        A[i][l] -= faktor*A[k][l];
                    }
                }
                k += 1;
            }
        }

        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<M-1; j++){
            if (A[k][j] == 1){
                for (i=0; i<k; i++){
                    double faktor = A[i][j];
                    for (l=0; l<M; l++){
                        A[i][l] -= faktor * A[k][l];
                    }
                }
                k += 1;
            }
        }

        //Mengembalikan Matriks Eselon
        return A;
    }

    public static void main(String[] args){
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        GaussJ gaussj = new GaussJ();

        //PROGRAM UTAMA
        System.out.println("SPL Eliminasi Gauss-Jordan");
        System.out.print("Masukkan jumlah baris matriks augmented : ");
        int N = scan.nextInt();
        System.out.print("Masukkan jumlah kolom matriks augmented : ");
        int M = scan.nextInt();

        double A[][] = new double[N][M];

        System.out.println("Masukkan Koefisien Persamaan Matriks Augmented : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < M; j++)
                A[i][j] = scan.nextDouble();
        
        A = gaussj.eselonred(A);
        for (i = 0; i < N; i++){
            for (j = 0; j < M; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
