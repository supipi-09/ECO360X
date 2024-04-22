package ruh.group14.eco360X.model;

public class User {
    private String firstName;
    private String lasttName;
    private String email;
    private String password;

    public User() {
    }

    public User(String firstName, String lasttName, String email, String password) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.email = email;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
