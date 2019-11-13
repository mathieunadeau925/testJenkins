package com.team3.main;

import com.team3.util.FileReader;
import com.team3.util.FileWriter;
import com.team3.util.LoggerLocal;
import com.team3.util.UtilJson;
import java.io.IOException;

public class AppCtr {
    
    public static void main(String[] args) throws IOException { 
        String fichierEntree = FileReader.loadFileIntoString(args[0], "UTF-8");
        String fichierSortie = args[1].toString();
        try {
            UtilJson.traiterFichierJson(fichierEntree, fichierSortie);
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
        }
    }
}
