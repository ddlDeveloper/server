/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ConBaseDades;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class ConnexioIT {
    
    public ConnexioIT() {
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
     * Test of loginValit method, of class Connexio.
     */
    @Test
    public void testLoginValit() throws Exception {
        System.out.println("loginValit");
        String usuari = "1";
        String contrasenya = "1";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.loginValit(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testLoginNoValit() throws Exception {
        System.out.println("loginValit");
        String usuari = "78";
        String contrasenya = "78";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.loginValit(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    
    @Test
    public void testLoginBuit() throws Exception {
        System.out.println("loginValit");
        String usuari = "";
        String contrasenya = "";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.loginValit(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    
    
    /**
     * Test of clientValit method, of class Connexio.
     */
    @Test
    public void testClientValit() throws Exception {
        System.out.println("clientValit");
        String num_document = "5";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.clientValit(num_document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testClientNoValit() throws Exception {
        System.out.println("clientValit");
        String num_document = "3";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.clientValit(num_document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testClientBuit() throws Exception {
        System.out.println("clientValit");
        String num_document = "";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.clientValit(num_document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    
    /**
     * Test of reservaValida method, of class Connexio.
     */
    @Test
    public void testReservaValida() throws Exception {
        System.out.println("reservaValida");
        String numDoc = "8";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.reservaValida(numDoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testReservaNoValida() throws Exception {
        System.out.println("reservaValida");
        String numDoc = "222";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.reservaValida(numDoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testReservaBuida() throws Exception {
        System.out.println("reservaValida");
        String numDoc = "";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.reservaValida(numDoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    

    /**
     * Test of rolUsuari method, of class Connexio.
     */
    @Test
    public void testRolUsuari() throws Exception {
        System.out.println("rolUsuari");
        String usuari = "1";
        String contrasenya = "1";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.rolUsuari(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testNoRolUsuari() throws Exception {
        System.out.println("rolUsuari");
        String usuari = "45";
        String contrasenya = "45";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.rolUsuari(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    
    @Test
    public void testRolBuit() throws Exception {
        System.out.println("rolUsuari");
        String usuari = "";
        String contrasenya = "";
        Connexio instance = new Connexio();
        int expResult = 0;
        instance.establirConnexio();
        int result = instance.rolUsuari(usuari, contrasenya);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
    

    /**
     * Test of crearUsuari method, of class Connexio.
     */
    @Test
    public void testCrearUsuari() throws Exception {
        System.out.println("crearUsuari");
        String usuari = "1234";
        String password = "1234";
        String nom = "1234";
        String cognom = "1234";
        String correu = "1234";
        String doctype = "1234";
        String numdoc = "1234";
        String carrer = "1234";
        String telefon = "1234";
        String rol = "1234";
        String sex = "1234";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.crearUsuari(usuari, password, nom, cognom, correu, doctype, numdoc, carrer, telefon, rol, sex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of crearUsuariInicial method, of class Connexio.
     */
    @Test
    public void testCrearUsuariInicial() throws Exception {
        System.out.println("crearUsuariInicial");
        String usuari = "1534";
        String password = "1534";
        String rol = "1534";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.crearUsuariInicial(usuari, password, rol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of crearReserva method, of class Connexio.
     */
    @Test
    public void testCrearReserva() throws Exception {
        System.out.println("crearReserva");
        String name = "4321";
        String lastName = "4321";
        String docType = "4321";
        String dni = "4321";
        String address = "4321";
        String phone = "4321";
        String email = "4321";
        String acces = "4321";
        String user = "4321";
        String password = "4321";
        String sex = "4321";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.crearReserva(name, lastName, docType, dni, address, phone, email, acces, user, password, sex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of crearClient method, of class Connexio.
     */
    @Test
    public void testCrearClient() throws Exception {
        System.out.println("crearClient");
        String nacionality = "1212";
        String address = "1212";
        String email = "1212";
        String iban = "1212";
        String lastname = "1212";
        String municipality = "1212";
        String name = "1212";
        String dni = "1212";
        String num_document = "1212";
        String phone = "1212";
        String postalcode = "1212";
        String province = "1212";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.crearClient(nacionality, address, email, iban, lastname, municipality, name, dni, num_document, phone, postalcode, province);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of eliminarUsuari method, of class Connexio.
     */
    @Test
    public void testEliminarUsuari() throws Exception {
        System.out.println("eliminarUsuari");
        String usuari = "3";
        String password = "3";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.eliminarUsuari(usuari, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of eliminarClient method, of class Connexio.
     */
    @Test
    public void testEliminarClient() throws Exception {
        System.out.println("eliminarClient");
        String num_document = "6";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.eliminarClient(num_document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of eliminarReserva method, of class Connexio.
     */
    @Test
    public void testEliminarReserva() throws Exception {
        System.out.println("eliminarReserva");
        String numDoc = "9";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.eliminarReserva(numDoc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of updateUsuari method, of class Connexio.
     */
    @Test
    public void testUpdateUsuari() throws Exception {
        System.out.println("updateUsuari");
        String usuari = "43";
        String password = "43";
        String nom = "21";
        String cognom = "12";
        String correu = "22";
        String dni = "2";
        String tarjetaBancaria = "12";
        String carrer = "31";
        String municipi = "42";
        String provincia = "12";
        String nacionalitat = "31";
        String iban = "12";
        String telefon = "12";
        String codiPostal = "42";
        String rol = "12";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.updateUsuari(usuari, password, nom, cognom, correu, dni, tarjetaBancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codiPostal, rol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of updateClient method, of class Connexio.
     */
    @Test
    public void testUpdateClient() throws Exception {
        System.out.println("updateClient");
        String nacionality = "21";
        String address = "42";
        String email = "12";
        String iban = "12";
        String lastname = "42";
        String municipality = "21";
        String name = "32";
        String dni = "5";
        String num_document = "5";
        String phone = "42";
        String postalcode = "12";
        String province = "42";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.updateClient(nacionality, address, email, iban, lastname, municipality, name, dni, num_document, phone, postalcode, province);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of updateReserva method, of class Connexio.
     */
    @Test
    public void testUpdateReserva() throws Exception {
        System.out.println("updateReserva");
        String name = "23";
        String lastName = "23";
        String docType = "14";
        String dni = "8";
        String address = "52";
        String phone = "32";
        String email = "23";
        String acces = "34";
        String user = "13";
        String password = "13";
        String sex = "53";
        Connexio instance = new Connexio();
        int expResult = 1;
        instance.establirConnexio();
        int result = instance.updateReserva(name, lastName, docType, dni, address, phone, email, acces, user, password, sex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }
    
}
