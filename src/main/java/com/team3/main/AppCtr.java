package com.team3.main;

import com.team3.util.FileReader;
import com.team3.util.LoggerLocal;
import com.team3.util.UtilJson;
public class AppCtr {

    public static void main(String[] args) {
        try {
            String fichierEntree = FileReader.loadFileIntoString(args[0], "UTF-8");
            String fichierSortie = args[1].toString();
            UtilJson.traiterFichierJson(fichierEntree, fichierSortie);
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
            System.out.println("Erreur dans vos fichiers json!");
        }
    }
}
