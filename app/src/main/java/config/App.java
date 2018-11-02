package config;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.MainActivity;


/**
 * @author lifan
 * @date 2018/10/15 21:42
 * @email 2224779926@qq.com
 * @desc
 */

public class App extends Application{

    public static int H;
    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    public static String RemoteUrl = "http://120.79.241.203:8080/GoHospital/";
    public static String LocalUrl = "http://192.168.43.59:8080/";
    public static String testHttpUrl =LocalUrl;

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.getInstance(getApplicationContext());
    }




}

