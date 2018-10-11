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
                String time = "";
                switch (str.substring(0,3)){
                    case "Mon": time += "星期一 ";break;
                    case "Tue": time += "星期二 ";break;
                    case "Wed": time += "星期三 ";break;
                    case "Thu": time += "星期四 ";break;
                    case "Fri": time += "星期五 ";break;
                    case "Sat": time += "星期六 ";break;
                    case "Sun": time += "星期天 ";break;

                }
                switch (str.substring(4,7)){
                    case "Jan": time += "1.";break;
                    case "Feb": time += "2.";break;
                    case "Mar": time += "3.";break;
                    case "Apr": time += "4.";break;
                    case "May": time += "5.";break;
                    case "Jun": time += "6.";break;
                    case "Jul": time += "7.";break;
                    case "Aug": time += "8.";break;
                    case "Sep": time += "9.";break;
                    case "Oct": time += "10.";break;
                    case "Nov": time += "11.";break;
                    case "Dec": time += "12.";break;

                }
                time +=str.substring(7,20)+"-";

                times.add(time);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return times;
    }

}
