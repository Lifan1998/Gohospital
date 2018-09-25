package appoint.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2018/4/18.
 * @author
 */
@Entity
public class Hospital {
    /**
     * id;//医院id，主键
     * imageurl;//医院图标URL
     * name;//医院名称
     * grade;//医院等级 例：三级甲等
     * address;//医院地址
     * score;//医院评分 例：4.5
     */

    public int id;
    public String imageurl;
    public String name;
    public String grade;
    public String address;
    public String score;

    @Generated(hash = 1603080652)
    public Hospital(int id, String imageurl, String name, String grade,
            String address, String score) {
        this.id = id;
        this.imageurl = imageurl;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.score = score;
    }
    @Generated(hash = 1301721268)
    public Hospital() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImageurl() {
        return this.imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return this.grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }
}
