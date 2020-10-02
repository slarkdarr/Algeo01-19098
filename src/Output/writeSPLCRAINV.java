package Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeSPLCRAINV {
    public static void write(double[] hasil,String name, int xyz) throws IOException {
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        if (xyz==0) {
            b.write("Tidak dapat menyelesaikan SPL karena matriks tidak memiliki balikan\n");
        }
        else {
            System.out.println("Penyelesaian SPL : ");
            for (int i = 0; i < hasil.length; i++) {
                System.out.println("x" + (i + 1) + " : " + hasil[i]);
            }
            String abc;
            for (int i = 0; i < hasil.length; i++) {
                b.write("X" + (i + 1) + "= ");
                abc = String.valueOf(hasil[i]);
                b.write(abc + "\n");
            }
        }
        b.close();
    }
}
