package model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Users {
    //private int id;
    private String userName;
    private String email;
    private String passwords;
    private  String address;
    private String adminCode;



    public Users() {

    }
    public Users(String userName, String email, String passwords, String address) {
        this.userName = userName;
        this.email = email;
        this.passwords = passwords;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passwords='" + passwords + '\'' +
                ", address='" + address + '\'' +
                ", adminCode='" + adminCode + '\'' +
                '}';
    }


}
