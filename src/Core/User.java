package Core;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {

    private  int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private static int counter;
    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
         this.password=password;
             }

    public ArrayList executeSearch(SearchManager search){

    return new ArrayList() ;
    }


    public User( String username, String password, String name, String email, String address, String phoneNumber) {
        User user =DatabaseManager.getInstance().queryDonors().get(DatabaseManager.getInstance().queryDonors().size()-1);
        counter=user.getId();
        counter++;
        this.id = counter;

        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
