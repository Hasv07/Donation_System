package Core;

public class MoneyDonation extends Donation {
    public MoneyDonation(Integer id, Double amount, int donorId, String charityName, String charityCategory) {
        super(id, amount, donorId, charityName, charityCategory);
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
