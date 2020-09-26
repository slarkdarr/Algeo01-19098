package SPL;
import java.util.Scanner;

public class Balikan {
    public void invers(double M[][], double I[][]){
        //KAMUS
        int i,j,k,l;
        final int N = M.length;
        boolean nol;
        double temp[] = new double[N];
        //ALGORITMA
        //Pembuatan matriks eselon
        k =0;
        for (j=0;j<N;j++){
            //Menukar baris apabila elemen yang diisnpeksi 0
            if (M[k][j] == 0){
                nol = true;
                i = k+1;
                while ((nol==true) && (i<N)){
                    if (M[i][j] != 0){
                        //Menukar di matriks biasa
                        temp = M[k];
                        M[k] = M[i];
                        M[i] = temp;
                        //Menukar di matriks identitas
                        temp = I[k];
                        I[k] = I[i];
                        I[i] = temp;
                        nol = false;
                    } 
                    else i+=1;
                }
            }

            if (M[k][j] != 0){
                //Membuat elemen menjadi 1
                final double pembagi = M[k][j];
                for (l=0;l<N;l++){
                    M[k][l] /= pembagi; 
                    I[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i=k+1; i<N; i++){
                    final double faktor = M[i][j];
                    for (l=0; l<N; l++){
                        M[i][l] -= faktor*M[k][l];
                        I[i][l] -= faktor*I[k][l];
                    }
                }
                k += 1;
            }
        }

        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<N; j++){
            if (M[k][j] == 1){
                for (i=0; i<k; i++){
                    double faktor = M[i][j];
                    for (l=0; l<N; l++){
                        I[i][l] -= faktor * I[k][l];
                        M[i][l] -= faktor * M[k][l];
                    }
                }
                k += 1;
            }
        }
    }

    public double[] kali(double M[][], double B[]){
        //KAMUS
        int i,j;
        int N = M.length;
        double hasil[] = new double[N];

        //ALGORITMA
        for (i=0; i<N; i++){
            hasil[i] = 0;
            for (j=0; j<N; j++){
                hasil[i] += M[i][j] * B[j];
            }
        }
        return hasil;
    }

    public static void main(String[] args){
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        Balikan balikan = new Balikan();

        //PROGRAM UTAMA
        System.out.println("SPL Metode Matriks Balikan");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        //Pembuatan matriks identitas
        double I[][] = new double[N][N];
        for (i=0; i<N; i++){
            for (j=0; j<N; j++){
                if (i==j)
                    I[i][j] = 1;
                else 
                    I[i][j] = 0;
            }
        }

        double A[][] = new double[N][N];
        System.out.println("Masukkan Koefisien Persamaan : ");
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++)
              A[i][j] = scan.nextDouble();
        
        double B[] = new double[N];
        System.out.println("Masukkan Koefisien Hasil : ");
        for (i=0;i<N;i++)
            B[i] = scan.nextDouble();        

        //Menginverskan matriks
        balikan.invers(A, I);

        //Mengecek apakah matriks ada balikan atau tidak
        boolean identitas = true;
        for (i=0; i<N; i++){
            for (j=0; j<N; j++){
                if ((i==j) && (A[i][j] != 1)){
                    identitas = false;
                }
            }
        }

        //Menuliskan output
        if (identitas == true){
            double hasil[] = new double[N];
            hasil = balikan.kali(I,B);
            System.out.println("Penyelesaian SPL : ");
            for (i=0; i<hasil.length; i++){
                System.out.println("x" + (i+1) + " : " + hasil[i]);
            }
        }
        else{
            System.out.println("Tidak dapat menyelesaikan SPL karena matriks tidak memiliki balikan");
        }
    }
}