/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConBaseDades;

/**
 *
 * @author david
 */

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import models.*;
import servidor.Servidor;

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

    
    public int crearUsuari (String usuari, String password, String nom, String cognom, String correu, String doctype, String numdoc, String carrer, String telefon, String rol, String sex) throws SQLException {
        int correcte = 0;
/*
        String query =  "INSERT INTO user_data(" +
                            "	usuari, contrasenya, nom, cognom, correu, dni, tarjeta_bancaria, carrer, municipi, provincia, nacionalitat, iban, telefon, codi_postal, rol)\n" +
                            "	VALUES ('"+usuari+"', '"+password+"', '"+nom+"', '"+cognom+"', '"+correu+"', '"+dni+"', '"+tarjetaBancaria+"', '"+carrer+"', '"+municipi+"', '"+provincia+"', '"+nacionalitat+"', '"+iban+"', '"+telefon+"', '"+codiPostal+"', '"+rol+"');";*/
        String query =  "INSERT INTO user_data(" +
                            "	usuari, contrasenya, nom, cognom, correu, dni, tarjeta_bancaria, carrer, telefon, rol, iban)\n" +
                            "	VALUES ('"+usuari+"', '"+password+"', '"+nom+"', '"+cognom+"', '"+correu+"', '"+doctype+"', '"+numdoc+"', '"+carrer+"', '"+telefon+"', '"+rol+"', '"+sex+"');";
        
        //usuari, password, nom, cognom, correu, doctype, numdoc, carrer, telefon, rol, sex
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
    
    
    public int crearUsuariInicial (String usuari, String password, String rol) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO user_data(" +
                            "	usuari, contrasenya, rol)\n" +
                            "	VALUES ('"+usuari+"', '"+password+"', '"+rol+"');";
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
    
    public int crearClient (String name, String lastname, String email, String doctype, String num_document, String address, String municipality, String postalcode, String province, String nacionality, String phone, String iban) throws SQLException {
        int correcte = 0;

        String query =  "INSERT INTO clients(\n" +
"	name, lastname, email, dni, num_document, address, municipality, postalcode, province,  nacionality, phone, iban)\n" +
"	VALUES ('"+name+"', '"+lastname+"', '"+email+"', '"+doctype+"', '"+num_document+"', '"+address+"', '"+municipality+"', '"+postalcode+"', '"+province+"', '"+nacionality+"', '"+phone+"', '"+iban+"');";
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
      
      public int updateClient (String nacionality, String address, String email, String iban, String lastname, String municipality, String name, String dni, String num_document, String phone, String postalcode, String province) throws SQLException {
        int correcte = 0;

        String query =  "UPDATE clients\n" +
"	SET nacionality='"+nacionality+"', address='"+address+"', email='"+email+"', iban='"+iban+"', lastname='"+lastname+"', municipality='"+municipality+"', name='"+name+"', dni='"+dni+"', num_document='"+num_document+"', phone='"+phone+"', postalcode='"+postalcode+"', province='"+province+"'\n" +
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
      
      public ArrayList<User> userRead() {
          ArrayList<User> list = new ArrayList<User>();
          
          try {
              
              String query = "SELECT * FROM user_data";
              Statement ps = conectar.createStatement();
              ResultSet rs = ps.executeQuery(query);
              
              while(rs.next()){
                  User user = new User();
                  user.setIdUser(rs.getInt("id"));
                  user.setUser(rs.getString("usuari"));
                  user.setPassword(rs.getString("contrasenya"));
                  user.setName(rs.getString("nom"));
                  user.setSurname(rs.getString("cognom"));
                  user.setMail(rs.getString("correu"));
                  user.setDni(rs.getString("dni"));
                  user.setBankTarget(rs.getString("tarjeta_bancaria"));
                  user.setAddress(rs.getString("carrer"));
                  user.setCity(rs.getString("municipi"));
                  user.setProvince(rs.getString("provincia"));
                  user.setCountry(rs.getString("nacionalitat"));
                  user.setIban(rs.getString("iban"));
                  user.setPhone(rs.getString("telefon"));
                  user.setPostalCode(rs.getString("codi_postal"));
                  user.setRol(rs.getInt("rol"));
                  list.add(user);
                  
                  ps.close();
                  ps = null;
                  tancarConexio();
           
              }
              
          } catch (SQLException ex) {
              
              java.util.logging.Logger.getLogger(Connexio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              
          }
          return list;
      }

      
      public ArrayList<Client> clientRead() {
          ArrayList<Client> list = new ArrayList<Client>();
          
          try {
              
              String query = "SELECT * FROM clients";
              Statement ps = conectar.createStatement();
              ResultSet rs = ps.executeQuery(query);
              
              while(rs.next()){
                 
                  Client client = new Client();
                  client.setIdClient(rs.getInt("id"));
                  client.setNacionality(rs.getString("nacionality"));
                  client.setAddress(rs.getString("address"));
                  client.setEmail(rs.getString("email"));
                  client.setIban(rs.getString("iban"));
                  client.setLastname(rs.getString("lastname"));
                  client.setCity(rs.getString("municipality"));
                  client.setName(rs.getString("name"));
                  client.setNumDoc(rs.getString("num_document"));
                  client.setPhone(rs.getString("phone"));
                  client.setPostalCode(rs.getString("postalcode"));
                  client.setProvince(rs.getString("province"));
                  list.add(client);
                  
                  ps.close();
                  ps = null;
                  tancarConexio();
           
              }
              
          } catch (SQLException ex) {
              
              java.util.logging.Logger.getLogger(Connexio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              
          }
          return list;
      }

      
      public ArrayList<Reserve> reserveRead() {
          ArrayList<Reserve> list = new ArrayList<Reserve>();
          
          try {
              
              String query = "SELECT * FROM reserves";
              Statement ps = conectar.createStatement();
              ResultSet rs = ps.executeQuery(query);
              
              while(rs.next()){
                  
                  Reserve reserve = new Reserve();
                  reserve.setIdReserve(rs.getInt("id"));
                  reserve.setName(rs.getString("name"));
                  reserve.setLastname(rs.getString("lastName"));
                  reserve.setDocType(rs.getString("docType"));
                  reserve.setDni(rs.getString("dni"));
                  reserve.setAddress(rs.getString("address"));
                  reserve.setPhone(rs.getString("phone"));
                  reserve.setEmail(rs.getString("email"));
                  reserve.setAcces(rs.getString("acces"));
                  reserve.setUser(rs.getString("user"));
                  reserve.setPassword(rs.getString("password"));
                  reserve.setSex(rs.getString("sex"));
                  list.add(reserve);
                  
                  ps.close();
                  ps = null;
                  tancarConexio();
           
              }
              
          } catch (SQLException ex) {
              
              java.util.logging.Logger.getLogger(Connexio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              
          }
          return list;
      }

      
      
}
