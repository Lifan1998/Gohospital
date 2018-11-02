package ask.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author lifan
 * @date 2018/10/4 15:08
 * @email 2224779926@qq.com
 * @desc
 */

public class AskItem implements Parcelable{
    private List<String> imageurl;
    private String title;
    private String intro;
    private String name;
    /**
     * 问题id
     */
    private int id;
    private String userUrl;
    private String time;
    private int collect = 0;
    private int comment = 0;
    public AskItem(){

    }
    protected AskItem(Parcel in) {
        imageurl = in.createStringArrayList();
        title = in.readString();
        intro = in.readString();
        name = in.readString();
        id = in.readInt();
        userUrl = in.readString();
        time = in.readString();
        collect = in.readInt();
        comment = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(imageurl);
        dest.writeString(title);
        dest.writeString(intro);
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeString(userUrl);
        dest.writeString(time);
        dest.writeInt(collect);
        dest.writeInt(comment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AskItem> CREATOR = new Creator<AskItem>() {
        @Override
        public AskItem createFromParcel(Parcel in) {
            return new AskItem(in);
        }

        @Override
        public AskItem[] newArray(int size) {
            return new AskItem[size];
        }
    };

    @Override
    public String toString() {
        return "AskItem{" +
                "imageurl=" + imageurl +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", userUrl='" + userUrl + '\'' +
                ", time='" + time + '\'' +
                ", collect=" + collect +
                ", comment=" + comment +
                '}';
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImageurl() {
        return imageurl;
    }

    public void setImageurl(List<String> imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }



}
