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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.util.NIMUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import appoint.adapter.DoctorAdapter;
import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.App;
import config.Preferences;
import greendao.DatabaseUtils;
import msg.MsgActivity;
import msg.MsgUtils;
import user.LoginActivity;

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
    private boolean online ;



    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dept);
        id_hos = getIntent().getIntExtra("id", 0);
        menzhen = getIntent().getStringExtra("menzhen");
        keshi = getIntent().getStringExtra("keshi");
        online = getIntent().getBooleanExtra("online",false);
        ButterKnife.bind(this);
        tvTitle.setText(menzhen);
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

        liDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               if(online){

                   if(!Preferences.getInstance().isSign()){
                       Toast.makeText(getApplicationContext(),"您还未登录",Toast.LENGTH_SHORT).show();
                       return;
                   }
                   //1为医生，0为用户
                   final int flag = 1;
                   RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
                   String httpurl = App.LocalUrl+"getInfoById?id="+doctors.get(position).getId()+
                           "&flag="+flag;
                   Log.v("LoginActivity",httpurl);
                   StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                           new Response.Listener<String>() {
                               @Override
                               public void onResponse(String response) {
                                   Log.v(getClass().getName(),"response:"+response.toString());
                                   try {
                                       JSONObject jsonObject = new JSONObject(response.toString());
                                       JSONObject jsonObject0 = jsonObject.getJSONObject("model");
                                       JSONObject jsonObject1 = jsonObject0.getJSONObject("doctor");

                                        String account = jsonObject1.getString("dTel");
                                       MsgUtils.addFriend(account);
                                       //打开单聊界面
                                       NimUIKit.startP2PSession(getApplicationContext(), account);

                                       Log.v("DeptActivity",jsonObject1.toString());


                                   } catch (JSONException e) {
                                       e.printStackTrace();
                                   }
                                   finish();

                               }
                           }, new Response.ErrorListener() {
                       @Override
                       public void onErrorResponse(VolleyError volleyError) {
                           Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
                       }
                   });
                   mQueue.add(stringRequest);





                   //先直接添加好友


               } else {
                   Doctor doctor = (Doctor) adapter.getItem(position);
                   Intent intent = new Intent(DeptActivity.this, DoctorActivity.class);
                   intent.putExtra("id", doctor.getId());
                   intent.putExtra("menzhen", menzhen);
                   intent.putExtra("keshi", keshi);
                   startActivity(intent);
               }



            }
        });
    }

    private void initListView() {
        doctors = new ArrayList<>();
        String httpUrl = App.RemoteUrl+"getDocByDept?hId=" + id_hos + "&hDept=" + keshi + "&hRoom=" + menzhen;
        if(getIntent().getBooleanExtra("online",false)){
            getIntent().getStringExtra("onlineKey");
            httpUrl = App.LocalUrl+"getDocByDeptOnlyTwo?hDept="+getIntent().getStringExtra("onlineKey");
        }
        //条件查询从本地数据库中读取数据
        //doctors = DatabaseUtils.getDaoSession(DeptActivity.this).getDoctorDao().loadAll();
        if (doctors.size() == 0) {
            RequestQueue mQueue = Volley.newRequestQueue(DeptActivity.this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpUrl,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray jsonArray) {
                            //获取条件医生（医院id,门诊）

                            doctors = JsonParser.jsonToDoctors(jsonArray.toString());
                            Log.v("DeptActivity", doctors.toString());
                            //刷新list
                            mHandler.sendEmptyMessage(0);
                            //DatabaseUtils.getDaoSession(DeptActivity.this).getDoctorDao().insertOrReplaceInTx(doctors);
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
    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(this, MsgActivity.class));
        } else {
            startActivity(new Intent(this,LoginActivity.class));
        }

    }

}
