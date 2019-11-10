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
        double superficie = 700.79;
        double prixMin = 13.97;
        double expResult = 2193.0;
        double result = CalculResidentiel.calculerValeurLot(superficie, prixMin);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerDroitPassage method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerDroitPassage() {
        System.out.println("calculerDroitPassage");
        double nombre_droits_passage = 3;
        double valeur_par_lot = 700.0;
        double expResult = 250.0;
        double result = CalculResidentiel.calculerDroitPassage(nombre_droits_passage, valeur_par_lot);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerMontantService method, of class CalculResidentiel.
     */
    @Test
    public void testCalculerMontantService() {
        System.out.println("calculerMontantService");
        double MONTANT_SERVICES = 0.0;
        int nombre_services = 3;
        double expResult = 400.0;
        double result = CalculResidentiel.calculerMontantService(MONTANT_SERVICES, nombre_services);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
