package appoint.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 *
 */
@Entity
public class Doctor {

    /**
     *
     */

        private int id;
        private String imageurl;
        private String name;
        private int id_hospital;
        private String department;
        private String group;
        private String grade;
        private String score;
        private String desc;
        private String scheduing;

        @Generated(hash = 278297808)
        public Doctor(int id, String imageurl, String name, int id_hospital,
                String department, String group, String grade, String score,
                String desc, String scheduing) {
            this.id = id;
            this.imageurl = imageurl;
            this.name = name;
            this.id_hospital = id_hospital;
            this.department = department;
            this.group = group;
            this.grade = grade;
            this.score = score;
            this.desc = desc;
            this.scheduing = scheduing;
        }
        @Generated(hash = 73626718)
        public Doctor() {
        }
        public int getId() {
            return this.id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getId_hospital() {
            return this.id_hospital;
        }
        public void setId_hospital(int id_hospital) {
            this.id_hospital = id_hospital;
        }
        public String getDepartment() {
            return this.department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getGroup() {
            return this.group;
        }
        public void setGroup(String group) {
            this.group = group;
        }
        public String getGrade() {
            return this.grade;
        }
        public void setGrade(String grade) {
            this.grade = grade;
        }
        public String getScore() {
            return this.score;
        }
        public void setScore(String score) {
            this.score = score;
        }
        public String getDesc() {
            return this.desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getScheduing() {
            return this.scheduing;
        }
        public void setScheduing(String scheduing) {
            this.scheduing = scheduing;
        }
        public String getImageurl() {
            return this.imageurl;
        }
        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        

}
