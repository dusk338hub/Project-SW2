public class User {
    private String userName;
    private String mobileNumber;
    private String passWord;
    private String Email;

    public User() {
    }

    public User(String userName, String mobileNumber, String passWord, String email, boolean isSuspend) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.passWord = passWord;
        this.Email = email;

    }

    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
