/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class ServidorMain {

    /**
     * @param args the command line arguments
     */
    //private VentanaServidor ventana = new VentanaServidor();
    

    public static void main(String[] args) {
        // TODO code application logic here
       
            ServerBucle server = new ServerBucle();
              
            server.start();
        

    }
}

    
