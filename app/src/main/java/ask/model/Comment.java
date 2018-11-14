package ask.model;

/**
 * @author lifan
 * @date 2018/11/4 23:53
 * @email 2224779926@qq.com
 * @desc
 */

public class Comment {
    /**
     * askID:问题ID
     * commentID:评论ID
     * userImgID:评论者头像url
     * date:该评论创建时间
     * name:评论者名字
     * commendSum:该评论获得的点赞数
     * commentText:评论内容
     * userType:评论类型（医生或普通用户）
     */
    private int askID;
    private int commentID;
    private String userImgURL;
    private String date;
    private String name;
    private int commendSum;
    private String commentText;
    private int userType;

    @Override
    public String toString() {
        return "Comment{" +
                "askID=" + askID +
                ", commentID=" + commentID +
                ", userImgURL='" + userImgURL + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", commendSum=" + commendSum +
                ", commentText='" + commentText + '\'' +
                ", userType=" + userType +
                '}';
    }

    public int getAskID() {
        return askID;
    }

    public void setAskID(int askID) {
        this.askID = askID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getUserImgURL() {
        return userImgURL;
    }

    public void setUserImgURL(String userImgURL) {
        this.userImgURL = userImgURL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommendSum() {
        return commendSum;
    }

    public void setCommendSum(int commendSum) {
        this.commendSum = commendSum;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public final static int TYPE_D = 0;
    public final static int TYPE_U = 1;
}
