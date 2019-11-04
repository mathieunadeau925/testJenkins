/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author radouaneboutiri
 */
public class AgricoleTest {
    
    public AgricoleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculerValeurLot method, of class Agricole.
     */
    @Test
    public void testCalculerValeurLot() {
        System.out.println("calculerValeurLot");
        double superficier = 456.0;
        double prixMin = 4.32;
        double expResult = 1969.92;
        double result = Agricole.calculerValeurLot(superficier, prixMin);
        assertEquals("Montant pour la Valeur du Lot n'était pas correct.", expResult, result, 0);
    }

    /**
     * Test of calculerDroitPassage method, of class Agricole.
     */
    @Test
    public void testCalculerDroitPassage() {
        System.out.println("calculerDroitPassage");
        double nbrDoitPassage = 3;
        double valeurLot = 1000;
        double expResult = 350;
        double result = Agricole.calculerDroitPassage(nbrDoitPassage, valeurLot);
        assertEquals("Montant pour las droits du passage n'était pas correct.", expResult, result, 0);

    }

    /**
     * Test of calculerMontantService method, of class Agricole.
     */
    @Test
    public void testCalculerMontantService() {
        System.out.println("calculerMontantService");
        double expResult = 0.0;
        double result = Agricole.calculerMontantService();
        assertEquals("Montant pour las droits du passage n'était pas correct.", expResult, result, 0);
    }
    
}
