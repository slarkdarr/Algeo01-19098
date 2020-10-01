package Output;

import java.io.*;

public class writeINV {
    public static void write(double M[][],String name) throws IOException {
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        String abc;
        for (int i=0;i<M.length;i++) {
            for (int j=0;j< M.length;j++) {
                if (Math.abs(M[i][j])%1 == 0){
                    System.out.print(M[i][j]+" ");
                }
                else{
                    System.out.print(String.format("%.2f ",M[i][j]));
                }
            }
            System.out.println();
        }
        for (int i=0;i<M.length;i++) {
            for (int j=0;j<M.length;j++) {
                if (Math.abs(M[i][j])%1 == 0){
                    abc = String.valueOf(M[i][j]+" ");
                    b.write(abc);
                }
                else{
                    b.write(String.format("%.2f ",M[i][j]));
                }
            }
            b.newLine();
        }
        b.close();
    }
}
