package Core;

import java.io.Serializable;
import java.util.Locale;

public abstract class Donation implements Serializable {
    private  Integer id;
    private Double amount;
    private int donorId;
    private String charityName;
    private String charityCategory;
    private static int count=1;
    public Donation( Double amount, int donorId, String charityName, String charityCategory) {
        this.id=count;
        count++;
        this.amount = amount;
        this.donorId = donorId;
        this.charityName = charityName;
        this.charityCategory = charityCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCharityCategory() {
        return charityCategory;
    }

    public void setCharityCategory(String charityCategory) {
        this.charityCategory = charityCategory;
    }

    public abstract void addDonation();

    public abstract void editDonation();
    public abstract void removeDonation();

}
