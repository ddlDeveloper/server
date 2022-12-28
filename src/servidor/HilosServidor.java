/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import ConBaseDades.Connexio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
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
    private Connexio connexio;

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

            while (!salir) {
                try {
                    //Recullo la petició codificada que fa el client
                    int resposta = in.readInt();
                    int delad;
                    int delete;
                    int update;
                    int alta;

                    //Descomposar la resposta
                    //String[] missatge = resposta.split(",");
                    switch (resposta) {
                        case 0:
                            salir = true;
                            ventana.imprimirDatos("Ha fet logout el usuari " + usuari + " amb password " + password + "." + " amb ip " + s.getInetAddress() + ".");
                            break;

                        case 1:
                            int baixa;
                            delad = in.readInt();
                            if (delad == 1) {

                                baixa = servidor.baixaUsuaris(in, out);
                            } else {

                                baixa = 2;
                            }
                            if (baixa == 0) {
                                ventana.imprimirDatos("Sha donat de baixa el usuari " + usuari + " amb password " + password + "." + " amb ip " + s.getInetAddress() + ".");
                            } else if (baixa == 1) {
                                ventana.imprimirDatos("No sha pogut eliminar el usuari " + usuari + " amb password " + password + "." + " amb ip " + s.getInetAddress() + ".");
                            }
                            salir = true;
                            break;

                        case 2:
                            delad = in.readInt();
                        switch (delad) {
                            case 1:
                                alta = servidor.altaClients(in, out);
                                delete = 2;
                                update = 2;
                                break;
                            case 2:
                                delete = servidor.baixaClients(in, out);
                                alta = 2;
                                update = 2;
                                break;
                            case 3:
                                update = servidor.updateClients(in, out); //update
                                alta = 2;
                                delete = 2;
                                break;
                            default:
                                alta = 2;
                                delete = 2;
                                update = 2;
                                break;
                        }
                            if (alta == 0) {
                                ventana.imprimirDatos("Sha donat de alta el client corresponent");
                            } else if (alta == 1) {
                                ventana.imprimirDatos("No sha pogut donar de alta el client");
                            }

                            if (delete == 0) {
                                ventana.imprimirDatos("Sha donat de baixa el client corresponent");
                            } else if (delete == 1) {
                                ventana.imprimirDatos("No sha pogut eliminar el client");
                            }

                            if (update == 0) {
                                ventana.imprimirDatos("Sha modificat el client corresponent");
                            } else if (update == 1) {
                                ventana.imprimirDatos("No sha pogut modificar el client");
                            }

                            salir = true;
                            break;


                        case 3:
                            delad = in.readInt();
                        switch (delad) {
                            case 1:
                                alta = servidor.altaReserves(in, out);
                                delete = 2;
                                update = 2;
                                break;
                            case 2:
                                delete = servidor.baixaReserves(in, out);
                                alta = 2;
                                update = 2;
                                break;
                            case 3:
                                update = servidor.updateReserves(in, out);
                                alta = 2;
                                delete = 2;
                                break;
                            default:
                                alta = 2;
                                delete = 2;
                                update = 2;
                                break;
                        }
                            if (alta == 0) {
                                ventana.imprimirDatos("Sha donat de alta la reserva corresponent");
                            } else if (alta == 1) {
                                ventana.imprimirDatos("No sha pogut donar de alta la reserva");
                            }

                            if (delete == 0) {
                                ventana.imprimirDatos("Sha donat de baixa la reserva corresponent");
                            } else if (delete == 1) {
                                ventana.imprimirDatos("No sha pogut eliminar la reserva");
                            }

                            if (update == 0) {
                                ventana.imprimirDatos("Sha modificat la reserva corresponent");
                            } else if (update == 1) {
                                ventana.imprimirDatos("No sha pogut modificar la reserva");
                            }

                            salir = true;
                            break;

                        case 4:
                            delad = in.readInt();
                        switch (delad) {
                            case 1:
                                alta = servidor.altaUsuaris(in, out);
                                delete = 2;
                                update = 2;
                                break;
                            case 2:
                                delete = servidor.baixaUsuaris(in, out);
                                alta = 2;
                                update = 2;
                                break;
                            case 3:
                                update = servidor.updateUsuaris(in, out);
                                alta = 2;
                                delete = 2;
                                break;
                            default:
                                alta = 2;
                                delete = 2;
                                update = 2;
                                break;
                        }
                            if (alta == 0) {
                                ventana.imprimirDatos("Sha donat de alta el usuari corresponent");
                            } else if (alta == 1) {
                                ventana.imprimirDatos("No sha pogut donar de alta el usuari");
                            }

                            if (delete == 0) {
                                ventana.imprimirDatos("Sha donat de baixa el usuari corresponent");
                            } else if (delete == 1) {
                                ventana.imprimirDatos("No sha pogut eliminar el usuari");
                            }

                            if (update == 0) {
                                ventana.imprimirDatos("Sha modificat el usuari corresponent");
                            } else if (update == 1) {
                                ventana.imprimirDatos("No sha pogut modificar el usuari");
                            }

                            salir = true;
                            break;

                        default:
                    }
                } catch (IOException ex) {
                } catch (SQLException ex) {
                    Logger.getLogger(HilosServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            s.close();
            //Registrar en el logs el llistat de tots els usuaris guardats al map

        } catch (IOException ex) {
            Logger.getLogger(HilosServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
