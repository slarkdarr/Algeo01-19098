package src;

import java.util.Scanner;

public class Regresi {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan banyaknya data: ");
        int n = scan.nextInt();
        double[] ab = regresiLinier(n);
        printResult(ab);
        scan.close();
    }

    public static double[] regresiLinier(int n)
    {
        double sumX = 0, sumX2 = 0, sumY = 0, sumXY = 0;

        Scanner scan1 = new Scanner(System.in);
        int[] x = new int[10];
        int[] y = new int[10];

        for (int i = 0; i < n; i++)
        {
            System.out.println("x[" + i + "] = ");
            x[i] = scan1.nextInt();

            System.out.println("y[" + i + "] = ");
            y[i] = scan1.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            sumX += x[i];
            sumX2 += x[i]*x[i];
            sumY += y[i];
            sumXY += x[i]*y[i];
        }

        double b = (n * sumXY - sumXY * sumY)/(n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;
        
        double[] temp = new double[2];
        temp[0] = a;
        temp[1] = b;
        return temp;

        scan1.close();
    }

    private static void printResult(double[] ab)
    {
        System.out.println("Nilai dari a = " + ab[0] + " dan b = " + ab[1]);
        System.out.println("Persamaan yang memenuhi adalah : y = a " + ab[0] + " + " + ab[1] + "x");
    }
}
