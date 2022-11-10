/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Servidor extends Thread {

    static Users users_ = new Users();

    static Socket s;
    boolean comprovacio = false;
    static VentanaServidor ventana = new VentanaServidor();

    DataInputStream in = null;
    DataOutputStream out = null;
    String password;
    boolean loginReg = false;

    public static void main(String[] args) {
        // TODO code application logic here

        try {

            users_.addUser("lluis", "daniel");
            ventana.setVisible(true);
            ServerSocket server = new ServerSocket(8000);

            ventana.imprimirDatos("Inici correcte");
            while (true) {

                s = server.accept();
                Servidor servidor = new Servidor();
                servidor.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + " ");

        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("Connectat");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (!loginReg) {
            String user = "";
            try {
                user = in.readUTF();
                password = in.readUTF();
                loginReg = in.readBoolean();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            Boolean reg = false;

            if (!loginReg) {
                try {
                    reg = in.readBoolean();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (reg) {

                    try {
                        user = in.readUTF();
                        password = in.readUTF();
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    users_.addUser(user, password);
                    ventana.imprimirDatos("La ip " + s.getInetAddress() + " ha creat el nom dusuari "
                            + user + " amb el password " + password);
                    loginReg = false;
                }

            } else {

                ventana.imprimirDatos("La ip " + s.getInetAddress() + " ha intentat entrar amb el nom dusuari "
                        + user + " amb el password " + password);

                //HilosServidor hilo = new HilosServidor(s, user, password, ventana, users_);
                //hilo.start();
                //hilo.join();
                while (!comprovacio) {
                    try {

                        //DataInputStream in = new DataInputStream(s.getInputStream());
                        //DataOutputStream out = new DataOutputStream(s.getOutputStream());
                        int i;
                        for (i = 0; i < users_.getUsers().size(); i++) {
                            if (users_.getUsers().get(i).equals(user)) {
                                if (users_.getPasswords().get(i).equals(password)) {
                                    out.writeInt(1);
                                    ventana.imprimirDatos("Ha accedit el usuari " + users_.getUsers().get(i) + " amb ip " + s.getInetAddress() + " password " + users_.getPasswords().get(i) + " ");
                                    comprovacio = in.readBoolean();
                                }
                            } else {
                                out.writeInt(0);
                            }

                        }
                        if (comprovacio) {
                            ventana.imprimirDatos("Ha fet logout el usuari " + users_.getUsers().get(i) + " amb ip " + s.getInetAddress() + " password " + users_.getPasswords().get(i) + " ");
                            comprovacio = false;
                            in.close();
                            out.close();
                            s.close();
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(HilosServidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        try {
            in.close();
            out.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
