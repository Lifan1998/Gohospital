package setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.KotlinAboutActivity;
import com.example.life.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;
import com.netease.nimlib.sdk.msg.MsgService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.Preferences;
import init.MyUtils;
import init.VersionUpdateUtils;
import main.MainActivity;
import msg.MsgActivity;
import user.LoginActivity;

import static android.content.Context.*;

/**
 * Created by lenovo on 2018/7/11.
 */

public class SettingActivity extends Activity implements OnClickListener {
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.btn_about)
    TextView btnAbout;
    @BindView(R.id.btn_complain)
    TextView btnComplain;
    @BindView(R.id.btn_update)
    TextView btnUpdate;
    @BindView(R.id.btn_destroy)
    TextView btnDestroy;
    @BindView(R.id.btn_logout)
    TextView btnLogout;

    /** 本地版本号 */
    private String mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
        tvTitle.setText("设置");
    }

    private void initView() {
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
    }

    @Override
    public void onClick(View v) {

    }

    @OnClick({R.id.btn_logout,R.id.btn_destroy})
    public void logout(){
        if(!Preferences.getInstance().isSign()){
            Toast.makeText(getApplicationContext(),"您还未登录",Toast.LENGTH_SHORT).show();
            return;
        }
        NIMClient.getService(AuthService.class).logout();
        Preferences.getInstance(getApplicationContext()).deleteToken();
        Preferences.getInstance().deleteAccount();
        Toast.makeText(getApplicationContext(),"退出账号成功",Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }
    @OnClick(R.id.btn_update)
    public void  setBtnUpdate(){
        mVersion = MyUtils.getVersion(SettingActivity.this);
        final VersionUpdateUtils updateUtils = new VersionUpdateUtils(mVersion,
                SettingActivity.this);
        new Thread() {
            @Override
            public void run() {
                // 获取服务器版本号
                updateUtils.getCloudVersion();
            }
        }.start();
        finish();

    }

    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(this, MsgActivity.class));
        } else {
            startActivity(new Intent(this,LoginActivity.class));
        }

    }

    @OnClick(R.id.btn_complain)
    public void setBtnComplain(){

    }

    @OnClick(R.id.btn_about)
    public void setBtnAbout(){
        startActivity(new Intent(this, KotlinAboutActivity.class));
    }



}
