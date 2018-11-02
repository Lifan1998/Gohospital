package config;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author lifan
 * @date 2018/10/30 18:58
 * @email 2224779926@qq.com
 * @desc
 */

public class Preferences {
    private  Context context;
    private static Preferences preferences;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Preferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("base", 0);
        editor = sharedPreferences.edit();
    }

    public Preferences() {

    }


    public String getToken(){
        return sharedPreferences.getString("token","1");
    }
    public  boolean setToken(String token){
        editor.putString("token",token);
        editor.commit();
        return true;
    }
    public  boolean deleteToken(){
        editor.remove("token");
        editor.commit();
        return true;
    }
    public  boolean isSign(){
        if (getToken()==""|getToken()=="1"){
            return false;
        } else {
            return true;
        }

    }
    public static Preferences getInstance(Context context){
        if(preferences==null){
            preferences = new Preferences(context);
        }
        return preferences;
    }
    public static Preferences getInstance(){
        if(preferences==null){
            preferences = new Preferences();
        }
        return preferences;
    }

}
