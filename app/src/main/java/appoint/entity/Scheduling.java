package appoint.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.sql.Date;
import java.sql.Time;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author lifan
 * @date 2018/8/3 15:49
 * @email 2224779926@qq.com
 * @desc
 */
@Entity
public class Scheduling {

    private int id_doctor;
    private String time;
    private int max;
    @Generated(hash = 1690149610)
    public Scheduling(int id_doctor, String time, int max) {
        this.id_doctor = id_doctor;
        this.time = time;
        this.max = max;
    }
    @Generated(hash = 1327949563)
    public Scheduling() {
    }
    public int getId_doctor() {
        return this.id_doctor;
    }
    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getMax() {
        return this.max;
    }
    public void setMax(int max) {
        this.max = max;
    }

}
