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

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import appoint.adapter.DeptAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.CollectionUtils;

/**
 * @author lifan
 * @date 2018/8/1 15:24
 * @email 2224779926@qq.com
 * @desc
 */

public class HospitalActivity extends Activity {

    @BindView(R.id.item_hospital_view)
    ImageView itemHospitalView;
    @BindView(R.id.item_hospital_name)
    TextView itemHospitalName;
    @BindView(R.id.item_hospital_grade)
    TextView itemHospitalGrade;
    @BindView(R.id.item_hospital_address)
    TextView itemHospitalAddress;
    @BindView(R.id.item_hospital_score)
    TextView itemHospitalScore;
    @BindView(R.id.li_keshi)
    ListView liKeshi;
    @BindView(R.id.li_menzhen)
    ListView liMenzhen;
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.iv_love)
    ImageView ivLove;

    private List<String> strs0;
    private List<String> strs1;
    private DeptAdapter adapter0, adapter1;
    private int id_hos;
    private String keshi;


    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hospital);
        id_hos = getIntent().getIntExtra("id", id_hos);
        ButterKnife.bind(this);
        tvTitle.setText(getIntent().getStringExtra("name"));
        tvMsgNum.setVisibility(View.INVISIBLE);
        ivLove.setVisibility(View.VISIBLE);
        initView();
        initKeshi();


    }

    private void initView() {
        itemHospitalAddress.setText(getIntent().getStringExtra("address"));
        itemHospitalGrade.setText(getIntent().getStringExtra("grade"));
        itemHospitalName.setText(getIntent().getStringExtra("name"));
        itemHospitalScore.setText(getIntent().getStringExtra("score"));


        liKeshi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                adapter0.setSelectSelection(position);
                keshi = (String) adapter0.getItem(position);
                initMenZhen();

            }
        });

        liMenzhen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String str = (String) adapter1.getItem(position);
                Intent intent = new Intent(HospitalActivity.this, DeptActivity.class);
                intent.putExtra("id", id_hos);
                intent.putExtra("menzhen", str);
                intent.putExtra("keshi", keshi);
                startActivity(intent);


            }
        });


    }

    private void initKeshi() {
        RequestQueue mQueue = Volley.newRequestQueue(HospitalActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://120.79.241.203:8080/GoHospital/getHospdept?hId=" + id_hos,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.v("HospitalActivity", jsonArray.toString());
                        strs0 = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                String s = (String) jsonArray.get(i);
                                strs0.add(s);
                                Log.v("HospitalActivity", s);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mHandler.sendEmptyMessage(0);
                        if (strs0.size() != 0) {
                            keshi = strs0.get(0);
                            initMenZhen();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        }) {

        };

        mQueue.add(jsonArrayRequest);
    }

    private void initMenZhen() {
        RequestQueue mQueue = Volley.newRequestQueue(HospitalActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://120.79.241.203:8080/GoHospital/getHospdeptRoom?hId=" + id_hos + "&hDept=" + keshi,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        strs1 = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                String s = (String) jsonArray.get(i);
                                strs1.add(s);
                                Log.v("HospitalActivity", s);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                        mHandler.sendEmptyMessage(1);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e("TAG", volleyError.getMessage(), volleyError);
            }

        }) {

        };
        mQueue.add(jsonArrayRequest);


    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (strs0 != null) {
                        adapter0 = new DeptAdapter(strs0, HospitalActivity.this);
                        liKeshi.setAdapter(adapter0);
                        adapter0.setSelectSelection(0);
                    }
                    break;

                case 1:
                    if (strs1 != null) {
                        adapter1 = new DeptAdapter(strs1, HospitalActivity.this);
                        liMenzhen.setAdapter(adapter1);
                    }
                    break;

            }
        }

        ;
    };

    @OnClick({R.id.layout_return, R.id.iv_msg, R.id.tv_msg_num})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.layout_return:
                finish();
                break;

            case R.id.iv_msg:
            case R.id.tv_msg_num:
                Toast.makeText(HospitalActivity.this, "消息", Toast.LENGTH_SHORT);
                break;

            default:
                break;

        }
    }

    /**
     * 是否收藏
     */
    @OnClick(R.id.iv_love)
    public void selectLove(){
        if(ivLove.isSelected()){
            ivLove.setSelected(false);
            CollectionUtils.collection(getApplicationContext(),CollectionUtils.FLAG_HOSPITAL,id_hos,0);

        }else{
            ivLove.setSelected(true);
            CollectionUtils.collection(getApplicationContext(),CollectionUtils.FLAG_HOSPITAL,id_hos,1);

        }
    }
}
