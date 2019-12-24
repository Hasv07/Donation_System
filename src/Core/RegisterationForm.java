package Core;

public class RegisterationForm extends Form{
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    private String username= getUserName();
    private String password=getPassword();

    //on submit we should add user to users list in database

    void executeAddDonorOperation(addDonorOperation:AddDonorOperation){
    }
}
