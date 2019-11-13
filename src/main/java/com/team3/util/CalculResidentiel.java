package com.team3.util;

/**
 * LES VALEURS NE SONT PAS VALIDES.
 * SEULEMENT POUR DES TESTS!!
 * @author mathi
 */
public class CalculResidentiel {

    private static final double MTN_DE_BASE = 500;
    private static final double POURCENTAGE_DROIT_PASSAGE = 0.10;
    private static double montantServices = 0 ;
    private static final double MTN_SER_5 =500, MTN_SER_1 =1000,
            SUPERFICIE_MAX=10000,SUPERFICIE_MIN=500;

    public static double calculerValeurLot(double superficie, double prixMin , double prixMax) {
        double resultat = superficie * calculerPrixMoyenne(prixMin, prixMax);
        resultat = UtilCalcul.arrondisseurMultiple5Superieur(resultat);
        return resultat;
    }

    public static double calculerDroitPassage(double nombre_droits_passage, double valeur_par_lot) {
         double montantDroits = MTN_DE_BASE - (nombre_droits_passage * 
                (POURCENTAGE_DROIT_PASSAGE * valeur_par_lot));
        montantDroits = UtilCalcul.arrondisseurMultiple5Superieur(montantDroits);
        return montantDroits;
    }

    public static double calculerMontantService(double superficie ,int nombre_services) {
        if (superficie <= SUPERFICIE_MIN) {
             montantServices = MTN_DE_BASE ;
        }else if (superficie <= SUPERFICIE_MAX){
             montantServices = MTN_SER_5 * nombre_services;
        }else{ 
             montantServices= MTN_SER_1 * nombre_services;
        }
          //montantServices = UtilCalcul.arrondisseurMultiple5Superieur(montantServices);
          
          return montantServices ;
    }
    public static double calculerPrixMoyenne (double prixMin ,double prixMax){
        return (prixMax+prixMin)/2 ;
           
        }
}
