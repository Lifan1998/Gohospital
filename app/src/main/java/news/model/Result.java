package news.model;

import java.util.List;

/**
 * @author lifan
 * @date 2018/10/4 0:43
 * @email 2224779926@qq.com
 * @desc
 */

public class Result {
    private int type;
    private String title ="";
    private List<String> imageUrl;
    private String time = "1990-2-11";
    private String author = "健康头条";
    private int comment = 5;
    private int recommend = 34;
    private String intro = "简介";
    private int id;
    private String aurl;

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getAuthor() {
        return author;
    }

    public int getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", imageUrl=" + imageUrl +
                ", time='" + time + '\'' +
                ", author='" + author + '\'' +
                ", comment=" + comment +
                ", recommend=" + recommend +
                ", intro='" + intro + '\'' +
                ", id=" + id +
                ", aurl='" + aurl + '\'' +
                '}';
    }

    public int getRecommend() {
        return recommend;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public String getIntro() {

        return intro;
    }
}
