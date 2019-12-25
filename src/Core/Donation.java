package Core;

import java.io.Serializable;

public abstract class Donation implements Serializable {
    private Integer id;
    private Double amount;
    private int donorId;
    private int charityId;

    public Donation(int id, double amount, int donorId, int charityId) {
        this.id = id;
        this.amount = amount;
        this.donorId = donorId;
        this.charityId = charityId;
    }

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

    public void addDonation(){
    }

    public void editDonation(){

    }
    public void removeDonation(){

    }

}
