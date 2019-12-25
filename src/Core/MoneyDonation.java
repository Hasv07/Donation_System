package Core;

public class MoneyDonation extends Donation {
    public MoneyDonation(int id, double amount, int donorId, int charityId){
        super(id,amount,donorId,charityId);
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
