package com.team3.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilCalculTest {

    public UtilCalculTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Les nombres négatifs doivent retourner 0.
     */
    @Test
    public void arrondisseurMultiple5SuperieurNombreNegatif() {
        double nombre = -5;
        double resultat = UtilCalcul.arrondisseurMultiple5Superieur(nombre);

        assertTrue("Résultat attendu :" + 0 + "\nRésultat obtenu: " + resultat, (resultat == 0));
    }
    
        @Test
    public void arrondisseurMultiple5SuperieurNombreZero() {
        double nombre = 0;
        double resultat = UtilCalcul.arrondisseurMultiple5Superieur(nombre);

        assertTrue("Résultat attendu :" + 0 + "\nRésultat obtenu: " + resultat, (resultat == 0));
    }

    @Test
    public void arrondisseurMultiple5SuperieurNombrePositif() {
        double nombre = 1544.33;
        double resultat = UtilCalcul.arrondisseurMultiple5Superieur(nombre);

        assertTrue("Résultat attendu :" + 1544.35 + "\nRésultat obtenu: " + resultat, (resultat == 1544.35));
    }

    @Test
    public void arrondisseurMultiple5SuperieurNombrePositif2() {
        double nombre = 45.54678756;
        double resultat = UtilCalcul.arrondisseurMultiple5Superieur(nombre);

        assertTrue("Résultat attendu :" + 45.55 + "\nRésultat obtenu: " + resultat, (resultat == 45.55));
    }
    
        @Test
    public void arrondisseurMultiple5SuperieurNombrePositif3() {
        double nombre = 36.413;
        double resultat = UtilCalcul.arrondisseurMultiple5Superieur(nombre);

        assertTrue("Résultat attendu :" +36.45 + "\nRésultat obtenu: " + resultat, (resultat == 36.45));
    }
}
