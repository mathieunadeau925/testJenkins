package com.team3.main;

import com.team3.util.LoggerLocal;
import com.team3.util.UtilJson;

public class AppCtr {
    
    public static void main(String[] args) {
        String fichierEntree = "ressources/terrain1.json";
        String fichierSortie = "ressources/resultat.json";
        try {
            UtilJson.traiterFichierJson(fichierEntree, fichierSortie);
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
        }
    }
}
