package Core;

public class RemoveCharityOperation implements CharityOperation {
    private Charity charity;

    @Override
    public void excute(Charity charity){
        charity.removeCharity();
    }
}
