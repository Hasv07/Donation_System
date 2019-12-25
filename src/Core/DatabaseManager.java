package Core;

import java.io.*;
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
            instance.save();
        }
        instance.read();
        return instance;
    }


    private void save()  {
        try{
            FileOutputStream fos = new FileOutputStream("donors.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(donors);
            fos.close();
            oos.close();

            fos= new FileOutputStream("charities.tmp");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(charities);
            fos.close();
            oos.close();

            fos= new FileOutputStream("donations.tmp");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(donations);
            fos.close();
            oos.close();

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }
    private void read(){
        try{
            FileInputStream fis = new FileInputStream("donors.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            donors = (ArrayList<Donor>)ois.readObject();
            fis.close();
            ois.close();


            fis = new FileInputStream("charities.tmp");
            ois = new ObjectInputStream(fis);
            charities = (ArrayList<Charity>) ois.readObject();
            fis.close();
            ois.close();


            fis = new FileInputStream("donations.tmp");
            ois = new ObjectInputStream(fis);
            donations = (ArrayList<Donation>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }



    public  ArrayList<Donor> queryDonors( ) {

        return donors;
    }

    public  ArrayList<Charity> queryCharities( ) {

        return charities;
    }


    public void insertDonor(Donor donor) {
       donors.add(donor);
       this.save();
    }


    public void insertCharity(Charity charity) {
        charities.add(charity);
        this.save();
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
        this.save();
    }

    public void deleteCharity(String name){
        Charity charity =queryCharity(name);
        charities.remove(charity);
        this.save();
    }


    public void insertDonation(Donation donation){
        donations.add(donation);
        this.save();
    }

    public ArrayList<Donation> queryDonorDonations(Donor donor){
        ArrayList<Donation> donations =new ArrayList<>();
        for (Donation donation: this.donations) {
            if(donation.getDonorId()==donor.getId()) donations.add(donation);

        }
        return donations;
    }












}
