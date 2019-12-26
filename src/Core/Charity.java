package Core;

import java.io.Serializable;

public class Charity implements Serializable {
    private  int id;
    private String name;
    private String category;
    private String description;
    private String link;
    private String email;
    private static int counter;
    public Charity(String name, String category, String description, String link, String email) {

        Charity charity=DatabaseManager.getInstance().queryCharities().get(DatabaseManager.getInstance().queryCharities().size()-1);
        counter=charity.getId();

        counter++;
        this.id=counter;

        this.name = name;
        this.category = category;
        this.description = description;
        this.link = link;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCharity(Charity charity){
       // AddCharityOperation add = new AddCharityOperation();
       // add.excute();
        DatabaseManager.getInstance().insertCharity(charity);

    }
    public void removeCharity(){
       //RemoveCharityOperation remove = new RemoveCharityOperation();
        //remove.excute();
    }
    public void editCharity(){
        //EditCharityOperation edit = new EditCharityOperation();
        //edit.excute();
    }
}
