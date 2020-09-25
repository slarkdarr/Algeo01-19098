package SPL;
import Determinan.Detkof;
import java.util.Scanner;

public class Crammer {
    public double[] crammer(double A[][],double B[]){
        //KAMUS
        Detkof detkof = new Detkof();
        int i,j,k;
        int N = A.length;
        double hasil[] = new double[N];
        double temp[][] = new double[N][N];

        //ALGORITMA
        for (k=0;k<N;k++){
            //Menyalin isi matriks A ke dalam temp
            for (i=0;i<N;i++)
                for (j=0;j<N;j++)
                    temp[i][j] = A[i][j];
            
            //Mengganti kolom-k temp dengan hasil B
            for (i=0;i<N;i++){
                temp[i][k] = B[i];
            }

            //Menghitung variabel dengan determinan & menyetornya di matriks hasil
            hasil[k] = detkof.determinan(temp)/detkof.determinan(A);
        }
        return hasil;
    }

    public static void main(String[] args){
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        Crammer cram = new Crammer();

        //PROGRAM UTAMA
        System.out.println("SPL Metode Crammer");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        double A[][] = new double[N][N];
        System.out.println("Masukkan Koefisien Persamaan : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++)
              A[i][j] = scan.nextDouble();
        
        double B[] = new double[N];
        System.out.println("Masukkan Koefisien Hasil : ");
        for (i=0;i<N;i++)
            B[i] = scan.nextDouble();        

        double hasil[] = new double[N];
        hasil = cram.crammer(A,B);
        System.out.println("Penyelesaian SPL : ");
        for (i=0; i<hasil.length; i++){
            System.out.println("x" + (i+1) + " : " + hasil[i]);
        }
    }
}