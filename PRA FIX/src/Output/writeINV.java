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
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }
        for (int i=0;i<M.length;i++) {
            for (int j=0;j<M.length;j++) {
                abc = String.valueOf(M[i][j]+" ");
                b.write(abc);
            }
            b.newLine();
        }
        b.close();
    }
}
