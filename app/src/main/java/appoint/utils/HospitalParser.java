package appoint.utils;

import java.util.ArrayList;
import java.util.List;

import appoint.entity.Hospital;

/**
 * Created by lenovo on 2018/4/18.
 */

public class HospitalParser {
    private static List<Hospital> hospitals;

    public static List<Hospital> getHospitals(){
        hospitals = new ArrayList<>();
        Hospital hospital = null;

        for(int i=0;i<10;i++){
            hospital = new Hospital();
            hospital.grade = "三级甲等";
            hospital.name = "医院"+i;
            hospitals.add(hospital);
        }

        return hospitals;
    }
}
