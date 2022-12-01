/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import ConBaseDades.Connexio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Servidor {

    //static Users users_ = new Users();

    private HashMap<Integer, String> usuaris = new HashMap<>();
    Connexio connexio = new Connexio();

    public HashMap<Integer, String> getUsuaris() {
        return usuaris;
    }

    public void setUsuaris(HashMap<Integer, String> usuaris) {
        this.usuaris = usuaris;
    }
    private static Socket s;
    private ServerSocket server;
    //boolean comprovacio = false;
    private static VentanaServidor ventana = new VentanaServidor();

    //static DataInputStream in = null;
    //static DataOutputStream out = null;
    //String password;
    //boolean loginReg = false;
    //int index = 0;
    //int indicador = 0;
/*
    public static void main(String[] args) {
        // TODO code application logic here
        
        

        try {

            //users_.addUser("lluis", "daniel");
            //users_.addUser("david", "miro");
            ventana.setVisible(true);
            server = new ServerSocket(8000);

            ventana.imprimirDatos("Inici correcte");
            while (true) {

                s = server.accept();

                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                HilosServidor servidor = new HilosServidor(s, in, out, ventana, );
                servidor.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    */
    public Servidor(int port) throws IOException {

        server = new ServerSocket(port);
        ventana.setVisible(true);

    }

    public void esborrar(int id, String nomClient) {
        //Esborrar el usuari i la seva sessió al HasMap
        usuaris.remove(id, nomClient);

    }

    private void afegir(int id, String nomClient) {
        //Afegim el usuari i la seva sessió al HasMap
        usuaris.put(id, nomClient);

    }

    public void obrirServer() throws IOException, SQLException {

        //Establir la connexió a la BD's  
        //Connexio conn = new Connexio();
        connexio.establirConnexio();

        //Afegim el usuari i la seva sessió al HasMap
        try {

            
            while (true) {

                s = server.accept();

                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                
                ventana.imprimirDatos("Inici correcte");

                //Missatge de benvinguda al establir la comunicació
                out.writeUTF("Inici correcte");
                ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + " ");

                //Recullir el login de l'usuari
                //format LOGIN,usuari,contrasenya,id_conn
                String user = in.readUTF();
                String password = in.readUTF();
                int login = in.readInt();
                ventana.imprimirDatos("Sha intentat loguejar " + user + " amb el password " + password + ".");
                //Descompondre la resposta del client, en un array
                //String[] missatge = resposta.split(",");
                //missatge[0] - LOGIN
                //missatge[1] - usuari
                //missatge[2] - password
                //missatge[3] - id_conn

                //Convertir el camp id_com string a numeric
                int id_conn = login;
                //Mira si l'usuari existeix a la Bd's i si la contrasenya és vàlida
                int registres = connexio.loginValit(user, password);
                
                
                out.writeInt(registres);

                //Si id_conn == 0 està fent la pantalla de LOGIN
                if (id_conn == 0) {
                    //El ususari ha fet el login correcte
                    if (registres == 1) {

                        //Gereno un id_conn nou aleatori
                        int new_id_conn = (int) Math.floor((Math.random() * (900 - 100 + 1) + (100)));

                        //Afegim el usuari i la seva sessió al HasMap
                        afegir(new_id_conn, user);
                        //Enviem el ID# assignat a l'usuari, al servidor
                        out.writeInt(new_id_conn);
                        ventana.imprimirDatos("Sha enviat la id " + new_id_conn + ".");
                        //Enviar el rol que té l'usuari.
                        int rol = connexio.rolUsuari(user, password);
                        out.writeInt(rol);

                    } else {
                        //No te ID i el usuari / contrasenya no es correcte
                        //Enviem el ID# assignat a l'usuari -ID = 0 ERROR
                        out.writeInt(0);
                        ventana.imprimirDatos("Usuari o contrasenya incorrecta.");
                    }
                } else {
                    //Te id
                    // Iniciem el fil amb el client
                    if (registres != 0) {
                    HilosServidor hilo = new HilosServidor(s, in, out, user, password, id_conn, this, ventana);
                    hilo.start();
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Tanquem el fil
        s.close();
        //Tanquem la connexió a la Bd's
        connexio.tancarConexio();
    }
    
}
