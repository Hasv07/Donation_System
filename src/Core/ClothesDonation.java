package Core;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class ClothesDonation extends Donation {
    public ClothesDonation(int id , double amount, int donorId, int charityId){
        super(id,amount,donorId,charityId);
    }
    @Override
    public void addDonation(){}
    @Override
    public void editDonation(){}
    @Override
    public void removeDonation(){}
}
