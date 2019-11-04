/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.util;

import com.sun.org.apache.bcel.internal.Constants;
import java.text.DecimalFormat;

/**
 *
 * @author radouaneboutiri
 */
public class Agricole {
    
    private static final double MTN_DE_BASE = 500;
    private static final double POURCENTAGE_DROIT_PASSAGE = 0.05;
    private static final double MONTANT_SERVICES = 0;
    private static DecimalFormat df = new DecimalFormat("#.##"); 

    
    public static double calculerValeurLot(double superficier, double prixMin){  
        double resultat = Double.parseDouble(df.format(superficier * prixMin));
        return resultat;
    }
    
    public static double calculerDroitPassage(double nbrDoitPassage, double valeurLot){ 
        double droitPassage = MTN_DE_BASE - (nbrDoitPassage * (POURCENTAGE_DROIT_PASSAGE * valeurLot));
        return Double.parseDouble(df.format(droitPassage));
    }
    
    public static double calculerMontantService(){ 
        return Double.parseDouble(df.format(MONTANT_SERVICES));
    }
    
    
}
