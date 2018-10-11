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

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import appoint.utils.OtherUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import greendao.DatabaseUtils;

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
    @BindView(R.id.confirm)
    TextView confirm;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint_confirm);
        ButterKnife.bind(this);
        initView();
        Log.v("TAG",getIntent().getIntExtra("id",0)+"");

    }

    private void initView() {
        tvAppointTime.setText(getIntent().getStringExtra("time"));
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = confirmName.getText().toString();
                String tele = confirmTele.getText().toString();
                String id = confirmId.getText().toString();
                Toast.makeText(ConfirmActivity.this, "预约成功", Toast.LENGTH_SHORT);
            }
        });


        RequestQueue mQueue = Volley.newRequestQueue(ConfirmActivity.this);
        //doctor = DatabaseUtils.getDaoSession(DoctorActivity.this).getDoctorDao().queryBuilder().where(DoctorDao.Properties.Id.eq(id_doctor)).build().unique();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://120.79.241.203:8080/GoHospital/getDocById?dId=" + getIntent().getIntExtra("id",0), null,
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
                            itemDoctorHospital.setText(OtherUtils.getHospitalName(getIntent().getIntExtra("id",0)));

                        }


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
    }
}




