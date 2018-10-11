package ask.model;

import java.util.List;

/**
 * @author lifan
 * @date 2018/10/4 15:08
 * @email 2224779926@qq.com
 * @desc
 */

public class AskItem {
    private List<String> imageurl;
    private String title;
    private String intro;
    private String name;
    private int id;


    @Override
    public String toString() {
        return "AskItem{" +
                "imageurl=" + imageurl +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", time='" + time + '\'' +
                ", collect=" + collect +
                ", comment=" + comment +
                '}';
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

    private String time;
    private int collect;
    private int comment;

}
