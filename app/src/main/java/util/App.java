package util;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.example.life.R;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void onCreate() {
        super.onCreate();

        initBanner();
    }

    private void initBanner() {
        H = getScreenH(this);

        /**
         * Recovery.getInstance()
         .debug(true)
         .recoverInBackground(false)
         .recoverStack(true)
         .mainPage(MainActivity.class)
         .init(this);
         */


        //String[] urls = getResources().getStringArray(R.array.url4);
        //String[] tips = getResources().getStringArray(R.array.title);
        //List list = Arrays.asList(urls);
        //images = new ArrayList<>(list);
        //titles= Arrays.asList(tips);
    }

    /**
     * 获取屏幕高度
     * @param aty
     * @return
     */
    public int getScreenH(Context aty){
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}

