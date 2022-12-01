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
    //String user;
    //String password;
    VentanaServidor ventana = new VentanaServidor();

    
    //Users users_ = new Users();
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private String usuari;
    private String password;
    private int id;
    private Servidor servidor;

    //boolean loginReg = false;
    //int index = 0;
    //int indicador = 0;

    public HilosServidor(Socket s, DataInputStream in, DataOutputStream out, String usuari, String password, int id, Servidor servidor, VentanaServidor ventana) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.usuari = usuari;
        this.password = password;
        this.id = id;
        this.servidor = servidor;
        this.ventana = ventana;
    }

   
    @Override
    public void run() {

        ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + ".");
        ventana.imprimirDatos("Ha iniciat la sessió el usuari " + usuari + " amb el password " + password + ".");
                        
        try {

                Boolean salir = false;
                // - - - S E R V E R  T I Q  I S S U E S - - -
                while (!salir) {
                    try {
                        //Recullo la petició codificada que fa el client
                        int resposta = in.readInt();
                        
                        
                        //Descomposar la resposta
                        //String[] missatge = resposta.split(",");
                        // - - - S E R V I D O R  ---
                        switch (resposta) {
                            case 0:
                                salir = true;
                                ventana.imprimirDatos("Ha fet logout el usuari " + usuari + " amb password " + password + "." + " amb ip " + s.getInetAddress() + ".");
                                break;

                            case 1:
                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            default:
                        }
                    } catch (IOException ex) {
                    }
                }
                s.close();
                //Registrar en el logs el llistat de tots els usuaris guardats al map

            } catch (IOException ex) {
                Logger.getLogger(HilosServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
