package setting;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.Preferences;

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

    }

    @Override
    public void onClick(View v) {

    }

    @OnClick({R.id.tv_msg_num, R.id.iv_msg})
    public void startMessage() {

    }
    @OnClick(R.id.btn_logout)
    public void logout(){
        Preferences.getInstance(getApplicationContext()).deleteToken();
        finish();

    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }

}
