package appoint;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognizerIntent;
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
import android.widget.Toast;

import com.example.life.R;
import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;

import java.util.ArrayList;
import java.util.List;

import appoint.adapter.DoctorAdapter;
import appoint.adapter.HospitalAdapter;
import appoint.entity.Doctor;
import appoint.entity.Hospital;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/4/18.
 *
 * @author lifan
 */

public class AppointSearchActivity extends Activity implements View.OnClickListener {


    @BindView(R.id.li_search_hospital)
    ListView liSearchHospital;
    @BindView(R.id.li_search_doctor)
    ListView liSearchDoctor;
    private ImageView returnImage;
    private TextView textView;
    private EditText editText;
    private DoctorAdapter doctorAdapter;
    private HospitalAdapter hospitalAdapter;
    private List<Doctor> doctors;
    private List<Hospital> hospitals;
    private Button btn_clear;

    private SearchBox search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint_search);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        textView = findViewById(R.id.tv_search);
        textView.setOnClickListener(this);
        search = (SearchBox) findViewById(R.id.searchbox);
        search.enableVoiceRecognition(this);
        for(int x = 0; x < 10; x++){
            SearchResult option = new SearchResult("Result " + Integer.toString(x), getResources().getDrawable(R.drawable.bg_num));
            search.addSearchable(option);
        }
        search.setLogoText("My App");
        //search.setLogoTextColor(Color.parse("#000000"));
        search.revealFromMenuItem(R.id.item_keshi, this);
        new SearchResult("Title", getResources().getDrawable(R.drawable.doctor_null));

        search.setMenuListener(new SearchBox.MenuListener(){

            @Override
            public void onMenuClick() {
                //Hamburger has been clicked
                Toast.makeText(AppointSearchActivity.this, "Menu click", Toast.LENGTH_LONG).show();
            }

        });
        search.setSearchListener(new SearchBox.SearchListener(){

            @Override
            public void onSearchOpened() {
                //Use this to tint the screen
            }

            @Override
            public void onSearchClosed() {
                //Use this to un-tint the screen
            }

            @Override
            public void onSearchTermChanged(String s) {
                //React to the search term changing
                //Called after it has updated results
            }

            @Override
            public void onSearch(String searchTerm) {
                Toast.makeText(AppointSearchActivity.this, searchTerm +" Searched", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onResultClick(SearchResult result){
                //React to a result being clicked
            }


            @Override
            public void onSearchCleared() {

            }

        });


        editText = findViewById(R.id.appoint_searchedit);
        btn_clear = findViewById(R.id.btn_appoint_search_clear);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String user = editText.getText().toString().trim();
                if ("".equals(user)) {
                    btn_clear.setVisibility(View.INVISIBLE);
                } else {
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
        returnImage = findViewById(R.id.return_image);
        returnImage.setOnClickListener(this);

        liSearchDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doctor doctor = (Doctor)doctorAdapter.getItem(position);
                Intent intent = new Intent(AppointSearchActivity.this,DoctorActivity.class);
                intent.putExtra("id",doctor.getId());
                startActivity(intent);
                finish();

            }
        });
        liSearchHospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hospital item = (Hospital)hospitalAdapter.getItem(position);
                Intent intent  = new Intent(AppointSearchActivity.this,HospitalActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("name",item.getName());
                intent.putExtra("score",item.getScore());
                intent.putExtra("address",item.getAddress());
                intent.putExtra("grade",item.getGrade()).putExtra("imageurl",item.getImageurl());
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:

                new Thread() {
                    @Override
                    public void run() {
                        doctors = searchDoctors(editText.getText().toString());
                        mHandler.sendEmptyMessage(0);
                        hospitals = searchHospiatls(editText.getText().toString());
                        mHandler.sendEmptyMessage(1);
                    }

                    ;
                }.start();


                editText.setFocusable(false);
                break;
            case R.id.return_image:
                finish();
                break;
            case R.id.btn_appoint_search_clear:
                editText.setText("");
                break;
            case R.id.appoint_searchedit:
                editText.setFocusable(true);

                break;
            default:
                break;
        }

    }

    private ArrayList<Hospital> searchHospiatls(String s) {
        return null;
    }

    private ArrayList<Doctor> searchDoctors(String s) {
        return null;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (doctors != null) {
                        doctorAdapter = new DoctorAdapter(doctors, AppointSearchActivity.this);
                       liSearchDoctor.setAdapter(doctorAdapter);
                    }
                    break;
                case 1:
                    if (hospitals != null) {
                        hospitalAdapter = new HospitalAdapter(hospitals, AppointSearchActivity.this);
                        liSearchHospital.setAdapter(hospitalAdapter);
                    }
                default:
                    break;
            }
        }

        ;
    };


}
