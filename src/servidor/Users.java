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
}
