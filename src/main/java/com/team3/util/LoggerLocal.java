package com.team3.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class LoggerLocal {

    public static void logErreur(Exception erreur) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("ressources/logErreurs.log", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            String msgErreur = "Exception in the code. \n" + Arrays.toString(erreur.getStackTrace()) + "\n";
            out.println(msgErreur);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

