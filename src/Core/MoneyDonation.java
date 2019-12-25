package Core;

public class MoneyDonation extends Donation {
    public MoneyDonation(int id , double amount , int donorID, int charityID){
        super(id,amount,donorID,charityID);
    }
    @Override
    public void addDonation(){
        DatabaseManager.getInstance().insertDonation(this);
    }
    @Override
    public void editDonation(){}
    @Override
    public void removeDonation(){}
}
