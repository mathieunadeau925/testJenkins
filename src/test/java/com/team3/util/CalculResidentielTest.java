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
 * @author aziz
 */
public class CalculResidentielTest {
    
    public CalculResidentielTest() {
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
     * Test of calculerValeurLot method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerValeurLot() {
        System.out.println("calculerValeurLot");
        double superficie = 300.0;
        double prixMin = 2.8;
        double prixMax = 3.42;
        double expResult = 933.0;
        double result = CalculResidentiel.calculerValeurLot(superficie, prixMin, prixMax);
        assertEquals("montant error",expResult, result, 0.0);
    }

    /**
     * Test of calculerDroitPassage method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerDroitPassage() {
        System.out.println("calculerDroitPassage");
        double nombre_droits_passage = 4.0;
        double valeur_par_lot = 933.0;
        double expResult = 126.8;
        double result = CalculResidentiel.calculerDroitPassage(nombre_droits_passage, valeur_par_lot);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerMontantService method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerMontantService() {
        System.out.println("calculerMontantService");
        double superficie = 11000.0;
        int nombre_services = 2;
        double expResult = 2000.0;
        double result = CalculResidentiel.calculerMontantService(superficie, nombre_services);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerPrixMoyenne method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerPrixMoyenne() {
        System.out.println("calculerPrixMoyenne");
        double prixMin = 2.8;
        double prixMax = 3.42;
        double expResult = 3.11;
        double result = CalculResidentiel.calculerPrixMoyenne(prixMin, prixMax);
        assertEquals(expResult, result, 0.0);
    }
    
}
