package config;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.life.R;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.StatusBarNotificationConfig;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.util.NIMUtil;

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

    public static String RemoteUrl = "http://120.79.241.203:8080/GoHospital/";
    public static String LocalUrl = RemoteUrl;
    //"http://192.168.43.59:8080/"
    public static String testHttpUrl =LocalUrl;

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.getInstance(getApplicationContext());
        NIMClient.init(this, null,options());
        if(NIMUtil.isMainProcess(this)){
            NimUIKit.init(this);
        }
        loginInfo();
    }
    // 如果返回值为 null，则全部使用默认参数。
    private SDKOptions options() {
        SDKOptions options = new SDKOptions();

        // 如果将新消息通知提醒托管给 SDK 完成，需要添加以下配置。否则无需设置。
        StatusBarNotificationConfig config = new StatusBarNotificationConfig();
        config.notificationEntrance = MainActivity.class; // 点击通知栏跳转到该Activity
        config.notificationSmallIconId = R.drawable.addimg_1x;
        // 呼吸灯配置
        config.ledARGB = Color.GREEN;
        config.ledOnMs = 1000;
        config.ledOffMs = 1500;
        // 通知铃声的uri字符串
        //config.notificationSound = "android.resource://com.netease.nim.demo/raw/msg";
        options.statusBarNotificationConfig = config;

        // 配置保存图片，文件，log 等数据的目录
        // 如果 options 中没有设置这个值，SDK 会使用采用默认路径作为 SDK 的数据目录。
        // 该目录目前包含 log, file, image, audio, video, thumb 这6个目录。
        //String sdkPath = getAppCacheDir(context) + "/nim"; // 可以不设置，那么将采用默认路径
        // 如果第三方 APP 需要缓存清理功能， 清理这个目录下面个子目录的内容即可。
        //options.sdkStorageRootPath = sdkPath;

        // 配置是否需要预下载附件缩略图，默认为 true
        options.preloadAttach = true;

        // 配置附件缩略图的尺寸大小。表示向服务器请求缩略图文件的大小
        // 该值一般应根据屏幕尺寸来确定， 默认值为 Screen.width / 2
        options.thumbnailSize = 480/ 2;


        return options;
    }
    // 如果已经存在用户登录信息，返回LoginInfo，否则返回null即可
    private void loginInfo() {
       if(Preferences.getInstance().getLoginInfo()!=null){
           user.util.Utils.loginIM(Preferences.getInstance().getLoginInfo().getAccount());
       }
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }




}

