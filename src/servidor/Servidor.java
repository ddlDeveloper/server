/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import ConBaseDades.MetodesSQL;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Servidor extends Thread {

    static Socket s;
    int comprovacio = 0;
    static VentanaServidor ventana = new VentanaServidor();
    static Users users;
    static MetodesSQL metodes;

    DataInputStream in = null;
    DataOutputStream out = null;
    String password;
    boolean loginReg = false;
    static int index = 0;
    int indicador = 0;

    public static void main(String[] args) {
        // TODO code application logic here

        try {

            //users_.addUser("lluis", "daniel");
            //users_.addUser("david", "miro");
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

        if (!loginReg) {
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
                    out.writeUTF("Preparat per a desar dades");
                    reg = in.readBoolean();
                    out.writeBoolean(reg);
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (reg) {

                    try {
                        //ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                        //boolean activacio = in.readBoolean();
                        //out.writeBoolean(activacio);
                        String user_ = in.readUTF();
                        String password_ = in.readUTF();
                        String nom = in.readUTF();
                        String cognom = in.readUTF();
                        String correu = in.readUTF();
                        String DNI = in.readUTF();
                        String tarjetaBancaria = in.readUTF();
                        String carrer = in.readUTF();
                        String municipi = in.readUTF();
                        String provincia = in.readUTF();
                        String nacionalitat = in.readUTF();
                        String IBAN = in.readUTF();
                        String Telefon = in.readUTF();
                        String codiPostal = in.readUTF();
                        metodes.createrUser(user_, password_, nom, cognom, correu, DNI, tarjetaBancaria, carrer, municipi, provincia, nacionalitat, IBAN, Telefon, codiPostal);
                        out.writeUTF("Registre correcte");
                        //user = in.readUTF();
                        //password = in.readUTF();
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                while (comprovacio == 0) {
                    try {

                        //DataInputStream in = new DataInputStream(s.getInputStream());
                        //DataOutputStream out = new DataOutputStream(s.getOutputStream());
                        //int i;
                        //for (i = 0; i < users_.getUsers().size(); i++) {
                        //if (users_.getUsers().get(i).equals(user)) {
                        //if (users_.getPasswords().get(i).equals(password)) {
                        MetodesSQL.searchUserRegistered(user, password); 

                            index = index + 1;
                            indicador = index;
                            out.writeInt(index);
                            ventana.imprimirDatos("Ha accedit el usuari " + user + " amb ip " + s.getInetAddress() + " password " + user + " ");
                            out.writeUTF("Ha accedit el usuari " + user + " amb ip " + s.getInetAddress() + " password " + user + " ");
                            String text = in.readUTF();
                            ventana.imprimirDatos(text);
                            String text2 = in.readUTF();
                            ventana.imprimirDatos(text2);
                            comprovacio = in.readInt();
                            switch (comprovacio) {
                                case 1 -> {
                                    comprovacio = 0;
                                    ventana.imprimirDatos("Ha fet logout el usuari " + user + " amb ip " + s.getInetAddress() + " password " + " ");

                                    break;
                                }
                                case 2 -> {
                                }
                                
                                default -> {
                                }
                            }
                            
                            in.close();
                            out.close();
                            s.close();
                        

                        if (indicador == 0) {
                            out.writeInt(indicador);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
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
