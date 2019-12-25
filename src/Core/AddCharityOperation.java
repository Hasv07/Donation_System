package Core;

public class AddCharityOperation implements CharityOperation {
    private Charity charity;

    public AddCharityOperation(Charity charity){
        this.charity=charity;
    }
    @Override
    public void excute(Charity charity){
        this.charity.addCharity(charity);
    }
}
