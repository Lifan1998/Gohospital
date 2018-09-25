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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import appoint.adapter.DoctorAdapter;
import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import greendao.DatabaseUtils;

/**
 * @author lifan
 * @date 2018/8/4 1:05
 * @email 2224779926@qq.com
 * @desc
 */

public class DeptActivity extends Activity {

    @BindView(R.id.li_doctors)
    ListView liDoctors;
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;

    private List<Doctor> doctors;
    private int id_hos;
    private DoctorAdapter adapter;
    private String menzhen;
    private String keshi;


    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dept);
        id_hos = getIntent().getIntExtra("id", 0);
        menzhen = getIntent().getStringExtra("menzhen");
        keshi = getIntent().getStringExtra("keshi");
        ButterKnife.bind(this);
        tvTitle.setText(menzhen);
        tvMsgNum.setVisibility(View.INVISIBLE);
        initView();
        initListView();

    }

    private void initView() {

        liDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Doctor doctor = (Doctor) adapter.getItem(position);
                Intent intent = new Intent(DeptActivity.this, DoctorActivity.class);
                intent.putExtra("id", doctor.getId());
                startActivity(intent);


            }
        });
    }

    private void initListView() {
        doctors = new ArrayList<>();
        //条件查询从本地数据库中读取数据
        doctors = DatabaseUtils.getDaoSession(DeptActivity.this).getDoctorDao().loadAll();
        if (doctors.size() == 0) {
            RequestQueue mQueue = Volley.newRequestQueue(DeptActivity.this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://120.79.241.203:8080/GoHospital/getDocByDept?hId=" + id_hos + "&hDept=" + keshi + "&hRoom=" + menzhen,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            //获取条件医生（医院id,门诊）

                            doctors = JsonParser.jsonToDoctors(jsonArray.toString());
                            Log.v("DeptActivity", doctors.toString());
                            //刷新list
                            mHandler.sendEmptyMessage(0);
                            DatabaseUtils.getDaoSession(DeptActivity.this).getDoctorDao().insertOrReplaceInTx(doctors);
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

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (doctors != null) {
                        adapter = new DoctorAdapter(doctors, DeptActivity.this);
                        liDoctors.setAdapter(adapter);
                    }
                    break;

            }
        }


    };
    @OnClick(R.id.layout_return)
    public void OnClicked1(){
        finish();
    }

}
