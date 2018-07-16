package my;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.Toast;

import com.example.life.R;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import my.widget.MyQRCodeDialog;
import my.widget.SolarSystemView;
import setting.SettingActivity;
import user.LoginActivity;

/**
 * Created by lenovo on 2018/3/8.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MyFragment extends Fragment implements View.OnClickListener{
private CircleImageView circleImageView;
   private boolean issign = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        initView(view);



        return view;
    }

    public void initView(View v){
        circleImageView = v.findViewById(R.id.profile_image);
        circleImageView.setOnClickListener(this);
        v.findViewById(R.id.iv_logo_setting).setOnClickListener(this);
        v.findViewById(R.id.iv_logo_zx).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.profile_image:
                if (issign){
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
}