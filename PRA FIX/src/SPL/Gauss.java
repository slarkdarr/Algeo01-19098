package SPL;

import Input.readSPL;
import Output.writeSPLGAUSSJORDAN;

import java.io.IOException;
import java.util.Scanner;

public class Gauss{
    public double[][] eselon(double A[][]){
        //KAMUS
        int i,j,k,l;
        int N = A.length;
        int M = A[0].length;
        boolean nol;
        Gauss gauss = new Gauss();

        //ALGORITMA
        //Membuat baris eselon
        k =0;
        for (j=0;j<M-1;j++){
            //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
            gauss.pembulatan(A);
            //Menukar baris apabila nilai elemen yang diinspeksi 0
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
        //Pembulatan bilangan untuk bilangan (1/3).3 untuk double
        gauss.pembulatan(A);

        //Mengembalikan Matriks Eselon
        return A;
    }

    public void pembulatan(double A[][]){
        //KAMUS
        int i,j;
        int N = A.length;
        int M = A.length;
        //ALGORITMA
        for (i=0; i<N; i++){
            for(j=0; j<M; j++){
                if ((A[i][j]>0.99999) || (A[i][j]%1<0.00001)){
                    A[i][j] = Math.round(A[i][j]);
                }
            }
        }
    }

    public void solusi(double A[][]) throws IOException {
        //KAMUS
        writeSPLGAUSSJORDAN write = new writeSPLGAUSSJORDAN();
        int i,j;
        int N = A.length;
        int M = A[0].length;

        //ALGORITMA
        if ((A[N-1][M-2] == 1) && (N == M-1)) {
            //Solusi Unik
            double[][] b = new double[0][0];
            write.main("Hasil SPL SPL.Gauss.txt",A,b,1,true);
            double hasil[] = new double[N];
            for (i=N-1; i>=0; i--){
                hasil[i] = A[i][M-1];
                for (j=i+1; j<N; j++){
                    hasil[i] -= hasil[j]*A[i][j];
                }
            }
            System.out.println("Solusi Unik :");
            for (i=0; i<N-1; i++){
                System.out.print("x"+ (i+1) + " = "+ hasil[i] + ", ");
            }
            System.out.println("x"+ (N) + " = "+ hasil[N-1]);
        }
        else{
            //Mengecek apakah matriks memiliki solusi atau tidak
            boolean ada_solusi = true;
            i = N-1;
            while (i>=0 && ada_solusi == true){
                int jumlah0 = 0;
                for (j=0; j<M-1; j++){
                    if (A[i][j] == 0){
                        jumlah0 += 1;
                    }
                }
                if ((jumlah0 == M-1) && (A[i][M-1] != 0)){
                    ada_solusi = false;
                }
                else{
                    i -= 1;
                }
            }

            //Algoritma untuk matriks apabila ada solusinya dan tidak ada solusinya
            //Solusi berbentuk persamaan parametrik
            if (ada_solusi == true){
                //Menghitung jumlah baris yang semua elemennya 0
                boolean baris_nol = true;
                int jumlah_nol = 0;
                i = N-1;
                while (baris_nol==true && i>=0){
                    int nol = 0;
                    for(j=0; j<M; j++){
                        if (A[i][j] == 0){
                            nol +=1;
                        }
                    }
                    if (nol == M){
                        jumlah_nol += 1;
                        i-=1;
                    }
                    else{
                        baris_nol = false;
                    }
                }

                //Menghitung jumlah variabel bebas
                int selisih = M-N-1;
                int jumlah_bebas;
                if (selisih>0){
                    jumlah_bebas = selisih + jumlah_nol;
                }
                else{
                    jumlah_bebas = jumlah_nol;
                }

                //Inisialisasi matriks hasil
                double hasil[][] = new double[M-1][jumlah_bebas+1];
                for (i=0; i<M-1; i++){
                    for (j=0; j<jumlah_bebas+1; j++){
                        hasil[i][j] = 0;
                    }
                }

                //Mengisi matriks hasil dengan solusi
                int k = 0;
                int a,b;
                int indeks_bebas = M-2;
                for (i=N-1-jumlah_nol; i>=0; i--){
                    j=0;
                    while (j<M-1 && A[i][j]==0){
                        j+=1;
                    }
                    while (indeks_bebas>j){
                        hasil[indeks_bebas][k] = 1; //Variabel bebas dalam matriks hasil
                        indeks_bebas-=1; //Letak baris dalam matriks hasil
                        k+=1; //Letak kolom dalam matriks hasil
                    }
                    indeks_bebas -= 1; //Next Element
                    //Mengisi variabel terikat pada matriks hasil
                    hasil[j][jumlah_bebas] += A[i][M-1];
                    for (a=M-2;a>j;a--){
                        for (b=0; b<=jumlah_bebas; b++){
                            hasil[j][b] -= A[i][a]*hasil[a][b];
                        }
                    }
                }

                //Menampilkan solusi ke layar
                write.main("Hasil SPL SPL.Gauss.txt",A,hasil,jumlah_bebas,ada_solusi);
                System.out.println("Solusi : ");
                for (i=M-2;i>=0;i--){
                    char c = 'r';
                    int nol = 0;
                    System.out.print("x" + (i+1) + " =");
                    for(j=0;j<=jumlah_bebas;j++){
                        if (hasil[i][j] > 0){
                            if (j==jumlah_bebas){
                                if (hasil[i][j]%1 == 0){
                                    System.out.print(String.format(" +%.0f",hasil[i][j]));
                                }
                                else{
                                    System.out.print(String.format(" +%.2f",hasil[i][j]));
                                }
                            }
                            else{
                                if (hasil[i][j] == 1){
                                    System.out.print(" " + c);
                                }
                                else{
                                    if (hasil[i][j]%1 == 0){
                                        System.out.print(String.format(" +%.0f%c",hasil[i][j],c));
                                    }
                                    else{
                                        System.out.print(String.format(" +%.2f%c",hasil[i][j],c));
                                    }
                                }
                            }
                        }
                        else if (hasil[i][j] < 0){
                            if (j==jumlah_bebas){
                                System.out.print(String.format(" %.2f",hasil[i][j]));
                            }
                            else{
                                if (hasil[i][j] == -1){
                                    System.out.print(" -"+c);
                                }
                                else{
                                    if (hasil[i][j]%1 == 0){
                                        System.out.print(String.format(" %.0f%c",hasil[i][j],c));
                                    }
                                    else{
                                        System.out.print(String.format(" %.2f%c",hasil[i][j],c));
                                    }
                                }
                            }
                        }
                        else {
                            nol++;
                        }
                        c++;
                    }
                    if(nol == jumlah_bebas+1) {
                        System.out.print(" 0");
                    }
                    System.out.println();
                }
            }
            //Tidak ada solusi
            else{
                double[][] hasil = new double[0][0];
                write.main("Hasil SPL SPL.Gauss.txt",A,hasil,1,false);
                System.out.println("Solusi tidak ada.");
            }
        }
    } 

    public static void main() throws IOException {
        //KAMUS
        int i,j;
        Scanner scan = new Scanner(System.in);
        Gauss gauss = new Gauss();
        readSPL read = new readSPL();

        //PROGRAM UTAMA
        System.out.println("SPL Eliminasi SPL.Gauss");

        double A[][] = read.main();
        
        A = gauss.eselon(A);
        gauss.solusi(A);
    }
}