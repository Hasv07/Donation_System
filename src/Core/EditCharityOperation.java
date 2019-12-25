package Core;

public class EditCharityOperation implements CharityOperation {
    private Charity charity;

    @Override
    public void excute(Charity charity){
        charity.editCharity();
    }

}
