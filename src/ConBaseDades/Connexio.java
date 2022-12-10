/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConBaseDades;

/**
 *
 * @author david
 */

import java.sql.*;

public class Connexio {
  Connection conectar = null;

    String user = "postgres";
    String passwd = "1234qwer";
    String bd = "DDL";
    String ip = "127.0.0.1";
    String port = "5432";

    String cadena = "jdbc:postgresql://" + ip + "/" + bd;

    public Connection establirConnexio() {

        try {

            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, user, passwd);
            System.out.println("SQL_RESPONSE_successful_connection_user " + user);

        } catch (Exception e) {

            System.out.println("SQL_RESPONSE_wrong_connection_database" + e.toString());

        }

        return conectar;
    }

    public void tancarConexio() throws SQLException {
        conectar.close();
    }

    public int loginValit(String usuari, String contrasenya) throws SQLException {
        int cont = 0;

        String query = "select * from user_data where usuari = " + "'" + usuari + "'" + " and contrasenya = '" + contrasenya + "'";
        Statement stmt = conectar.createStatement();

        ResultSet result = stmt.executeQuery(query);
        
        while (result.next()) {
            cont++;
        }
        System.out.println("registres trobats cont: " + cont);
        return cont;
    }

    public int rolUsuari(String usuari, String contrasenya) throws SQLException {
        int rol = 0;

        String query = "select rol from user_data where usuari = " + "'" + usuari + "'" + " and contrasenya = '" + contrasenya + "'";
        Statement stmt = conectar.createStatement();

        ResultSet result = stmt.executeQuery(query);

        if (result.next()) {
            rol = result.getInt("rol");
        }

        return rol;
    }

    public void consultaSqlUsuaris(String consulta) throws SQLException {

        int idUsuari;
        String ulogin;
        String upassword;

        int tipusUsuari;
        String email;
        String telefon;
        int idClient;

        Statement stmt = conectar.createStatement();
        String query = consulta;
        ResultSet result = stmt.executeQuery(query);
        while (result.next()) {
            //idUsuari = result.getInt("id");
            idClient = result.getInt("ID");
            ulogin = result.getString("usuari");
            upassword = result.getString("contrasenya");

            System.out.println(idClient + "\t" + ulogin + "\t" + upassword);
            // Leer registro
        }

    }
    
    public int crearUsuariBD (String id, String usuari, String password, String nom, String cognom, String correu, String dni, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String iban, String telefon, String codiPostal, String rol) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO user_data(" +
                            "	id, usuari, contrasenya, nom, cognom, correu, dni, tarjeta_bancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codi_postal, rol)\n" +
                            "	VALUES ('"+id+"', '"+usuari+"', '"+password+"', '"+nom+"', '"+cognom+"', '"+correu+"', '"+dni+"', '"+tarjetaBancaria+"', '"+carrer+"', '"+municipi+"', '"+provincia+"', '"+nacionalitat+"', '"+iban+"', '"+telefon+"', '"+codiPostal+"', '"+rol+"');";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre afegit.");
            correcte = 1;
        } else {
            System.out.println("No sha afegit cap registre.");
            correcte = 0;
        }
        
        
        return correcte;
    }
  
      public int eliminarUsuariBD (String usuari, String password) throws SQLException {
        int correcte = 0;

        if (loginValit(usuari, password) > 0) {
        String query =  "DELETE FROM user_data WHERE " +
                            " usuari LIKE '"+usuari+"';";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre eliminat.");
            correcte = 1;
        } else {
            System.out.println("No sha eliminat cap registre.");
            correcte = 0;
        }
        } else {
            System.out.println("No existeix el registre.");
            correcte = 0;
        }
        
        return correcte;
    }  

}
