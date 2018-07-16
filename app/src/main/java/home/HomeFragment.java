package home;


import android.app.Activity;
import android.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;


import com.example.life.R;

import appoint.AppointmentActivity;

import home.adapter.*;

/**
 * Created by lenovo on 2018/4/18.
 */

public class HomeFragment  extends Fragment implements View.OnClickListener{

private GridView gridView;
private home.adapter.GridAdapter adapter;


    Handler mHandler  = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 10:

                        adapter = new GridAdapter(getActivity());
                        gridView.setAdapter(adapter);

                    break;
            }
        };
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
       ImageView appointImage = view.findViewById(R.id.appointimage) ;
       appointImage.setOnClickListener( this);

        gridView = view.findViewById(R.id.gv_home);


        initView();
        return view;
    }
    public void initView(){
        new Thread(){
            public void run() {
                mHandler.sendEmptyMessage(10);
            };
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.appointimage:
                Activity context = getActivity();
                context.startActivity(new Intent(context, AppointmentActivity.class));
                break;
        }

    }
}

