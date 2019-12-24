package Core;

import java.util.ArrayList;

public abstract class User {

    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

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
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
