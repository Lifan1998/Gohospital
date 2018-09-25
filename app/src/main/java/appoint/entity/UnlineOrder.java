package appoint.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.sql.Time;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author lifan
 * @date 2018/8/3 16:01
 * @email 2224779926@qq.com
 * @desc
 */
@Entity
public class UnlineOrder {

    private int id_order;
    private String appoint_time;
    private String order_time;
    private int id_user;
    private int id_doctor;
    @Generated(hash = 1068076527)
    public UnlineOrder(int id_order, String appoint_time, String order_time,
            int id_user, int id_doctor) {
        this.id_order = id_order;
        this.appoint_time = appoint_time;
        this.order_time = order_time;
        this.id_user = id_user;
        this.id_doctor = id_doctor;
    }
    @Generated(hash = 442629919)
    public UnlineOrder() {
    }
    public int getId_order() {
        return this.id_order;
    }
    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
    public String getAppoint_time() {
        return this.appoint_time;
    }
    public void setAppoint_time(String appoint_time) {
        this.appoint_time = appoint_time;
    }
    public String getOrder_time() {
        return this.order_time;
    }
    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
    public int getId_user() {
        return this.id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public int getId_doctor() {
        return this.id_doctor;
    }
    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }
}
