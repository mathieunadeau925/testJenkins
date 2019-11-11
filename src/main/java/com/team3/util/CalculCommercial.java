package com.team3.util;

/**
 * LES VALEURS NE SONT PAS VALIDES. SEULEMENT POUR DES TESTS!!
 *
 * @author mathi
 */
public class CalculCommercial {

    private static double MONTANT_SERVICES = 0;
    private static final double MTN_DE_BASE = 500,
            POURCENTAGE_DROIT_PASSAGE = 0.15,
            SUPERFICIE_MIN = 500,
            MONTANT_SERVICE_COM1 = 500,
            MONTANT_SERVICE_COM2 = 1500,
            MONTANT_SERVICES_COM3 = 5000;

    public static double calculerValeurLot(double superficie, double prixMax) {
        double ValeurLot = superficie * prixMax;
        ValeurLot = UtilCalcul.arrondisseurMultiple5Superieur(ValeurLot);
        return ValeurLot;
    }

    public static double calculerDroitPassage(double nbrDoitPassage, double valeurLot) {
        double droitPassage = MTN_DE_BASE - (nbrDoitPassage * (POURCENTAGE_DROIT_PASSAGE * valeurLot));
        droitPassage = UtilCalcul.arrondisseurMultiple5Superieur(droitPassage);
        return droitPassage;
    }

    public static double calculerMontantService(double superficie, int nombre_services) {
        if (superficie <= SUPERFICIE_MIN) {
            MONTANT_SERVICES = MONTANT_SERVICE_COM1 * nombre_services;
        } else {
            MONTANT_SERVICES = MONTANT_SERVICE_COM2 * nombre_services;
        }
        if (MONTANT_SERVICES >= MONTANT_SERVICES_COM3) {
            MONTANT_SERVICES = MONTANT_SERVICES_COM3;
        }
        return MONTANT_SERVICES;
    }
}
