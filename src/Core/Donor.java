package Core;

import java.io.Serializable;

public class Donor extends User implements Serializable {

    private int rank;

    public Donor(int id, String username, String password, String name, String email, String address, String phoneNumber, int rank) {
        super(id, username, password, name, email, address, phoneNumber);
        this.rank = rank;
    }
    public void donate(Donation type,int amount){

    }

    public void addDonor(Donor donor){
        DatabaseManager.getInstance().insertDonor(donor);
    }
    public void removeDonor(Donor donor){
        DatabaseManager.getInstance().deleteDonor(donor.getUsername());
    }
    public void editDonor(){

    }

}
