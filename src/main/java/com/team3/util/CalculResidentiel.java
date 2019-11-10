package com.team3.util;

/**
 * LES VALEURS NE SONT PAS VALIDES.
 * SEULEMENT POUR DES TESTS!!
 * @author mathi
 */
public class CalculResidentiel {

    private static final double MTN_DE_BASE = 500;
    private static final double POURCENTAGE_DROIT_PASSAGE = 0.10;
    private static final double MONTANT_SERVICES = 0 ,mtn_ser_500 =500,
                                mtn_ser_1000 =1000;

    public static double calculerValeurLot(double superficie, double prixMin) {
        double resultat = superficie * prixMin;
        resultat = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
        return resultat;
    }

    public static double calculerDroitPassage(double nombre_droits_passage, double valeur_par_lot) {
         double montantDroits = MTN_DE_BASE - (nombre_droits_passage * 
                (POURCENTAGE_DROIT_PASSAGE * valeur_par_lot));
        montantDroits = UtilCalcul.arrondisseurMultiple5Superieur(montantDroits);
        return montantDroits;
    }

    public static double calculerMontantService(double MONTANT_SERVICES ,int nombre_services) {
        if (MONTANT_SERVICES <= 500) {
            return MONTANT_SERVICES ;
        }else if (MONTANT_SERVICES <= 1000){
            
            return MONTANT_SERVICES = mtn_ser_500 * nombre_services;
        }else{ 
            return MONTANT_SERVICES= mtn_ser_1000 * nombre_services;
        }
        
    }
}
