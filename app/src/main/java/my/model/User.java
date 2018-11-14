package my.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author lifan
 * @date 2018/9/26 21:00
 * @email 2224779926@qq.com
 * @desc
 */

public class User implements Parcelable {
    private String name;
    private String uAge;
    private Integer uId;
    private String uName;
    private String uSex;

    private String uTel;
    private String uEmail;
    private String uIdentity;
    private String uPic;

public User(){

}
    protected User(Parcel in) {
        if (in.readByte() == 0) {
            uId = null;
        } else {
            uId = in.readInt();
        }
        uName = in.readString();
        uSex = in.readString();
        uAge = in.readString();
        uTel = in.readString();
        uEmail = in.readString();
        uIdentity = in.readString();
        uPic = in.readString();
        name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uAge='" + uAge + '\'' +
                ", uTel='" + uTel + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uIdentity='" + uIdentity + '\'' +
                ", uPic='" + uPic + '\'' +
                ", Name='" + name + '\'' +
                '}';
    }



    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuIdentity() {
        return uIdentity;
    }

    public void setuIdentity(String uIdentity) {
        this.uIdentity = uIdentity;
    }

    public String getuPic() {
        return uPic;
    }

    public void setuPic(String uPic) {
        this.uPic = uPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (uId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(uId);
        }
        dest.writeString(uName);
        dest.writeString(uSex);
        dest.writeString(uAge);
        dest.writeString(uTel);
        dest.writeString(uEmail);
        dest.writeString(uIdentity);
        dest.writeString(uPic);
        dest.writeString(name);
    }
}
