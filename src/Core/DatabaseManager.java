package Core;

import java.util.ArrayList;

public class DatabaseManager {

   private ArrayList<Donor>donors=new ArrayList<Donor>();
   private ArrayList<Charity>charities=new ArrayList<Charity>();

    private static DatabaseManager instance =null;

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {
        if(instance == null){
            instance=new DatabaseManager();
        }

        return instance;
    }


    public  ArrayList<Donor> queryDonors( ) {

        return donors;
    }

    public  ArrayList<Charity> queryCharities( ) {

        return charities;
    }


    public void insertDonor(Donor donor) {
       donors.add(donor);
    }


    public void insertCharity(Charity charity) {
        charities.add(charity);
    }







}
