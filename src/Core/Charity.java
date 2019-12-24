package Core;

public class Charity {
    private int id;
    private String name;
    private String category;
    private String description;
    private String link;
    private String email;

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

    public void addCharity(){
        AddCharityOperation add = new AddCharityOperation();
        add.excute();
    }
    public void removeCharity(){
        RemoveCharityOperation remove = new RemoveCharityOperation();
        remove.excute();
    }
    public void editCharity(){
        EditCharityOperation edit = new EditCharityOperation();
        edit.excute();
    }
}
