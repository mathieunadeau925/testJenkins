package com.team3.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculAgricoleTest {
    
    public CalculAgricoleTest() {
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
     * Test of calculerValeurLot method, of class CalculAgricole.
     */
    @Test
    public void testCalculerValeurLot() {
        double superficie = 456.0;
        double prixMin = 4.32;
        double expResult = 1969.95;
        double result = CalculAgricole.calculerValeurLot(superficie, prixMin);
        assertEquals("Montant pour la Valeur du Lot n'était pas correct.", expResult, result, 0);
    }

    /**
     * Test of calculerDroitPassage method, of class CalculAgricole.
     */
    @Test
    public void testCalculerDroitPassage() {
        int nbrDoitPassage = 3;
        double valeurLot = 1000;
        double expResult = 350;
        double result = CalculAgricole.calculerMontantDroitsPassage(nbrDoitPassage, valeurLot);
        assertEquals("Montant pour las droits du passage n'était pas correct.", expResult, result, 0);

    }

    /**
     * Test of calculerMontantService method, of class CalculAgricole.
     */
    @Test
    public void testCalculerMontantService() {
        double expResult = 0.0;
        double result = CalculAgricole.calculerMontantServices();
        assertEquals("Montant pour las droits du passage n'était pas correct.", expResult, result, 0);
    }
    
}
