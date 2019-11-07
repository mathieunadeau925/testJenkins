package com.team3.util;

/**
 * Classe utilitaire pour effectuer des arrondissements et calculs
 * mathématiques.
 *
 * @author mathieu nadeau
 */
public class UtilCalcul {

    /**
     * fonction qui arrondie un nombre au 5 sous supérieur. Ne prend que des nombres positifs.
     * @param nombre est le nombre a arrondir au 5 sous supérieur
     * @return nombre arrondi au 5 sous supérieur.
     */
    public static double arrondisseurMultiple5Superieur(double nombre) {
        nombre = Math.round(nombre * 100);
        nombre = 5 * (Math.ceil(nombre / 5));
        nombre = nombre / 100;
        return nombre;
    }
}
