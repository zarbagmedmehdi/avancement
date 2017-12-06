/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.ClasseService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class classeServiceTest {
    
    public classeServiceTest() {
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
     * Test of creerClasse method, of class classeService.
//     */
//    @Test
//    public void testCreerClasse() {
//        System.out.println("creerClasse");
//        String nom = "";
//        double coef = 0.0;
//        classeService instance = new classeService();
//        int expResult = 0;
//        int result = instance.creerClasse(nom, coef);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of initDb method, of class classeService.
     */
    @Test
    public void testInitDb() {
        System.out.println("initDb");
        ClasseService instance = new ClasseService();
        instance.initDb();
        
    }
    
}
