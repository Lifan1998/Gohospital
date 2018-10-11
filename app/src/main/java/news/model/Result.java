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

    public int getRecommend() {
        return recommend;
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
