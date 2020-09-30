package Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeDET {
    public static void write(double dkof,String name) throws IOException {
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        System.out.println("Determinan Matriks: "+dkof);
        b.write("Hasil Determinan Matriks: ");
        String abc = String.valueOf(dkof);
        b.write(abc+"\n");
        b.close();
    }
}
