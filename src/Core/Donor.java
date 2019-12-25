package Core;

public class Donor extends User {

    private int rank;

    public Donor(int id, String username, String password, String name, String email, String address, String phoneNumber, int rank) {
        super(id, username, password, name, email, address, phoneNumber);
        this.rank = rank;
    }
    public void donate(Donation type,int amount){

    }

    public void addDonor(){

    }
    public void removeDonor(){

    }
    public void editDonor(){

    }

}
