package tk.cavinc.connexion.data.models;

/**
 * Created by cav on 13.04.20.
 */

public class UserModel {
    private int mId;
    private String mName;
    private String mEmail;
    private int mAge;
    private int mSix;
    private String mGender;
    private String mPhoto;

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
}
