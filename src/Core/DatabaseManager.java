package Core;

import java.util.ArrayList;

public class DatabaseManager {

   private ArrayList<Donor>donors=new ArrayList<Donor>();
   private ArrayList<Charity>charities=new ArrayList<Charity>();
   private ArrayList<Donation> donations=new ArrayList<Donation>();


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


    public Donor queryDonor(String username){
        for ( Donor donor: donors) {
            if(donor.getUsername().equals(username)) return donor;

        }
        return null;
    }

    public Charity queryCharity(String name){
        for (Charity charity: charities) {
            if (charity.getName().equals(name)) return charity;

        }
        return null;
    }


    public void deleteDonor(String username){
        Donor donor=queryDonor(username);
        donors.remove(donor);
    }

    public void deleteCharity(String name){
        Charity charity =queryCharity(name);
        charities.remove(charity);
    }


    public void insertDonation(Donation donation){
        donations.add(donation);
    }

    public ArrayList<Donation> queryDonorDonations(Donor donor){
        ArrayList<Donation> donations =new ArrayList<>();
        for (Donation donation: this.donations) {
            if(donation.getDonorId()==donor.getId()) donations.add(donation);

        }
        return donations;
    }











}
