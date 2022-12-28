/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import ConBaseDades.Connexio;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

/**
 *
 * @author david
 */
public class Servidor {

    //static Users users_ = new Users();
    private HashMap<Integer, String> usuaris = new HashMap<>();
    Connexio connexio = new Connexio();
    final String KEY = "abecedari69@";

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
    
    public int registreUsuari(DataInputStream in, DataOutputStream out) throws SQLException, IOException {
        int correcte = 0;
        
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    //String id = in.readUTF();
                    String usuari = in.readUTF();
                    String password = in.readUTF();
                    String rol = in.readUTF();
                    
                    correcte = connexio.crearUsuariInicial(usuari, password, rol);
                    
                    if (correcte > 0) {
                        ventana.imprimirDatos("Alta dusuari correcta.");
                        System.out.println("Alta dusuari correcta.");
                        out.writeUTF("Alta dusuari correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut crear el usuari.");
                        System.out.println("No sha pogut crear el usuari.");
                        out.writeUTF("No sha pogut crear el usuari.");
                    }
                }
            }
        return correcte;
    }
    
    public int altaUsuaris(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    //String id = in.readUTF();
                    String usuari = in.readUTF();
                    String password = in.readUTF();
                    String nom = in.readUTF();
                    String cognom = in.readUTF();
                    String correu = in.readUTF();
                    String dni = in.readUTF();
                    String tarjetaBancaria = in.readUTF();
                    String carrer = in.readUTF();
                    String municipi = in.readUTF();
                    String provincia = in.readUTF();
                    String nacionalitat = in.readUTF();
                    String iban = in.readUTF();
                    String telefon = in.readUTF();
                    String codiPostal = in.readUTF();
                    String rol = in.readUTF();

                    correcte = connexio.crearUsuari(usuari, password, nom, cognom, correu, dni, tarjetaBancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codiPostal, rol);

                    /*
                    String usuari = in.readUTF();
                    String password = in.readUTF();
                    String nom = in.readUTF();
                    String cognom = in.readUTF();
                    String correu = in.readUTF();
                    String dni = in.readUTF();
                   // String tarjetaBancaria = in.readUTF();
                    String carrer = in.readUTF();
                    //String municipi = in.readUTF();
                    //String provincia = in.readUTF();
                    //String nacionalitat = in.readUTF();
                    //String iban = in.readUTF();
                    String telefon = in.readUTF();
                    //String codiPostal = in.readUTF();
                    String rol = in.readUTF();

                    correcte = connexio.crearUsuari(usuari, password, nom, cognom, correu, dni, carrer, telefon, rol);*/
                    if (correcte > 0) {
                        ventana.imprimirDatos("Alta dusuari correcta.");
                        System.out.println("Alta dusuari correcta.");
                        out.writeUTF("Alta dusuari correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut crear el usuari.");
                        System.out.println("No sha pogut crear el usuari.");
                        out.writeUTF("No sha pogut crear el usuari.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int altaReserves(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String name = in.readUTF();
                    String lastName = in.readUTF();
                    String docType = in.readUTF();
                    String numDoc = in.readUTF();
                    String address = in.readUTF();
                    String phone = in.readUTF();
                    String email = in.readUTF();
                    String acces = in.readUTF();
                    String user = in.readUTF();
                    String password = in.readUTF();
                    String sex = in.readUTF();
                    String dni = in.readUTF();

                    correcte = connexio.crearReserva(name, lastName, docType, numDoc, address, phone, email, acces, user, password, sex);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Alta de reserva correcta.");
                        System.out.println("Alta de reserva correcta.");
                        out.writeUTF("Alta de reserva correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut crear la reserva.");
                        System.out.println("No sha pogut crear la reserva.");
                        out.writeUTF("No sha pogut crear la reserva.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int altaClients(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String nacionality = in.readUTF();
                    String address = in.readUTF();
                    String buscar = in.readUTF();
                    String email = in.readUTF();
                    String iban = in.readUTF();
                    String idpersona = in.readUTF();
                    String lastname = in.readUTF();
                    String municipality = in.readUTF();
                    String name = in.readUTF();
                    String num_document = in.readUTF();
                    String phone = in.readUTF();
                    String postalcode = in.readUTF();
                    String province = in.readUTF();

                    correcte = connexio.crearClient(nacionality, address, email, iban, lastname, municipality, name, num_document, phone, postalcode, province);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Alta de client correcta.");
                        System.out.println("Alta de client correcta.");
                        out.writeUTF("Alta de client correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut crear el client.");
                        System.out.println("No sha pogut crear el client.");
                        out.writeUTF("No sha pogut crear el client.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public void obrirServer() throws IOException, SQLException {

        //Establir la connexió a la BD's  
        //Connexio conn = new Connexio();
        connexio.establirConnexio();
        int rol = 0;

        //Afegim el usuari i la seva sessió al HasMap
        try {

            while (true) {

                s = server.accept();

                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                ventana.imprimirDatos("Connexio correcta.");

                //Missatge de benvinguda al establir la comunicació
                out.writeUTF("Connexio correcta.");
                ventana.imprimirDatos("Sha obert connexio amb la ip " + s.getInetAddress() + " ");

                //Recullir el login de l'usuari
                //format LOGIN,usuari,contrasenya,id_conn
                String user = in.readUTF();
                String passDesenCrypt = in.readUTF();
                String password = Desencriptar(passDesenCrypt);
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
                out.writeInt(registres); // aquesta línia aquí per poder enviar el valor real del rol
                if (id_conn == 1) {
                    rol = connexio.rolUsuari(user, password);
                    out.writeInt(rol);
                    System.out.println("El rol es " + rol + ".");

                }

                //Si id_conn == 0 està fent la pantalla de LOGIN
                if (id_conn == 0) {
                    //El ususari ha fet el login correcte
                    //if (registres == 1) {

                    //Gereno un id_conn nou aleatori
                    //int new_id_conn = (int) Math.floor((Math.random() * (900 - 100 + 1) + (100)));
                    //Afegim el usuari i la seva sessió al HasMap
                    registreUsuari(in, out);
                    //Enviem el ID# assignat a l'usuari, al servidor
                    //out.writeInt(new_id_conn);
                    //ventana.imprimirDatos("Sha enviat la id " + new_id_conn + ".");
                    //Enviar el rol que té l'usuari.
                    rol = connexio.rolUsuari(user, password);
                    System.out.println(rol);
                    out.writeInt(rol);

                    //} else {
                    //No te ID i el usuari / contrasenya no es correcte
                    //Enviem el ID# assignat a l'usuari -ID = 0 ERROR
                    //out.writeInt(0);
                    //ventana.imprimirDatos("Usuari o contrasenya incorrecta.");
                    //}
                } else {
                    //Te id
                    // Iniciem el fil amb el client
                    if (registres > 0) {
                        HilosServidor hilo = new HilosServidor(s, in, out, user, password, id_conn, this, ventana);
                        hilo.start();
                    } else {
                        ventana.imprimirDatos("Usuari o contrasenya incorrecta.");
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

    // Clau d'encriptació / desencriptació
    public SecretKeySpec CrearClave(String llave) {
        
        try {
            
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            
            return secretKeySpec;
            
        } catch (Exception e) {
            
            return null;
            
        }

    }

    // Desencriptació
    public String Desencriptar(String desencriptar) {

        try {
            
            SecretKeySpec secretKeySpec = CrearClave(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] cadena = Base64.decode(desencriptar);
            byte[] desencriptacio = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacio);
            
            return cadena_desencriptada;

        } catch (Exception e) {
            
            return "";
            
        }
    }
    
    public String Encriptar(String encriptar) {

        try {
            
            SecretKeySpec secretKeySpec = CrearClave(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            byte[] cadena_encriptar = Base64.encode(encriptada);
            String cadena_encriptada = new String(cadena_encriptar);
            
            return cadena_encriptada;

        } catch (Exception e) {
            
            return "";
            
        }
    }

    public int baixaUsuaris(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String usuari = in.readUTF();
                    String password = in.readUTF();

                    correcte = connexio.eliminarUsuari(usuari, password);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Baixa dusuari correcta.");
                        System.out.println("Baixa dusuari correcta.");
                        out.writeUTF("Baixa dusuari correcta.");
                        out.writeInt(1);
                    } else {
                        ventana.imprimirDatos("No sha pogut eliminar el usuari.");
                        System.out.println("No sha pogut eliminar el usuari.");
                        out.writeUTF("No sha pogut eliminar el usuari.");
                        out.writeInt(0);
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int baixaClients(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String dni = in.readUTF();
                    //String password = in.readUTF();

                    correcte = connexio.eliminarClient(dni);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Baixa de client correcta.");
                        System.out.println("Baixa de client correcta.");
                        out.writeUTF("Baixa de client correcta.");
                        out.writeInt(1);
                    } else {
                        ventana.imprimirDatos("No sha pogut eliminar el client.");
                        System.out.println("No sha pogut eliminar el client.");
                        out.writeUTF("No sha pogut eliminar el client.");
                        out.writeInt(0);
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int baixaReserves(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String dni = in.readUTF();
                    //String password = in.readUTF();

                    correcte = connexio.eliminarClient(dni);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Baixa de reserva correcta.");
                        System.out.println("Baixa de reserva correcta.");
                        out.writeUTF("Baixa de reserva correcta.");
                        out.writeInt(1);
                    } else {
                        ventana.imprimirDatos("No sha pogut eliminar la reserva.");
                        System.out.println("No sha pogut eliminar la reserva.");
                        out.writeUTF("No sha pogut eliminar el client.");
                        out.writeInt(0);
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }
    
    public int updateUsuaris(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    //String id = in.readUTF();
                    String usuari = in.readUTF();
                    String password = in.readUTF();
                    String nom = in.readUTF();
                    String cognom = in.readUTF();
                    String correu = in.readUTF();
                    String dni = in.readUTF();
                    String tarjetaBancaria = in.readUTF();
                    String carrer = in.readUTF();
                    String municipi = in.readUTF();
                    String provincia = in.readUTF();
                    String nacionalitat = in.readUTF();
                    String iban = in.readUTF();
                    String telefon = in.readUTF();
                    String codiPostal = in.readUTF();
                    String rol = in.readUTF();

                    correcte = connexio.updateUsuari(usuari, password, nom, cognom, correu, dni, tarjetaBancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codiPostal, rol);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Modificacio dusuari correcta.");
                        System.out.println("Modificacio dusuari correcta.");
                        out.writeUTF("Modificacio dusuari correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut modifica el usuari.");
                        System.out.println("No sha pogut modificar el usuari.");
                        out.writeUTF("No sha pogut modificar el usuari.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int updateReserves(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String name = in.readUTF();
                    String lastName = in.readUTF();
                    String docType = in.readUTF();
                    String numDoc = in.readUTF();
                    String address = in.readUTF();
                    String phone = in.readUTF();
                    String email = in.readUTF();
                    String acces = in.readUTF();
                    String user = in.readUTF();
                    String password = in.readUTF();
                    String sex = in.readUTF();
                    String dni = in.readUTF();

                    correcte = connexio.updateReserva(name, lastName, docType, numDoc, address, phone, email, acces, user, password, sex);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Modificacio de reserva correcta.");
                        System.out.println("Modificacio de reserva correcta.");
                        out.writeUTF("Modificacio de reserva correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut modificar la reserva.");
                        System.out.println("No sha pogut modificar la reserva.");
                        out.writeUTF("No sha pogut modificar la reserva.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

    public int updateClients(DataInputStream in, DataOutputStream out) throws SQLException {

        int correcte = 0;
        try {
            if (in.readInt() == 1) {
                out.writeInt(1);

                if (in.readBoolean() == true) {
                    out.writeBoolean(true);

                    String nacionality = in.readUTF();
                    String address = in.readUTF();
                    String buscar = in.readUTF();
                    String email = in.readUTF();
                    String iban = in.readUTF();
                    String idpersona = in.readUTF();
                    String lastname = in.readUTF();
                    String municipality = in.readUTF();
                    String name = in.readUTF();
                    String num_document = in.readUTF();
                    String phone = in.readUTF();
                    String postalcode = in.readUTF();
                    String province = in.readUTF();

                    correcte = connexio.updateClient(nacionality, address, email, iban, lastname, municipality, name, num_document, phone, postalcode, province);
                    if (correcte > 0) {
                        ventana.imprimirDatos("Modificacio de client correcta.");
                        System.out.println("Modificacio de client correcta.");
                        out.writeUTF("Modificacio de client correcta.");
                    } else {
                        ventana.imprimirDatos("No sha pogut modificar el client.");
                        System.out.println("No sha pogut modificar el client.");
                        out.writeUTF("No sha pogut modificar el client.");
                    }

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcte;
    }

}
