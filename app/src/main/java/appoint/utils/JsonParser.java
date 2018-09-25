package appoint.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import appoint.entity.Doctor;
import appoint.entity.Hospital;

/**
 * @author lifan
 * @date 2018/8/4 16:59
 * @email 2224779926@qq.com
 * @desc
 */

public  class JsonParser {


    public static List<Hospital> jsonToHospitals(String json){
        List<Hospital> hospitals = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++){
                Hospital hospital = new Hospital();
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                Log.v("JsonParser",jsonObject.toString());

                hospital.setAddress(jsonObject.getString("haddr"));

                hospital.setGrade(jsonObject.getString("htype"));
                hospital.setImageurl(jsonObject.getString("hpic"));
                hospital.setId(jsonObject.getInt("hid"));
                hospital.setName(jsonObject.getString("hname"));
                hospital.setScore(Double.toString(jsonObject.getDouble("hscore")));
                hospitals.add(hospital);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    public static ArrayList<Doctor> jsonToDoctors(String json){
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            Log.v("JsonParser", jsonArray.toString());
            for (int i=0;i<jsonArray.length();i++) {
                Doctor doctor = new Doctor();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Log.v("JsonParser", jsonObject.toString());

                doctor.setDepartment(jsonObject.getString("hdept"));
                doctor.setName(jsonObject.getString("dname"));
                doctor.setDesc(jsonObject.getString("dintroduction"));
                doctor.setGrade(jsonObject.getString("htype"));
                doctor.setGroup(jsonObject.getString("hroom"));
                doctor.setId(jsonObject.getInt("did"));
                doctor.setId_hospital(jsonObject.getInt("hid"));
                doctor.setImageurl(jsonObject.getString("dpic"));
                doctor.setScheduing("");
                doctor.setScore(String.valueOf(jsonObject.getDouble("dscore")));

                Log.v("JsonParser", jsonObject.toString());

                doctors.add(doctor);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static Doctor jsonToDoctor(String json){
        Doctor doctor = new Doctor();


        try {
            JSONObject jsonObject = new JSONObject(json);
            doctor.setDepartment(jsonObject.getString("hdept"));
            doctor.setName(jsonObject.getString("dname"));
            doctor.setDesc(jsonObject.getString("dintroduction"));
            doctor.setGrade(jsonObject.getString("htype"));
            doctor.setGroup(jsonObject.getString("hroom"));
            doctor.setId(jsonObject.getInt("did"));
            doctor.setId_hospital(jsonObject.getInt("hid"));
            doctor.setImageurl(jsonObject.getString("dpic"));
            doctor.setScheduing("");
            doctor.setScore(String.valueOf(jsonObject.getDouble("dscore")));
            Log.v("JsonParser", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    public static List<String> jsonToTimes(String json){
        List<String> times = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            Log.v("JsonParser", jsonArray.toString());
            for (int i=0;i<jsonArray.length();i++) {
                String str = (String) jsonArray.get(i);
                String time = null;
                times.add(str);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return times;
    }

}
