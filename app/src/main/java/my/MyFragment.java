package my;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import config.Preferences;
import de.hdodenhof.circleimageview.CircleImageView;
import my.model.User;
import my.widget.MyQRCodeDialog;
import setting.SettingActivity;
import user.LoginActivity;

/**
 * Created by lenovo on 2018/3/8.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MyFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.my_appoint)
    LinearLayout myAppoint;
    @BindView(R.id.my_love)
    LinearLayout myLove;
    @BindView(R.id.my_ask)
    LinearLayout myAsk;
    Unbinder unbinder;
    @BindView(R.id.iv_logo_setting)
    ImageView ivLogoSetting;
    @BindView(R.id.iv_logo_zx)
    ImageView ivLogoZx;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.about_line)
    View aboutLine;
    private CircleImageView circleImageView;
    private boolean issign = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //issign = checkLogin();
        issign = Preferences.getInstance(getContext()).isSign();
        if (issign) {
            tvUsername.setText("会飞的猪");

        } else {
            tvUsername.setText("  登录/注册  ");
        }

    }

    public void initView(View v) {
        circleImageView = v.findViewById(R.id.profile_image);
        circleImageView.setOnClickListener(this);
        v.findViewById(R.id.iv_logo_setting).setOnClickListener(this);
        v.findViewById(R.id.iv_logo_zx).setOnClickListener(this);


    }


    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.profile_image:
                if (issign) {
                    Intent intent = new Intent(getActivity(), MyInforActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);

                }
                break;
            case R.id.iv_logo_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_logo_zx:
                MyQRCodeDialog dialog = new MyQRCodeDialog(getActivity());
                dialog.show();
                break;

        }
    }

    /**
     * 检查登录状态
     */
    private boolean checkLogin() {
        SharedPreferences settings = getActivity().getSharedPreferences("base", 0);
        String token = settings.getString("token", "");
        if (token.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 根据token获取用户信息
     */
    private User getUser(String token) {
        User user = new User();


        return user;
    }

    @OnClick({R.id.my_appoint,R.id.my_love,R.id.my_ask})
    public void startMyLove(LinearLayout linearLayout) {
        Intent intent =  new Intent(getActivity(), MyLoveActivity.class);
        switch (linearLayout.getId()){
            case R.id.my_appoint:intent.putExtra("type",1);break;
            case R.id.my_love:intent.putExtra("type",2);break;
            case R.id.my_ask:intent.putExtra("type",3);break;
        }
        startActivity(intent);
    }

}