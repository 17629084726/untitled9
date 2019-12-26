package pojo;

public class User {
    Integer userId =0;
    String userName = "";
    String password = "";
    String userEmail = "";
    String userSex = "";
    String userGrade = "";
    String userStatus = "";
    String userDesc = "";
    String userEndTime = "";
    String headpath = "";
    String userAdress = "";
    String phoneNumber = "";
    String userBirthday = "";
    String realName = "";
    String userHobby= "";

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getUserEndTime() {
        return userEndTime;
    }

    public void setUserEndTime(String userEndTime) {
        this.userEndTime = userEndTime;
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath;
    }
    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

//    public Power getPower() {
//        return power;
//    }
//
//    public void setPower(Power power) {
//        this.power = power;
//    }

    @Override
    public String toString() {
        return "User{" +

                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userGrade='" + userGrade + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", userEndTime='" + userEndTime + '\'' +
                ", headpath='" + headpath + '\'' +
                ", userAdress='" + userAdress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +

                ", realName='" + realName + '\'' +
                //", power=" + power +
                '}';
    }
}
