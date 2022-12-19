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
    
    public int clientValit(String dni) throws SQLException {
        int cont = 0;

        String query = "select * from clients where dni = '" + dni + "'";
        Statement stmt = conectar.createStatement();

        ResultSet result = stmt.executeQuery(query);
        
        while (result.next()) {
            cont++;
        }
        System.out.println("registres trobats cont: " + cont);
        return cont;
    }

    public int reservaValida(String numDoc) throws SQLException {
        int cont = 0;

        String query = "select * from reserves where numDoc = '" + numDoc + "'";
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

        String query = "select rol from user_data where usuari = '" + usuari + "' and contrasenya = '" + contrasenya + "'";
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
    
    public int crearUsuari (String usuari, String password, String nom, String cognom, String correu, String dni, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String iban, String telefon, String codiPostal, String rol) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO user_data(" +
                            "	usuari, contrasenya, nom, cognom, correu, dni, tarjeta_bancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codi_postal, rol)\n" +
                            "	VALUES ('"+usuari+"', '"+password+"', '"+nom+"', '"+cognom+"', '"+correu+"', '"+dni+"', '"+tarjetaBancaria+"', '"+carrer+"', '"+municipi+"', '"+provincia+"', '"+nacionalitat+"', '"+iban+"', '"+telefon+"', '"+codiPostal+"', '"+rol+"');";
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
    
    
    
    public int crearReserva (String name, String lastName, String docType, String numDoc, String address, String phone, String email, String acces, String user, String password, String sex) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO reserves(\n" +
"	name, \"lastName\", \"docType\", \"numDoc\", address, phone, email, acces, \"user\", password, sex)\n" +
"	VALUES ('"+name+"', '"+lastName+"', '"+docType+"', '"+numDoc+"', '"+address+"', '"+phone+"', '"+email+"', '"+acces+"', '"+user+"', '"+password+"', '"+sex+"');";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre de reserva afegit.");
            correcte = 1;
        } else {
            System.out.println("No sha afegit cap reserva.");
            correcte = 0;
        }
        
        
        return correcte;
    }
    
    public int crearClient (String nacionality, String address, String email, String iban, String lastname, String municipality, String name, String num_document, String phone, String postalcode, String province) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO clients(\n" +
"	nacionality, address, buscar, email, iban, idpersona, lastname, municipality, name, num_document, phone, postalcode, province)\n" +
"	VALUES ('"+nacionality+"', '"+address+"', '"+email+"', '"+iban+"', '"+lastname+"', '"+municipality+"', '"+name+"', '"+num_document+"', '"+phone+"', '"+postalcode+"', '"+province+"');";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre de client afegit.");
            correcte = 1;
        } else {
            System.out.println("No sha afegit cap client.");
            correcte = 0;
        }
        
        
        return correcte;
    }
  
      public int eliminarUsuari (String usuari, String password) throws SQLException {
        int correcte = 0;

        if (loginValit(usuari, password) > 0) {
        String query =  "DELETE FROM user_data WHERE " +
                            " usuari LIKE '"+usuari+"';";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Usuari eliminat.");
            correcte = 1;
        } else {
            System.out.println("No sha eliminat cap usuari.");
            correcte = 0;
        }
        } else {
            System.out.println("No existeix el usuari.");
            correcte = 0;
        }
        
        return correcte;
    }  

      public int eliminarClient (String num_document) throws SQLException {
        int correcte = 0;

        if (clientValit(num_document) > 0) {
        String query =  "DELETE FROM clients\n" +
"	WHERE num_document LIKE '"+num_document+"';";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Client eliminat.");
            correcte = 1;
        } else {
            System.out.println("No sha eliminat cap client.");
            correcte = 0;
        }
        } else {
            System.out.println("No existeix el client.");
            correcte = 0;
        }
        
        return correcte;
    }  

      public int eliminarReserva (String numDoc) throws SQLException {
        int correcte = 0;

        if (reservaValida(numDoc) > 0) {
        String query =  "DELETE FROM reserves \n" +
"	WHERE numDoc LIKE '"+numDoc+"';";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Reserva eliminada.");
            correcte = 1;
        } else {
            System.out.println("No sha eliminat cap reserva.");
            correcte = 0;
        }
        } else {
            System.out.println("No existeix la reserva.");
            correcte = 0;
        }
        
        return correcte;
    }  
      
      public int updateUsuari (String usuari, String password, String nom, String cognom, String correu, String dni, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String iban, String telefon, String codiPostal, String rol) throws SQLException {
        int correcte = 0;

        String query =  "UPDATE user_data\n" +
"	SET usuari='"+usuari+"', contrasenya='"+password+"', nom='"+nom+"', cognom='"+cognom+"', correu='"+correu+"', dni='"+dni+"', tarjeta_bancaria='"+tarjetaBancaria+"', carrer='"+carrer+"', municipi='"+municipi+"', provincia='"+provincia+"', nacionalitat='"+nacionalitat+"', iban='"+iban+"', telefon='"+telefon+"', codi_postal='"+codiPostal+"', rol='"+rol+"'\n" +
"	WHERE dni ='"+dni+"');";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre modificat.");
            correcte = 1;
        } else {
            System.out.println("No sha modificat cap registre.");
            correcte = 0;
        }
        
        
        return correcte;
    }
      
      public int updateClient (String nacionality, String address, String email, String iban, String lastname, String municipality, String name, String num_document, String phone, String postalcode, String province) throws SQLException {
        int correcte = 0;

        String query =  "UPDATE clients\n" +
"	SET nacionality='"+nacionality+"', address='"+address+"', email='"+email+"', iban='"+iban+"', lastname='"+lastname+"', municipality='"+municipality+"', name='"+name+"', num_document='"+num_document+"', phone='"+phone+"', postalcode='"+postalcode+"', province='"+province+"'\n" +
"	WHERE num_document = '"+num_document+"'";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre modificat.");
            correcte = 1;
        } else {
            System.out.println("No sha modificat cap registre.");
            correcte = 0;
        }
        
        
        return correcte;
    }
      
      public int updateReserva (String name, String lastName, String docType, String numDoc, String address, String phone, String email, String acces, String user, String password, String sex) throws SQLException {
        int correcte = 0;

        String query =  "UPDATE reserves\n" +
"	SET name='"+name+"', \"lastName\"='"+lastName+"', \"docType\"='"+docType+"', \"numDoc\"='"+numDoc+"', address='"+address+"', phone='"+phone+"', email='"+email+"', acces='"+acces+"', \"user\"='"+user+"', password='"+password+"', sex='"+sex+"'\n" +
"	WHERE numDoc = '"+numDoc+"';";
        Statement stmt = conectar.createStatement();

        int result = stmt.executeUpdate(query);
        
        if (result > 0) {
            System.out.println("Registre modificat.");
            correcte = 1;
        } else {
            System.out.println("No sha modificat cap registre.");
            correcte = 0;
        }
        
        
        return correcte;
    }

      
}
