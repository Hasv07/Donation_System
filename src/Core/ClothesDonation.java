package Core;

public class ClothesDonation extends Donation {
    public ClothesDonation(Integer id, Double amount, int donorId, String charityName, String charityCategory) {
        super(id, amount, donorId, charityName, charityCategory);
    }

    @Override
    public void addDonation(){}
    @Override
    public void editDonation(){}
    @Override
    public void removeDonation(){}
}
