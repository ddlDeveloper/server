/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConBaseDades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class MetodesSQL {

    //Preparat per fer connexions a la base de dades
    public static ConnexioSQL connect = new ConnexioSQL();

    public static PreparedStatement sentence_ready;
    public static ResultSet result;
    String sql;
    int result_number = 0;

    //Crear usuaris
    public int createrUser(String user, String passwd, String nom, String cognom, String correu, String DNI, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String codiPostal, String IBAN) {
        int result = 0;
        Connection conn = null;

       String sentenciaCrear = ("INSERT INTO usuaris (\"ID\",\"Usuari\",\"Contrasenya\",\"Nom\",\"Cognom\",\"Correu\",\"DNI\",\"Tarjeta_Bancaria\",\"Carrer\",\"Municipi\",\"Provincia\",\"Nacionalitat\",\"Codi_Postal\",\"IBAN\") VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try {
            conn = ConnexioSQL.establirConexio();
            sentence_ready = conn.prepareStatement(sentenciaCrear);
            sentence_ready.setString(1, user);
            sentence_ready.setString(2, passwd);
            sentence_ready.setString(3, nom);
            sentence_ready.setString(4, cognom);
            sentence_ready.setString(5, correu);
            sentence_ready.setString(6, DNI);
            sentence_ready.setString(7, tarjetaBancaria);
            sentence_ready.setString(8, carrer);
            sentence_ready.setString(9, municipi);
            sentence_ready.setString(10,provincia);
            sentence_ready.setString(11, nacionalitat);
            sentence_ready.setString(12,codiPostal);
            sentence_ready.setString(13,IBAN);

            result = sentence_ready.executeUpdate();
            sentence_ready.close();

            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static String searchName(String user) {

        String search_name = null;
        Connection conexio = null;

        try {
            conexio = ConnexioSQL.establirConexio();
            String sentenciaBuscar = ("SELECT Nom,Cognom FROM usuaris WHERE Usuari = '" + user + "'");
            sentence_ready = conexio.prepareStatement(sentenciaBuscar);
            result = sentence_ready.executeQuery();

            if (result.next()) {
                String nom = result.getString("Nom");
                String cognom = result.getString("Cognom");
                search_name = (nom + " " + cognom);
            }
            conexio.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return search_name;
    }

    public static String searchUserRegistered(String user, String passwd) {
        String search_user = null;
        Connection conexio = null;

        try {
            conexio = ConnexioSQL.establirConexio();
            String sentenciaBuscarUser = ("SELECT Nom,Usuari,Contrasenya FROM usuaris WHERE Usuari = '" + user + "' && Contrasenya = '" + passwd + "'");
            sentence_ready = conexio.prepareStatement(sentenciaBuscarUser);
            result = sentence_ready.executeQuery();

            if (result.next()) {
                search_user = "Usuari no trobat";
                //search_user = user;
            } else {
                search_user = "Usuari no trobat";
            }
            conexio.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return search_user;
    }

}