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

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;

import appoint.adapter.DeptAdapter;
import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import butterknife.BindView;
import butterknife.ButterKnife;
import greendao.DatabaseUtils;
import greendao.DoctorDao;

/**
 * @author lifan
 * @date 2018/8/1 15:24
 * @email 2224779926@qq.com
 * @desc
 */

public class DoctorActivity extends Activity {

    @BindView(R.id.item_doctor_image)
    ImageView itemDoctorImage;
    @BindView(R.id.item_doctor_name)
    TextView itemDoctorName;
    @BindView(R.id.item_doctor_group)
    TextView itemDoctorGroup;
    @BindView(R.id.item_doctor_hospital)
    TextView itemDoctorHospital;
    @BindView(R.id.item_doctor_score)
    TextView itemDoctorScore;
    @BindView(R.id.item_doctor_grade)
    TextView itemDoctorGrade;
    @BindView(R.id.doctor_chat)
    LinearLayout doctorChat;
    @BindView(R.id.li_appoint_time)
    ListView liAppointTime;
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;


    private int id_doctor;
    private Doctor doctor;
    private DeptAdapter adapter;
    private List<String> times;
    ExpandableTextView expTv1;

    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_doctor);
        id_doctor = getIntent().getIntExtra("id", 0);
        expTv1 = findViewById(R.id.expand_text_view);


        ButterKnife.bind(this);


        initDoctor();
        initView();



    }

    private void initView() {
        initListView();
        liAppointTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String time = (String) adapter.getItem(position);
                Intent intent = new Intent(DoctorActivity.this, ConfirmActivity.class);
                intent.putExtra("time", time);
                intent.putExtra("id", id_doctor);

                startActivity(intent);

            }
        });

    }

    private void initDoctor() {

        RequestQueue mQueue = Volley.newRequestQueue(DoctorActivity.this);
        //doctor = DatabaseUtils.getDaoSession(DoctorActivity.this).getDoctorDao().queryBuilder().where(DoctorDao.Properties.Id.eq(id_doctor)).build().unique();
        if (doctor == null) {

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://120.79.241.203:8080/GoHospital/getDocById?dId=" + id_doctor, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("TAG", response.toString());
                            doctor = JsonParser.jsonToDoctor(response.toString());
                            tvTitle.setText(doctor.getName());
                            mHandler.sendEmptyMessage(1);
                            //储存起来
                            DatabaseUtils.getDaoSession(DoctorActivity.this).getDoctorDao().insert(doctor);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.e("TAG", error.getMessage(), error);

                }
            }) {
                @Override
                protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                    JSONObject jsonObject;
                    try {
                        jsonObject = new JSONObject(new String(response.data, "UTF-8"));
                        return Response.success(jsonObject, HttpHeaderParser.parseCacheHeaders(response));
                    } catch (UnsupportedEncodingException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    } catch (JSONException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                        return Response.error(new ParseError(e));
                    }
                    return null;

                }
            };

            mQueue.add(jsonObjectRequest);
        } else {
            mHandler.sendEmptyMessage(1);
        }


    }

    private void initListView() {
        final String str = null;
        RequestQueue mQueue = Volley.newRequestQueue(DoctorActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://120.79.241.203:8080/GoHospital/queryDoc?dId=" + id_doctor,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        times = JsonParser.jsonToTimes(jsonArray.toString());
                        mHandler.sendEmptyMessage(0);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(jsonArrayRequest);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (times != null) {

                        adapter = new DeptAdapter(times, DoctorActivity.this);
                        adapter.setFlag(1);
                        liAppointTime.setAdapter(adapter);
                    }
                    break;

                case 1:
                    if (doctor != null) {
                        itemDoctorGrade.setText(doctor.getGrade());
                        itemDoctorName.setText(doctor.getName());
                        itemDoctorGroup.setText(doctor.getGroup());
                        itemDoctorScore.setText(doctor.getScore());
                        expTv1.setText("简介："+doctor.getDesc());

                    }
                    break;
            }
        }

    };
}
