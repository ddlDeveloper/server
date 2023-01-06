package models;

/**
 *
 * @author David
 */
public class User {
    int idUser;
    String user;
    String password;
    String name; 
    String surname; 
    String mail; 
    String dni; 
    String bankTarget; 
    String address; 
    String city; 
    String province; 
    String country; 
    String iban; 
    String phone; 
    String postalCode; 
    int rol;

    
    public User(){
        //Constructor buit
    }

    public User(int idUser, String user, String password, String name, String surname, String mail, String dni, String bankTarget, String address, String city, String province, String country, String iban, String phone, String postalCode, int rol) {
        this.idUser = idUser;
        this.user = user;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dni = dni;
        this.bankTarget = bankTarget;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.iban = iban;
        this.phone = phone;
        this.postalCode = postalCode;
        this.rol = rol;
    }
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBankTarget() {
        return bankTarget;
    }

    public void setBankTarget(String bankTarget) {
        this.bankTarget = bankTarget;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
