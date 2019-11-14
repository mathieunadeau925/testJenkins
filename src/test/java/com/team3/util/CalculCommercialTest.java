/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.util;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rabi MARHOUM
 */
public class CalculCommercialTest {

    public CalculCommercialTest() {
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
     * Test of calculerValeurLot method, of class CalculCommercial.
     */
    @Test
    public void testCalculerValeurLot() {
        System.out.println("calculerValeurLot");
        double superficie = 300.0;
        double prixMax = 4.0;
        double expResult = 1200.0;
        double result = CalculCommercial.calculerValeurLot(superficie, prixMax);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerDroitPassage method, of class CalculCommercial.
     */
    @Test
    public void testCalculerDroitPassage() {
        System.out.println("calculerDroitPassage");
        double nbrDoitPassage = 4.0;
        double valeurLot = 933.0;
        double expResult = -59.8;
        double result = CalculCommercial.calculerDroitPassage(nbrDoitPassage, valeurLot);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculerMontantService method, of class CalculCommercial.
     */
    @Test
    public void testCalculerMontantServiceINF() {
        System.out.println("calculerMontantService");
        double superficie = 400.0;
        int nombre_services = 3;
        double expResult = 1500.0;
        double result = CalculCommercial.calculerMontantService(superficie, nombre_services);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerMontantService method, of class CalculCommercial.
     */
    @Test
    public void testCalculerMontantServiceSUP() {
        System.out.println("calculerMontantService");
        double superficie = 600.0;
        int nombre_services = 3;
        double expResult = 4500.0;
        double result = CalculCommercial.calculerMontantService(superficie, nombre_services);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculerMontantService method, of class CalculCommercial.
     */
    @Test
    public void testCalculerMontantServiceMAX() {
        System.out.println("calculerMontantService");
        double superficie = 400.0;
        int nombre_services = 5;
        double expResult = 2500.0;
        double result = CalculCommercial.calculerMontantService(superficie, nombre_services);
        assertEquals(expResult, result, 0.0);
    }
}
