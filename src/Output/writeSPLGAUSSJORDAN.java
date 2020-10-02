package Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeSPLGAUSSJORDAN {
    public static void main(String name,double[][] A,double[][] hasil,int jumlah_bebas,boolean ada_solusi) throws IOException {
        int i,j,N= A.length,M= A[0].length;
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        if ((A[N-1][M-2]==1)&&(N==M-1)) {
            double hasil1[] = new double[N];
            for (i=N-1; i>=0; i--){
                hasil1[i] = A[i][M-1];
                for (j=i+1; j<N; j++){
                    hasil1[i] -= hasil1[j]*A[i][j];
                }
            }
            b.write("Solusi Unik :\n");
            for (i=0; i<N-1; i++){
                b.write("x"+ (i+1) + " = "+ hasil1[i] + ", ");
            }
            b.write("x"+ (N) + " = "+ hasil1[N-1]);
        }
        else {
            if (ada_solusi == true) {
                b.write("Solusi : \n");
                for (i = M - 2; i >= 0; i--) {
                    char c = 'r';
                    int nol = 0;
                    b.write("x" + (i + 1) + " =");
                    for (j = 0; j <= jumlah_bebas; j++) {
                        if (hasil[i][j] > 0) {
                            if (j == jumlah_bebas) {
                                if (hasil[i][j] % 1 == 0) {
                                    b.write(String.format(" +%.0f", hasil[i][j]));
                                } else {
                                    b.write(String.format(" +%.2f", hasil[i][j]));
                                }
                            } else {
                                if (hasil[i][j] == 1) {
                                    b.write(" " + c);
                                } else {
                                    if (hasil[i][j] % 1 == 0) {
                                        b.write(String.format(" +%.0f%c", hasil[i][j], c));
                                    } else {
                                        b.write(String.format(" +%.2f%c", hasil[i][j], c));
                                    }
                                }
                            }
                        } else if (hasil[i][j] < 0) {
                            if (j == jumlah_bebas) {
                                b.write(String.format(" %.2f", hasil[i][j]));
                            } else {
                                if (hasil[i][j] == -1) {
                                    b.write(" -" + c);
                                } else {
                                    if (hasil[i][j] % 1 == 0) {
                                        b.write(String.format(" %.0f%c", hasil[i][j], c));
                                    } else {
                                        b.write(String.format(" %.2f%c", hasil[i][j], c));
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
                        b.write(" 0");
                    }
                    b.write("\n");
                }
            }
            else {
                b.write("Solusi tidak ada.\n");
            }
        }
        b.close();
    }
}
