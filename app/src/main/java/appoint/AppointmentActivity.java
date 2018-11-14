package appoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import appoint.adapter.HospitalAdapter;
import appoint.entity.Hospital;
import appoint.utils.JsonParser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.Preferences;
import greendao.DatabaseUtils;
import main.SearchActivity;
import msg.MsgActivity;
import user.LoginActivity;

/**
 * Created by lenovo on 2018/4/18.
 */

public class AppointmentActivity extends Activity {


    @BindView(R.id.search_image)
    ImageView searchImage;
    @BindView(R.id.appointment_listView)
    ListView appointmentListView;
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;

    private ListView mListView;

    private HospitalAdapter adapter;
    private List<Hospital> hospitals;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (hospitals != null) {
                        adapter = new HospitalAdapter(hospitals, AppointmentActivity.this);
                        mListView.setAdapter(adapter);
                    }
                    break;
            }
        }

        ;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint);
        ButterKnife.bind(this);
        tvTitle.setText("预约挂号");
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
        initView();
        initListView();
    }

    private void initView() {
        mListView = findViewById(R.id.appointment_listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Hospital item = (Hospital) adapter.getItem(position);
                Intent intent = new Intent(AppointmentActivity.this, HospitalActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("name", item.getName());
                intent.putExtra("score", item.getScore());
                intent.putExtra("address", item.getAddress());
                intent.putExtra("grade", item.getGrade()).putExtra("imageurl", item.getImageurl());
                startActivity(intent);

            }
        });


    }



    private void initListView() {
        hospitals = new ArrayList<>();
        hospitals = DatabaseUtils.getDaoSession(AppointmentActivity.this).getHospitalDao().loadAll();
        if (hospitals.size() == 0) {
            RequestQueue mQueue = Volley.newRequestQueue(AppointmentActivity.this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://120.79.241.203:8080/GoHospital/getRecommendHosp",
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray jsonArray) {


                            hospitals = JsonParser.jsonToHospitals(jsonArray.toString());

                            mHandler.sendEmptyMessage(0);
                            DatabaseUtils.getDaoSession(AppointmentActivity.this).getHospitalDao().insertOrReplaceInTx(hospitals);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {

                    Log.e("TAG", volleyError.getMessage(), volleyError);
                }
            });
            mQueue.add(jsonArrayRequest);

        } else {
            mHandler.sendEmptyMessage(0);
        }

    }

    @OnClick({R.id.layout_return, R.id.iv_msg, R.id.search_image,R.id.tv_msg_num})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.layout_return:
                finish();
                break;
            case R.id.search_image:
                Intent intent = new Intent(AppointmentActivity.this, SearchActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                break;
            case R.id.iv_msg:
            case R.id.tv_msg_num:
                Toast.makeText(AppointmentActivity.this,"消息",Toast.LENGTH_SHORT);
                break;

            default:break;

        }
    }
    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(this, MsgActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
