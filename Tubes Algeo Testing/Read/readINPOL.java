package com.func;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class readINPOL {
    public static void main(String[] args) throws FileNotFoundException {
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
        // tes print
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static double[][] inputkey() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] matrix = new double[n+1][2];
        for (int i=0;i<=n;i++) {
            for (int j=0;j<2;j++) {
                if (j==0) {
                    System.out.println("Masukkan X"+i+":");
                }
                else {
                    System.out.println("Masukkan Y"+i+":");
                }
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }

    private static double[][] inputfile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Naufal Yahya\\IdeaProjects\\Test\\src\\com\\func\\tesinpol.txt");
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
