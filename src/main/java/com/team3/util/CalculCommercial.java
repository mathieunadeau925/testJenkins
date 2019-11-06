package com.team3.util;

/**
 * LES VALEURS NE SONT PAS VALIDES.
 * SEULEMENT POUR DES TESTS!!
 * @author mathi
 */
public class CalculCommercial {

    private static final double MTN_DE_BASE = 500;
    private static final double POURCENTAGE_DROIT_PASSAGE = 0.05;
    private static final double MONTANT_SERVICES = 0;

    public static double calculerValeurLot(double superficie, double prixMin) {
        double resultat = superficie * prixMin;
        return resultat;
    }

    public static double calculerDroitPassage(double nbrDoitPassage, double valeurLot) {
        double droitPassage = MTN_DE_BASE - (nbrDoitPassage * (POURCENTAGE_DROIT_PASSAGE * valeurLot));
        return droitPassage;
    }

    public static double calculerMontantService() {
        return MONTANT_SERVICES;
    }
}
