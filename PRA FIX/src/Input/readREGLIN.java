package Input;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class readREGLIN {
    public static double[][] main() throws FileNotFoundException {
        Scanner metoda = new Scanner(System.in);
        System.out.println("1 untuk membaca input keyboard, 2 untuk membaca input file");
        int metode = metoda.nextInt();
        double[][] matrix = new double[0][0];
        if (metode==1) {
            matrix = inputkey();
        }
        else {
            matrix = inputfile();
        }
        return matrix;
        /* tes print
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

         */
    }

    private static double[][] inputkey() {
        Scanner input = new Scanner(System.in);
        // asumsikan semua input adalah jumlah total dari data yang diberikan
        System.out.println("Masukkan jumlah variabel x");
        int n = input.nextInt();
        System.out.println("Masukkan jumlah data yang ada");
        int data = input.nextInt();
        double[][] matrix = new double[data+1][n+1];
        System.out.println("Masukkan data yang ada");
        System.out.println("Nilai variabel x terlebih dahulu, baru diakhiri oleh y");
        for (int i=0;i<data;i++) {
            for (int j=0;j<n+1;j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    private static double[][] inputfile() throws FileNotFoundException {
        File file = new File("test\\INPUT REGRESI.txt");
        Scanner scanfile = new Scanner(file);
        // hitung kolom
        int kolom = 0;
        String[] length = scanfile.nextLine().trim().split("\\s+");
        for (int i = 0; i < length.length; i++) {
            kolom++;
        }
        // hitung baris
        int baris = 0;
        while (scanfile.hasNextLine()) {
            baris++;
            scanfile.nextLine();
        }
        baris++;
        scanfile.close();
        double[][] matrix = new double[baris][kolom];
        Scanner scan = new Scanner(file);
        int lineCount=0;
        while (scan.hasNextLine()) {
            String[] currentLine = scan.nextLine().trim().split("\\s+");
            for (int i = 0; i < currentLine.length; i++) {
                matrix[lineCount][i] = Double.parseDouble(currentLine[i]);
            }
            lineCount++;
        }
        return matrix;
    }
}
