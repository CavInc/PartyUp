package tk.cavinc.connexion.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cav on 13.04.20.
 */

public class UserModel {
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("email")
    @Expose
    private String mEmail;
    @SerializedName("age")
    @Expose
    private int mAge;
    @SerializedName("six")
    @Expose
    private int mSix;
    @SerializedName("gender")
    @Expose
    private String mGender;

    private String mPhoto;
    @SerializedName("password")
    @Expose
    private String mPass;

    public UserModel(){
        mSix = -1;
    }

    public UserModel(int id, String name, String email, int age, int six, String gender) {
        mId = id;
        mName = name;
        mEmail = email;
        mAge = age;
        mSix = six;
        mGender = gender;
    }

    public UserModel(int id, String name, String email, int age, int six, String gender, String photo) {
        mId = id;
        mName = name;
        mEmail = email;
        mAge = age;
        mSix = six;
        mGender = gender;
        mPhoto = photo;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public int getAge() {
        return mAge;
    }

    public int getSix() {
        return mSix;
    }

    public String getGender() {
        return mGender;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }


    public void setAge(int age) {
        mAge = age;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public void setSix(int six) {
        mSix = six;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getPass() {
        return mPass;
    }

    public void setPass(String pass) {
        mPass = pass;
    }
}
