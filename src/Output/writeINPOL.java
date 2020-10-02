package Output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeINPOL {
    public static void write(double[] hasil,int N,double x,double sum,String name) throws IOException {
        String filename = name;
        FileWriter a = new FileWriter(name);
        BufferedWriter b = new BufferedWriter(a);
        b.write(String.format("p%d(x)= %.4f",N,hasil[0]));
        for (int i = 1; i <=N ; i++) {
            if (hasil[i] < 0) {
                b.write(String.format(" - %.4fx^%d", (-1 * hasil[i]), i));
            } else {
                b.write(String.format(" + %.4fx^%d", hasil[i], i));
            }
        }
        b.write("\n");
        b.write(String.format("p"+N+"("+x+") "+" = %.4f",sum));
        b.close();
    }
}

