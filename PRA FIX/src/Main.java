import Determinan.Detkof;
import Determinan.Detobe;
import Input.readDETINV;
import Input.readINPOL;
import Input.readREGLIN;
import Input.readSPL;
import Interpolasi.Inpol;
import Invers.Inobe;
import Invers.InverseKof;
import Output.writeDET;
import Regresi.REGLIN;
import SPL.Balikan;
import SPL.Crammer;
import SPL.Gauss;
import SPL.GaussJ;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Balikan SPLinverse = new Balikan();
        Crammer SPLcrammer = new Crammer();
        Detkof DETkof = new Detkof();
        Detobe DETOBE = new Detobe();
        Gauss gauss = new Gauss();
        GaussJ gaussj = new GaussJ();
        Inobe INVOBE = new Inobe();
        InverseKof INVkof = new InverseKof();
        Inpol Inpol = new Inpol();
        REGLIN Reglin = new REGLIN();
        readSPL SPLR = new readSPL();
        readDETINV DETINVR = new readDETINV();
        readINPOL INPOLR = new readINPOL();
        readREGLIN REGLINR = new readREGLIN();
        writeDET DETW = new writeDET();
        boolean isrunning = true;
        while (isrunning) {
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linear");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi Linear Berganda");
            System.out.println("6. Keluar");
            Scanner menu = new Scanner(System.in);
            int pilmenu = menu.nextInt();
            switch (pilmenu) {
                case 1:
                    System.out.println("1. Metode Eliminasi Gauss");
                    System.out.println("2. Metode Eliminasi Gauss-Jordan");
                    System.out.println("3. Metode Matriks Balikan");
                    System.out.println("4. Kaidah Cramer");
                    int submenu1 = menu.nextInt();
                    switch (submenu1) {
                        case 1:
                            gauss.main();
                            break;
                        case 2:
                            gaussj.main();
                            break;
                        case 3:
                            SPLinverse.main();
                            break;
                        case 4:
                            SPLcrammer.main();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Kofaktor");
                    System.out.println("2. Matriks Segitiga, OBE");
                    int submenu2 = menu.nextInt();
                    switch (submenu2) {
                        case 1:
                            double[][] matrixDK;
                            matrixDK = DETINVR.main();
                            double dkof = DETkof.determinan(matrixDK);
                            DETW.write(dkof,"Hasil Determinan Matriks Kofaktor.txt");
                            break;
                        case 2:
                            double[][] matrixDO;
                            matrixDO = DETINVR.main();
                            double dobe = DETOBE.determinan(matrixDO);
                            DETW.write(dobe,"Hasil Determinan Matriks OBE.txt");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Adjoin");
                    System.out.println("2. Identitas dan OBE");
                    int submenu3 = menu.nextInt();
                    switch (submenu3) {
                        case 1:
                            double[][] matrixIK;
                            matrixIK = DETINVR.main();
                            INVkof.InKof(matrixIK);
                            break;
                        case 2:
                            double[][] matrixIO;
                            matrixIO = DETINVR.main();
                            INVOBE.main(matrixIO,matrixIO.length);
                            break;
                    }
                    break;
                case 4:
                    Inpol.main();
                    break;
                case 5:
                    Reglin.main();
                    break;
                case 6:
                    isrunning = false;
            }
        }
    }
}
