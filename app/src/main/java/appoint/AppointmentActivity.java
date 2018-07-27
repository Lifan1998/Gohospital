package appoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.life.R;

import java.util.List;

import appoint.adapter.HospitalAdapter;
import appoint.entity.Hospital;
import appoint.utils.HospitalParser;

/**
 * Created by lenovo on 2018/4/18.
 */

public class AppointmentActivity extends Activity implements View.OnClickListener {

    private ListView mListView;
    private ImageView returnImage;
    private HospitalAdapter adapter;
    private List<Hospital> hospitals;


    Handler mHandler  = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 10:
                    if(hospitals != null){
                        adapter = new HospitalAdapter(hospitals,AppointmentActivity.this);
                        mListView.setAdapter(adapter);
                    }
                    break;
            }
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint);

        initView();
    }

    private void initView() {
        mListView =  findViewById(R.id.appointment_listView);
        ImageView searchImage = findViewById(R.id.search_image);
        returnImage = findViewById(R.id.imgv_leftbtn) ;
        returnImage.setOnClickListener(this);
        searchImage.setOnClickListener(this);

        new Thread(){
            public void run() {
                hospitals = HospitalParser.getHospitals();

                mHandler.sendEmptyMessage(10);
            };
        }.start();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Hospital item = (Hospital) adapter.getItem(position);
                Intent intent  = new Intent();
                intent.putExtra("id", item.id);
                setResult(0, intent);
                finish();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_image:
                startActivity(new Intent(AppointmentActivity.this, AppointSearchActivity.class));
                break;
            case R.id.imgv_leftbtn:
                finish();
                break;
        }

    }
}
