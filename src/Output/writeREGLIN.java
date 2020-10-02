package Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeREGLIN {
    public static void write(double[][] reg,int N,int kol,double sum,String name) throws IOException {
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        b.write(String.format("y= %.4f ",reg[0][kol]));
        for (int i = 1; i <N ; i++) {
            if (reg[i][kol] < 0) {
                b.write(String.format("- %.4fx%di ", -1*reg[i][kol], i));
            } else {
                b.write(String.format("+ %.4fx%di ", reg[i][kol], i));
            }
        }
        b.write("\n");
        b.write(String.format("Hasil y adalah %.4f",sum));
        b.close();
    }
}
