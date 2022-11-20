/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConBaseDades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ConnexioSQL {

    //Preparat per fer connexions a la base de dades
    //Login init = new Login();
    public static Connection conectar = null;

    public static String url = "jdbc:postgresql://localhost:5432/DDL";
    public static String user = "postgres";
    public static String passwd = "1234qwer";
    public static String clase = "org.postgresql.Driver";

    public static Connection establirConexio() {
        try {
            Class.forName(clase);
            conectar = DriverManager.getConnection(url, user, passwd);
            //conectar.setAutoCommit(true);
            System.out.println("Connexió establerta a la base de dades");
            //JOptionPane.showMessageDialog(null, "Connexió establerta a la base de dades");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar amb la base de dades " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return conectar;
    }

}
