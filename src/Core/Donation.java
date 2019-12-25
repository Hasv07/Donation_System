package Core;

import java.io.Serializable;

public abstract class Donation implements Serializable {
    private int id;
    private double amount;
    private int donorId;
    private int charityId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public void addDonation(Donation donation){
        DatabaseManager.getInstance().insertDonation(donation);
    }

    public void editDonation(){

    }
    public void removeDonation(){

    }

}
