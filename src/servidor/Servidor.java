/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Servidor {

    public static void main(String[] args) {
        // TODO code application logic here

        Users users_ = new Users();
        users_.addUser("lluis", "daniel");

        try {

            VentanaServidor ventana = new VentanaServidor();
            ventana.setVisible(true);
            ServerSocket server = new ServerSocket(8000);
            Socket s;
            boolean loginReg = false;

            ventana.imprimirDatos("Inici correcte");
            while (true) {

                s = server.accept();

                ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + " ");

                DataInputStream in = new DataInputStream(s.getInputStream());
                //DataOutputStream out = new DataOutputStream(s.getOutputStream());

                while (!loginReg) {
                    String user = in.readUTF();
                    String password = in.readUTF();
                    loginReg = in.readBoolean();
                    Boolean reg = false;

                    if (!loginReg) {
                        reg = in.readBoolean();

                        if (reg) {

                            user = in.readUTF();
                            password = in.readUTF();
                            users_.addUser(user, password);
                            ventana.imprimirDatos("La ip " + s.getInetAddress() + " ha creat el nom dusuari "
                                    + user + " amb el password " + password);
                            loginReg = false;
                        }

                    } else {

                        ventana.imprimirDatos("La ip " + s.getInetAddress() + " ha intentat entrar amb el nom dusuari "
                                + user + " amb el password " + password);

                        HilosServidor hilo = new HilosServidor(s, user, password, ventana, users_);
                        hilo.start();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
