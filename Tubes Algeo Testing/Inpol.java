import java.util.Scanner;

public class Inpol {
    public double[] interpolasi(double M[][]){
        //KAMUS
        int i,j,k,l;
        int N = M.length;
        boolean nol;
        double A[][] = new double[N][N+1];
        double hasil[] = new double[N];
        Inpol inpol = new Inpol();

        //ALGORITMA
        A = inpol.ubahpers(M);
        //Pembuatan matriks eselon
        k =0;
        for (j=0;j<N;j++){
            //Menukar baris apabila elemen yang diisnpeksi 0
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
                    } 
                    else i+=1;
                }
            }
 
            if (A[k][j] != 0){
                //Membuat elemen menjadi 1
                double pembagi = A[k][j];
                for (l=0;l<=N;l++){
                    A[k][l] /= pembagi;
                }
                //Mengurangi elemen di bawahnya
                for (i=k+1; i<N; i++){
                    double faktor = A[i][j];
                    for (l=0; l<=N; l++){
                        A[i][l] -= faktor*A[k][l];
                    }
                }
                k += 1;
            }
        }
 
        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<N; j++){
            if (A[k][j] == 1){
                for (i=0; i<k; i++){
                    double faktor = A[i][j];
                    for (l=0; l<=N; l++){
                        A[i][l] -= faktor * A[k][l];
                    }
                }
                k += 1;
            }
        }

        //Membuat Baris Hasil
        for (i=0; i<N; i++){
            hasil[i] = A[i][N];
        }
        return hasil;
    }
    
    public double[][] ubahpers(double M[][]){
        //KAMUS
        int i,j,k;
        int N = M.length;
        double hasil[][] = new double[N][N+1];

        //ALGORITMA
        for (i=0; i<N;i++){
            for (j=0; j<N; j++){
                hasil[i][j] = 1;
                for (k=0; k<j; k++){
                    hasil[i][j] *= M[i][0];
                }
            }
            hasil[i][N] = M[i][1];
        }
        return hasil;
    }

    public static void main(String[] args){
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        Inpol inpol = new Inpol();

        //PROGRAM UTAMA
        System.out.println("Interpolasi Polinom");
        System.out.print("Masukkan N : ");
        int N = scan.nextInt();

        double M[][] = new double[N+1][2];
        double hasil[] = new double[N+1];

        System.out.println("Masukkan Titik Data : ");
        for (i = 0; i <= N; i++) 
            for (j = 0; j < 2; j++)
                M[i][j] = scan.nextDouble();
        
        //Memasukan data hasil ke variabel hasil
        hasil = inpol.interpolasi(M);
        //Mencetak bentuk persamaan
        System.out.println("Bentuk Persamaan : ");
        System.out.print("p" + N + "(x) = " + hasil[0]);
        for (i=1; i<=N; i++){
            if (hasil[i] < 0){
                System.out.print(" " +  hasil[i] + "x^" + i);
            }
            else{
                System.out.print(" + " +  hasil[i] + "x^" + i);
            }
        }
        System.out.println();

        System.out.println("Apakah anda ingin memasukan nilai x? ");
        System.out.println("Masukkan 1 apabila iya & 0 apabila tidak");
        int uji = scan.nextInt();
        while (uji == 1){
            double sum = 0;
            double x = scan.nextDouble();
            for (i=0; i<=N; i++){
                double total = hasil[i];
                for (j=0; j<i; j++){
                    total *= x;
                }
                sum += total;
            }
            System.out.println("p"+N+"("+x+") = " + sum);
            uji = scan.nextInt();
        }
    }
}