package com.team3.util;

public class CalculAgricole {

    private static final double MTN_DE_BASE = 500;
    private static final double POURCENTAGE_DROIT_PASSAGE = 0.05;
    private static final double MONTANT_SERVICES = 0;

    public static double calculerValeurLot(double superficie, double prixMin) {
        double resultat = superficie * prixMin;
        resultat = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
        return resultat;
    }

    public static double calculerMontantDroitsPassage(int nombre_droits_passage, double valeur_par_lot) {
        double montantDroits = MTN_DE_BASE - (nombre_droits_passage * 
                (POURCENTAGE_DROIT_PASSAGE * valeur_par_lot));
        montantDroits = UtilCalcul.arrondisseurMultiple5Superieur(montantDroits);
        return montantDroits;
    }

    public static double calculerMontantServices() {
        return MONTANT_SERVICES;
    }

}
