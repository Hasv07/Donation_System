package Core;

public class ClothesDonation extends Donation {
    public ClothesDonation( Double amount, int donorId, String charityName, String charityCategory) {
        super( amount, donorId, charityName, charityCategory);
    }

    @Override
    public void addDonation(){}
    @Override
    public void editDonation(){}
    @Override
    public void removeDonation(){}
}
