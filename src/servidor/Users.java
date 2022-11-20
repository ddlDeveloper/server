/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Users {

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }
    
    public void addUser(String user, String password){
        this.users.add(user);
        this.passwords.add(password);
    }
    
    
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private String id;
    private String user;
    private String password;
    private String nom;

    public Users(String id, String user, String password, String nom, String cognom, String correu, String DNI, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String codiPostal, String IBAN) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nom = nom;
        this.cognom = cognom;
        this.correu = correu;
        this.DNI = DNI;
        this.tarjetaBancaria = tarjetaBancaria;
        this.carrer = carrer;
        this.municipi = municipi;
        this.provincia = provincia;
        this.nacionalitat = nacionalitat;
        this.codiPostal = codiPostal;
        this.IBAN = IBAN;
    }
    private String cognom;
    private String correu;
    private String DNI;
    private String tarjetaBancaria;
    private String carrer;
    private String municipi;
    private String provincia;
    private String nacionalitat;
    private String codiPostal;
    private String IBAN;
    private String Telefon;

    public Users(String id, String user, String password, String nom, String cognom, String correu, String DNI, String tarjetaBancaria, String carrer, String municipi, String provincia, String nacionalitat, String codiPostal, String IBAN, String Telefon) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nom = nom;
        this.cognom = cognom;
        this.correu = correu;
        this.DNI = DNI;
        this.tarjetaBancaria = tarjetaBancaria;
        this.carrer = carrer;
        this.municipi = municipi;
        this.provincia = provincia;
        this.nacionalitat = nacionalitat;
        this.codiPostal = codiPostal;
        this.IBAN = IBAN;
        this.Telefon = Telefon;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword_(String password) {
        this.password = password;
    }
    
    /**public void update(Object arg) {

        if (arg instanceof Users usr) {

            this.id.setId(usr.getId());
            this.user.setText(usr.getUser() + "");
            this.password.setText(usr.getDieselOptima() + "");

        }

    }
*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTarjetaBancaria() {
        return tarjetaBancaria;
    }

    public void setTarjetaBancaria(String tarjetaBancaria) {
        this.tarjetaBancaria = tarjetaBancaria;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
