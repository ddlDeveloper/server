/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class HilosServidor extends Thread {

    private boolean comprovacio = false;
    private Socket s = null;
    String user;
    String password;
    VentanaServidor ventana = new VentanaServidor();
    Users users_ = new Users();

    public HilosServidor(Socket s, String user, String password, VentanaServidor ventana, Users users_) {
        this.s = s;
        this.user = user;
        this.password = password;
        this.ventana = ventana;
        this.users_ = users_;
    }

    @Override
    public void run() {
        
        while (!comprovacio) {
            try {
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                int i;
                for (i = 0; i < users_.getUsers().size(); i++) {
                    if (users_.getUsers().get(i).equals(user)) {
                        if (users_.getPasswords().get(i).equals(password)) {
                            out.writeBoolean(true);
                            ventana.imprimirDatos("Ha accedit el usuari " + users_.getUsers().get(i) + " amb ip " + s.getInetAddress() + users_.getPasswords().get(i) + " ");
                            comprovacio = in.readBoolean();
                        }
                    }

                }
                if (comprovacio) {
                    ventana.imprimirDatos("Ha fet logout el usuari " + users_.getUsers().get(i) + " amb ip " + s.getInetAddress() + " password " + users_.getPasswords().get(i) + " ");
                    comprovacio = false;
                    s.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(HilosServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
