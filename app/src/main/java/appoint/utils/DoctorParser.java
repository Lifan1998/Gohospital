package appoint.utils;

import java.util.ArrayList;
import java.util.List;

import appoint.entity.Doctor;

/**
 * Created by lenovo on 2018/4/18.
 */

public class DoctorParser {
    private static List<Doctor> doctors;

    public static  List<Doctor> getDoctors(){
        doctors = new ArrayList<>();
        Doctor doctor = null;
        for(int i=0;i<10;i++){
            doctor = new Doctor();
            doctor.name = "医生"+i;
            doctor.department = "眼科";
            doctors.add(doctor);
        }


        return doctors;
    }


}
