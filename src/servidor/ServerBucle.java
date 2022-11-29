/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.Servidor;

/**
 *
 * @author david
 */
public class ServerBucle extends Thread {

        @Override
        public void run() {

            try {
                //Obrim el servidor
                Servidor servidor = new Servidor(8000);
                servidor.obrirServer();
            } catch (IOException | SQLException ex) {
                Logger.getLogger(ServidorMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
