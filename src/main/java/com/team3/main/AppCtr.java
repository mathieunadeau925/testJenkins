package com.team3.main;

import com.team3.util.LoggerLocal;
import com.team3.util.UtilJson;
public class AppCtr {

    public static void main(String[] args) {
        try {
            String fichierEntree = args[0];
            String fichierSortie = args[1];
            UtilJson.traiterFichierJson(fichierEntree, fichierSortie);
            System.out.println("Traitement réussi. voir votre fichier " + fichierSortie + " pour les résultats.");
        } catch (Exception e) {
            LoggerLocal.logErreur(e);
            System.out.println("Erreur dans vos fichiers json!");
        }
    }
}
