package Core;

public class ClothesDonation extends Donation {
    public ClothesDonation(int id, double amount, int donorId, int charityId){
        super(id,amount,donorId,charityId);
    }
    @Override
    public void addDonation(){}
    @Override
    public void editDonation(){}
    @Override
    public void removeDonation(){}
}
