package appoint;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dd.CircularProgressButton;
import com.example.life.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import appoint.utils.OtherUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.App;
import config.Preferences;
import user.ForgetPassActivity;
import user.LoginActivity;
import user.RegisterActivity;

/**
 * @author lifan
 * @date 2018/8/4 1:07
 * @email 2224779926@qq.com
 * @desc
 */

public class ConfirmActivity extends Activity {


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
    @BindView(R.id.tv_appoint_time)
    TextView tvAppointTime;
    @BindView(R.id.confirm_name)
    EditText confirmName;
    @BindView(R.id.confirm_tele)
    EditText confirmTele;
    @BindView(R.id.confirm_id)
    EditText confirmId;
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.item_doctor_image)
    ImageView itemDoctorImage;



    private Doctor doctor;
    private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint_confirm);
        ButterKnife.bind(this);
        time = getIntent().getStringExtra("time");
        initView();



    }

    private void initView() {
        tvAppointTime.setText(time);


        RequestQueue mQueue = Volley.newRequestQueue(ConfirmActivity.this);
        //doctor = DatabaseUtils.getDaoSession(DoctorActivity.this).getDoctorDao().queryBuilder().where(DoctorDao.Properties.Id.eq(id_doctor)).build().unique();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://120.79.241.203:8080/GoHospital/getDocById?dId=" + getIntent().getIntExtra("id", 0), null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        doctor = JsonParser.jsonToDoctor(response.toString());
                        Log.v("TAG", doctor.getName());
                        if (doctor != null) {
                            tvTitle.setText(doctor.getName());
                            itemDoctorGrade.setText(doctor.getGrade());
                            itemDoctorName.setText(doctor.getName());
                            itemDoctorGroup.setText(doctor.getGroup());
                            itemDoctorScore.setText(doctor.getScore());
                            OtherUtils.getHospitalName(getIntent().getIntExtra("id", 0), ConfirmActivity.this,itemDoctorHospital);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(jsonObjectRequest);
    }

    @OnClick(R.id.btn_appoint_confirm)
    public void confirm(){
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        String httpurl = App.LocalUrl+"underline?token="+ Preferences.getInstance().getToken()+
                "&dId="+doctor.getId()+"&hId="+doctor.getId_hospital()+
                "&hDept="+doctor.getDepartment()+
                "&hRoom="+doctor.getGroup()+
                "&tel="+confirmTele.getText().toString()+
                "&identity="+confirmId.getText().toString()+
                "&name="+confirmName.getText().toString()+
                "&aType="+1+
                "&apTime="+time.substring(3,19)+":00";
        Log.v(ConfirmActivity.class.getSimpleName(),httpurl);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            boolean isSuccess = jsonObject1.getBoolean("isSuccess");
                            if(isSuccess){
                                Toast.makeText(getApplicationContext(),"预约成功",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(),"预约失败",Toast.LENGTH_SHORT).show();
                            }
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
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,0,0f));
        mQueue.add(stringRequest);
    }
}




