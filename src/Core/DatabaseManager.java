package Core;

import java.util.ArrayList;

public class DatabaseManager {

   private ArrayList<User>user=new ArrayList<User>();
   private ArrayList<Charity>charity=new ArrayList<Charity>();

   
    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public ArrayList<Charity> getCharity() {
        return charity;
    }

    public void setCharity(ArrayList<Charity> charity) {
        this.charity = charity;
    }

}
