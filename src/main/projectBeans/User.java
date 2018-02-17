package Main.projectBeans;

public class User {
    private String userId;
    private String fName;
    private String lName;
    private String emailAdress;
    private String category;
    private String password;

    public User() {
    }

    public User(String id, String fName, String lName, String emailAdress, String category,
                String password) {
        this.userId = id;
        this.fName = fName;
        this.lName = lName;
        this.emailAdress = emailAdress;
        this.category = category;
        this.password = password;
}

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", category='" + category + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

