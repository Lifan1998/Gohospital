package appoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;

import appoint.adapter.DoctorAdapter;
import appoint.entity.Doctor;
import appoint.utils.DoctorParser;

/**
 * Created by lenovo on 2018/4/18.
 */

public class AppointSearchActivity extends Activity implements View.OnClickListener{

    private ListView mListView;
    private ImageView returnImage;
    private TextView textView;
    private EditText editText;
    private DoctorAdapter adapter;
    private List<Doctor> doctors;
    private Button btn_clear;


    Handler mHandler  = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 10:
                    if(doctors != null){
                        adapter = new DoctorAdapter(doctors, AppointSearchActivity.this);
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
        setContentView(R.layout.activity_appoint_search);
        initView();
        mListView.setVisibility(View.INVISIBLE);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.doctor_listview);
        textView = (TextView)findViewById(R.id.tv_search) ;


        textView.setOnClickListener(this);


        new Thread(){
            public void run() {
                doctors = DoctorParser.getDoctors();

                mHandler.sendEmptyMessage(10);
            };
        }.start();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Doctor item = (Doctor) adapter.getItem(position);
                Intent intent  = new Intent();
                intent.putExtra("phone", item.department);
                setResult(0, intent);
                finish();
            }
        });

        editText = (EditText)findViewById(R.id.appoint_searchedit);
        btn_clear = (Button)findViewById(R.id.btn_appoint_search_clear);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
// 获得文本框中的用户
                String user =editText.getText().toString().trim();
                if ("".equals(user)) {
                // 用户名为空,设置按钮不可见
                    btn_clear.setVisibility(View.INVISIBLE);
                } else {
                // 用户名不为空，设置按钮可见
                    btn_clear.setVisibility(View.VISIBLE);

                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

        //返回
        returnImage = (ImageView)findViewById(R.id.return_image);
        returnImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_search :
                mListView.setVisibility(View.VISIBLE);
                editText.setFocusable(false);
                break;
            case R.id.return_image:
                finish();
                break;
            case R.id.btn_appoint_search_clear :
                editText.setText("");
                break;
            case R.id.appoint_searchedit:
                editText.setFocusable(true);
                mListView.setVisibility(View.INVISIBLE);
                break;
        }

    }
}
