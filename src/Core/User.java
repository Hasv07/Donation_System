package Core;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {

    private static int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList executeSearch(SearchManager search){

    return new ArrayList() ;
    }


    public User(int id, String username, String password, String name, String email, String address, String phoneNumber) {
        this.id = id;
        this.id++;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
