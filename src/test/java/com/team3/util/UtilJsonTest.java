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
 * @author 1995046
 */
public class UtilJsonTest {

    public UtilJsonTest() {
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

    @Test
    public void formatteurDoubleTestNombreReel() {
        double nombre = 55.45;
        String resultat = UtilJson.formatteurDouble(nombre);
        String resAttendu = "55.45 $";

        assertTrue("Résultat attendu :" + resAttendu + "\nRésultat obtenu: "
                + resultat, (resultat.equals(resAttendu)));
    }

    @Test
    public void formatteurDoubleTestNombreEntier() {
        double nombre = 55;
        String resultat = UtilJson.formatteurDouble(nombre);
        String resAttendu = "55.00 $";

        assertTrue("Résultat attendu :" + resAttendu + "\nRésultat obtenu: "
                + resultat, (resultat.equals(resAttendu)));
    }

    @Test
    public void formatteurDoubleTestNombreZero() {
        double nombre = 0;
        String resultat = UtilJson.formatteurDouble(nombre);
        String resAttendu = "0.00 $";

        assertTrue("Résultat attendu :" + resAttendu + "\nRésultat obtenu: "
                + resultat, (resultat.equals(resAttendu)));
    }

}
