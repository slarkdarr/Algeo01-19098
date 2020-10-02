package Regresi;

import Input.readREGLIN;
import Output.writeREGLIN;

import java.io.IOException;
import java.util.Scanner;

public class REGLIN {
    public static void main() throws IOException {
        readREGLIN read = new readREGLIN();
        double[][] M = read.main();
        int data = M.length;
        double[][] reg;
        reg = makereg(M,data);
        //Pembuatan matriks eselon
        int i,j,k,l;
        int N = reg.length;
        boolean nol;
        k = 0;
        for (j=0;j<N;j++){
            if (k<N){
                //Menukar baris apabila elemen yang diinspeksi 0
                if (reg[k][j] == 0){
                    double temp[] = new double[N];
                    nol = true;
                    i = k+1;
                    while ((nol==true) && (i<N)){
                        if (reg[i][j] != 0){
                            //Menukar di matriks biasa
                            temp = reg[k];
                            reg[k] = reg[i];
                            reg[i] = temp;
                            nol = false;
                        }
                        else i+=1;
                    }
                }

                if (reg[k][j] != 0){
                    //Membuat elemen menjadi 1
                    double pembagi = reg[k][j];
                    for (l=0;l<=N;l++){
                        reg[k][l] /= pembagi;
                    }
                    //Mengurangi elemen di bawahnya
                    for (i=k+1; i<N; i++){
                        double faktor = reg[i][j];
                        for (l=0; l<=N; l++){
                            reg[i][l] -= faktor*reg[k][l];
                        }
                    }
                    k += 1;
                }
            }
        }

        //Membuat matriks eselon tereduksi
        k = 0;
        for (j=0; j<N; j++){
            if (k<N){
                if (reg[k][j] == 1){
                    for (i=0; i<k; i++){
                        double faktor = reg[i][j];
                        for (l=0; l<=N; l++){
                            reg[i][l] -= faktor * reg[k][l];
                        }
                    }
                    k += 1;
                }
            }
        }
        System.out.println("Hasil Persamaan");
        System.out.print("y= ");
        int kol = reg[0].length-1;
        System.out.print(String.format("%.4f ",reg[0][kol]));
        for (i=1;i<N;i++) {
            if (reg[i][kol]<0) {
                System.out.print(String.format("- %.4fx%di ", -1*reg[i][kol], i));
            }
            else {
                System.out.print(String.format("+ %.4fx%di ", reg[i][kol], i));
            }
        }
        System.out.println("+ ei");
        System.out.println();
        System.out.println("Apakah anda ingin memasukan nilai-nilai x baru untuk menemukan y? ");
        System.out.println("Masukkan 1 apabila iya & 0 apabila tidak");
        Scanner scan = new Scanner(System.in);
        int uji = scan.nextInt();
        double sum = reg[0][kol];
        double[] tes = new double[N];
        writeREGLIN write = new writeREGLIN();
        while (uji==1) {
            System.out.println("Masukkan nilai variabel dari x1 hingga xn");
            for (i=1;i<N;i++) {
                tes[i] = scan.nextDouble();
            }
            for (i=1;i<N;i++) {
                sum += reg[i][kol]*tes[i];
            }
            System.out.println(String.format("Hasil y adalah %.4f",sum));
            write.write(reg,N,kol,sum,"../Hasil Regresi Linear.txt");
            uji = 0;
        }
    }

    public static double[][] makereg(double[][] m,int data) {
        double[][] reg = new double[m[0].length][m[0].length+1];
        reg[0][0] = data;
        for(int j=1;j<m[0].length;j++) {
            reg[0][j] = sumdata(m,j);
        }
        for(int i=1;i<m[0].length;i++) {
            reg[i][0] = reg[0][i];
        }
        // karena y di tabel awal berada di index kolom 0, maka dipisah
        reg[0][m[0].length] = sumdata(m,0);
        for(int i=1;i<m[0].length;i++) {
            for (int j=1;j<m[0].length;j++) {
                reg[i][j] = sumkalidata(m,i,j);
            }
        }
        // karena y di tabel awal berada di index kolom 0, maka dipisah
        for(int i=1;i<m[0].length;i++) {
            reg[i][m[0].length] = sumkalidata(m,i,0);
        }
        return reg;
    }

    public static double sumkalidata(double[][] m,int i,int j) {
        double sumkali = 0;
        for (int x=0;x<m.length;x++) {
            sumkali += m[x][i]*m[x][j];
        }
        return sumkali;
    }

    public static double sumdata(double[][] m,int j) {
        double sum = 0;
        for (int x=0;x<m.length;x++) {
            sum += m[x][j];
        }
        return sum;
    }
}
