/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author david
 */
public class Client {
    
    int idClient;
    String nacionality;
    String address;
    String email; 
    String iban; 
    String lastname; 
    String city; 
    String name; 
    String numDoc; 
    String phone; 
    String postalCode; 
    String province; 

    
    public Client(int idClient, String nacionality, String address, String email, String iban, String lastname, String city, String name, String numDoc, String phone, String postalCode, String province) {
        this.idClient = idClient;
        this.nacionality = nacionality;
        this.address = address;
        this.email = email;
        this.iban = iban;
        this.lastname = lastname;
        this.city = city;
        this.name = name;
        this.numDoc = numDoc;
        this.phone = phone;
        this.postalCode = postalCode;
        this.province = province;
    }

    public Client() {
    }
    
    
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    
}
