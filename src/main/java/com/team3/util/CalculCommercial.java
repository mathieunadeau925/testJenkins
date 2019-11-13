package com.team3.util;

public class CalculCommercial {

    private static double montantServices = 0;
    private static final double MNT_DE_BASE = 500,
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
        double droitPassage = MNT_DE_BASE - (nbrDoitPassage * (POURCENTAGE_DROIT_PASSAGE * valeurLot));
        droitPassage = UtilCalcul.arrondisseurMultiple5Superieur(droitPassage);
        return droitPassage;
    }

    public static double calculerMontantService(double superficie, int nombre_services) {
        if (superficie <= SUPERFICIE_MIN) {
            montantServices = MONTANT_SERVICE_COM1 * nombre_services;
        } else {
            montantServices = MONTANT_SERVICE_COM2 * nombre_services;
        }
        if (montantServices >= MONTANT_SERVICES_COM3) {
            montantServices = MONTANT_SERVICES_COM3;
        }
        montantServices = UtilCalcul.arrondisseurMultiple5Superieur(montantServices);
        return montantServices;
    }
}
