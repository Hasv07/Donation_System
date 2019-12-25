package Core;

public class AddDonorOperation implements DonorOperation {
    private Donor donor;

    public AddDonorOperation(Donor donor){
        this.donor = donor;
    }

    @Override
    public void execute(Donor donor) {
        this.donor.addDonor(donor);
    }
}
