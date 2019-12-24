package Core;

public class Admin extends User{
    public Admin(int id, String username, String password, String name, String email, String address, String phoneNumber) {
        super(id, username, password, name, email, address, phoneNumber);
    }

    public void executeDonorOperation(DonorOperation donorOperation){

    }
    public void executeCharityOperation(CharityOperation charityOperation){

    }

}
