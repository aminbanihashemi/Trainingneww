package app.sematech.training.User;

import android.support.annotation.Nullable;

import com.orm.SugarRecord;

import app.sematech.training.DownloadModel;

public class UserModel extends SugarRecord<DownloadModel> {

    public int userID;
    public String firstName;
    public String lastName;
    public String userName;
    public String passWord;
    public int age;
    public Gender sex;
    public String emailAddress;
    public String phoneNumber;

    public UserModel(int userID, String firstName, String lastName, String userName, String passWord, int age, Gender sex,@Nullable String emailAddress,@Nullable String phoneNumber) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.sex = sex;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public UserModel(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public UserModel() {
        super();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
