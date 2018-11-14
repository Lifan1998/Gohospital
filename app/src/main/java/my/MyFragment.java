package my;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;


import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nim.uikit.api.NimUIKit;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import config.App;
import config.Preferences;
import de.hdodenhof.circleimageview.CircleImageView;
import msg.MsgUtils;
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

    private User user =new User();

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
            getUser(Preferences.getInstance().getToken());

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
                    intent.putExtra("user",user);
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
                if(!Preferences.getInstance().isSign()){
                    Toast.makeText(getContext(),"您还未登录",Toast.LENGTH_SHORT).show();
                    return;
                }
                MyQRCodeDialog dialog = new MyQRCodeDialog(getActivity());
                dialog.show();
                break;

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
    private void getUser(String token) {

        //1为医生，0为用户
        final int flag = 0;
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        String httpurl = App.LocalUrl+"getInfoByToken?token="+Preferences.getInstance().getToken()+
                "&flag="+flag;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = JSON.parseObject(response);
                            JSONObject jsonObject0 = jsonObject.getJSONObject("model");
                            JSONObject jsonObject1 = jsonObject0.getJSONObject("user");
                            tvUsername.setText(jsonObject1.getString("uName"));
                            user.setName(jsonObject1.getString("name"));
                            user.setuAge(jsonObject1.getString("uAge"));
                            user.setuEmail(jsonObject1.getString("uEmail"));
                            user.setuSex(jsonObject1.getString("uSex"));
                            user.setuName(jsonObject1.getString("uName"));
                            user.setuTel(jsonObject1.getString("uTel"));
                            Log.v("MyFragment",user.toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
            }
        });
        mQueue.add(stringRequest);

    }

    @OnClick({R.id.my_appoint,R.id.my_love,R.id.my_ask})
    public void startMyLove(LinearLayout linearLayout) {
        if(!Preferences.getInstance().isSign()){
            Toast.makeText(getContext(),"您还未登录",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent =  new Intent(getActivity(), MyLoveActivity.class);
        switch (linearLayout.getId()){
            case R.id.my_appoint:intent.putExtra("type",1);break;
            case R.id.my_love:intent.putExtra("type",2);break;
            case R.id.my_ask:intent.putExtra("type",3);break;
        }
        startActivity(intent);
    }

}