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
    private String nomClient;
    private int id;
    private Servidor servidor;

    //boolean loginReg = false;
    //int index = 0;
    //int indicador = 0;

    public HilosServidor(Socket s, DataInputStream in, DataOutputStream out, String nomClient, int id, Servidor servidor, VentanaServidor ventana) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.nomClient = nomClient;
        this.id = id;
        this.servidor = servidor;
        this.ventana = ventana;
    }

   
    @Override
    public void run() {

        ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + " ");
        try {

                Boolean salir = false;
                // - - - S E R V E R  T I Q  I S S U E S - - -
                while (!salir) {
                    try {
                        //Recullo la petició codificada que fa el client
                        String resposta = in.readUTF();
                        //Descomposar la resposta
                        String[] missatge = resposta.split(",");
                        // - - - S E R V I D O R  ---
                        switch (missatge[0]) {
                            case "0":
                                salir = true;
                                break;

                            case "1":
                                break;

                            case "2":
                                break;

                            case "EXIT":
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
