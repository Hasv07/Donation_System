package Core;

public class RemoveDonorOperation implements DonorOperation {
    private Donor donor;
    public RemoveDonorOperation(Donor donor){
        this.donor = donor;
    }

    @Override
    public void execute(Donor donor) {
        this.donor.removeDonor(donor);
    }
}
