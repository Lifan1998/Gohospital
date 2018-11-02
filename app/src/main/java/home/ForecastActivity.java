package home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.App;

/**
 * @author lifan
 * @date 2018/9/25 23:03
 * @email 2224779926@qq.com
 * @desc
 */

public class ForecastActivity extends Activity {
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.tv_forecast_name)
    EditText tvForecastName;
    //————————————————————————————————————————————————————————————————————————————————————————————————-

    @BindView(R.id.tv_height)
    TextView tvHeight;
    @BindView(R.id.tv_weight)
    TextView tvWeight;


    @BindView(R.id.label_1_1)
    TextView label11;
    @BindView(R.id.label_1_2)
    TextView label12;
    @BindView(R.id.label_1_3)
    TextView label13;
    @BindView(R.id.label_1_4)
    TextView label14;



    @BindView(R.id.label_2_1)
    TextView label21;
    @BindView(R.id.label_2_2)
    TextView label22;



    @BindView(R.id.label_3_1)
    TextView label31;
    @BindView(R.id.label_3_2)
    TextView label32;



    @BindView(R.id.label_4_1)
    TextView label41;
    @BindView(R.id.label_4_2)
    TextView label42;
    @BindView(R.id.label_4_3)
    TextView label43;
    @BindView(R.id.label_4_4)
    TextView label44;



    @BindView(R.id.label_5_1)
    TextView label51;
    @BindView(R.id.label_5_2)
    TextView label52;
    @BindView(R.id.label_5_3)
    TextView label53;



    @BindView(R.id.tv_smoke_num)
    TextView tvSmokeNum;
    @BindView(R.id.tv_smoke_year)
    TextView tvSmokeYear;


    @BindView(R.id.label_6_1)
    TextView label61;
    @BindView(R.id.label_6_2)
    TextView label62;

    @BindView(R.id.label_7_1)
    TextView label71;
    @BindView(R.id.label_7_2)
    TextView label72;

    @BindColor(R.color.text_white)
    int white;
    @BindColor(R.color.text_blue)
    int blue;
    @BindColor(R.color.brank)
    int brank;
    @BindColor(R.color.qmui_config_color_gray_9)
    int gray;

    @BindView(R.id.btn_forecast)
    TextView btnForecast;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.tv_height1)
    TextView tvHeight1;
    @BindView(R.id.tv_bmi)
    TextView tvBmi;

    TextView[] tv1,tv2,tv3,tv4,tv6,tv5,tv7;


    private String[] selected;

    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);
        tvTitle.setText("健康评估");
        tv5 = new TextView[]{label51, label52, label53};
        tv1 = new TextView[]{label11, label12, label13, label14};
        tv4 = new TextView[]{label41, label42, label43, label44};
        tv6 = new TextView[]{label62, label61};
        tv7 = new TextView[]{label72, label71};
        tv3 = new TextView[]{label32, label31};
        tv2 = new TextView[]{label22, label21};


    }

    @OnClick({R.id.label_1_1, R.id.label_1_2, R.id.label_1_3, R.id.label_1_4
            , R.id.label_2_1, R.id.label_2_2, R.id.label_3_1, R.id.label_3_2
            , R.id.label_4_1, R.id.label_4_2, R.id.label_4_3, R.id.label_4_4
            , R.id.label_5_1, R.id.label_5_2, R.id.label_5_3
            , R.id.label_6_1, R.id.label_6_2
            , R.id.label_7_1, R.id.label_7_2
    })
    public void OnClickLabel(TextView tv) {
        change(tv);
    }

    private void change(TextView tv) {
        if (tv.isSelected()) {
            tv.setTextColor(brank);
            tv.setBackgroundColor(gray);
            tv.setSelected(false);
        } else {
            tv.setTextColor(white);
            tv.setBackgroundColor(blue);
            tv.setSelected(true);
        }
    }


    public int getAge() {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy");
        SimpleDateFormat simple2 = new SimpleDateFormat("yyyy-MM-dd");
        String now = simple.format(new Date());

        String str = tvBirth.getText().toString();
        String input = null;
        try {
            input = simple.format(simple2.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(now) - Integer.parseInt(input);
    }


    private int getHeight() {
        return Integer.parseInt((String) tvHeight.getText());
    }

    private int getWeight() {
        return Integer.parseInt((String) tvWeight.getText());
    }

    /**
     * 获取IBM
     */
    public String getIBM() {
        String s = getWeight() * 1.0 / ((getHeight() * 0.01) * (getHeight() * 0.01))+"";
        return s.substring(0,5);
    }


    /**
     * 获取每个组件中点击数
     */
    public int getCount(TextView[] tv) {
        Log.v("Forecast",tv.toString());
        int count = 0;
        for (TextView ttv : tv) {
            Log.v("Forecast",ttv.getText().toString());
            if (ttv.isSelected()) {
                Log.v("Forecast","123"+ttv.getText().toString());
                count++;

            }
        }
        return count;
    }

    public int getSmokeNum() {
        return Integer.parseInt((String) tvSmokeNum.getText());
    }

    public int getSmokeYear() {
        return Integer.parseInt((String) tvSmokeYear.getText());
    }


    /**
     * 单选按钮进行切换
     * 直系亲属
     */
    @OnClick({R.id.label_2_1, R.id.label_2_2})
    public void radio1(TextView tv) {
        label21.setTextColor(brank);
        label21.setBackgroundColor(gray);
        label21.setSelected(false);
        label22.setTextColor(brank);
        label22.setBackgroundColor(gray);
        label22.setSelected(false);
        tv.setTextColor(white);
        tv.setBackgroundColor(blue);
        tv.setSelected(true);
    }

    /**
     * 单选按钮进行切换
     * 是否患有其他癌症
     */
    @OnClick({R.id.label_3_1, R.id.label_3_2})
    public void radio2(TextView tv) {
        label31.setTextColor(brank);
        label31.setBackgroundColor(gray);
        label31.setSelected(false);
        label32.setTextColor(brank);
        label32.setBackgroundColor(gray);
        label32.setSelected(false);
        tv.setTextColor(white);
        tv.setBackgroundColor(blue);
        tv.setSelected(true);
    }

    /**
     * 单选按钮进行切换
     * 吸烟症状
     */
    @OnClick({R.id.label_5_1, R.id.label_5_2, R.id.label_5_3})
    public void radio3(TextView tv) {
        label51.setTextColor(brank);
        label51.setBackgroundColor(gray);
        label51.setSelected(false);
        label52.setTextColor(brank);
        label52.setBackgroundColor(gray);
        label52.setSelected(false);
        label53.setTextColor(brank);
        label53.setBackgroundColor(gray);
        label53.setSelected(false);
        tv.setTextColor(white);
        tv.setBackgroundColor(blue);
        tv.setSelected(true);
    }

    /**
     * 单选按钮进行切换
     * 二手烟状况
     */
    @OnClick({R.id.label_6_1, R.id.label_6_2})
    public void radio4(TextView tv) {
        label61.setTextColor(brank);
        label61.setBackgroundColor(gray);
        label61.setSelected(false);
        label62.setTextColor(brank);
        label62.setBackgroundColor(gray);
        label62.setSelected(false);
        tv.setTextColor(white);
        tv.setBackgroundColor(blue);
        tv.setSelected(true);
    }

    /**
     * 单选按钮进行切换
     * 油烟暴露状况
     */
    @OnClick({R.id.label_7_1, R.id.label_7_2})
    public void radio5(TextView tv) {
        label71.setTextColor(brank);
        label71.setBackgroundColor(gray);
        label71.setSelected(false);
        label72.setTextColor(brank);
        label72.setBackgroundColor(gray);
        label72.setSelected(false);
        tv.setTextColor(white);
        tv.setBackgroundColor(blue);
        tv.setSelected(true);
    }


    /**
     * 获取单选按钮的内容
     */
    public String getNum(TextView[] tv) {
        int i;
        for (i = 0; i < tv.length; i++) {
            if (tv[i].isSelected()) {
                if(i<2){
                    return i + "";
                }else {
                    return "0";
                }

            }
        }
        Toast.makeText(ForecastActivity.this, "您有未选择的项哦", Toast.LENGTH_SHORT).show();
        return "";
    }

    /**
     * 发送请求
     */
    public void sendRequest() {
        btnForecast.setText("预测中");
        String httpurl = null;
        httpurl = App.testHttpUrl + "forecastData?" + "age=" + getAge() + "&bml=" + getIBM() + "&airTube=" + getCount(tv1)
                + "&cancerStraight=" + getNum(tv2) + "&cancerOther=" + getNum(tv3) + "&disease=" + getCount(tv4)
                + "&smokeSolution=" + getNum(tv5) + "&cigaretteAvg=" + tvSmokeNum.getText().toString()
                + "&cigaretteYear=" + tvSmokeYear.getText().toString() + "&secondHandCigarette=" + getNum(tv6) + "&lampblack=" + getNum(tv7);
        Log.v("Forecast", httpurl);
        RequestQueue mQueue = Volley.newRequestQueue(ForecastActivity.this);

        Log.v("ForecastActivity", httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        btnForecast.setText("预测完成");
                        Log.v("ForecastActivity", "response:" + response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            String s = jsonObject1.getString("result");

                            Intent intent = new Intent(ForecastActivity.this, ForecastResultActivity.class);
                            intent.putExtra("result",s.substring(1,6));
                            intent.putExtra("name",tvForecastName.getText().toString());
                            ForecastActivity.this.startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finish();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                btnForecast.setText("预测失败");
                btnForecast.setBackgroundColor(getResources().getColor(R.color.cpb_red));
                Log.e(getClass().getSimpleName(), volleyError.getMessage(), volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,0,0f));
        mQueue.add(stringRequest);

    }

    private void onClikeTextView(final TextView tv) {
        AlertDialog alertDialog = new AlertDialog
                .Builder(ForecastActivity.this)
                .setItems(selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv.setText(selected[which]);
                        String s = getWeight() * 1.0 / ((getHeight() * 0.01) * (getHeight() * 0.01))+"";
                        tvBmi.setText("BMI:"+s.substring(0,5));
                        //Toast.makeText(ForecastActivity.this,"选择了第"+which+"个",Toast.LENGTH_SHORT).show();
                    }
                }).create();
        alertDialog.show();

    }

    private void newStringArray(int min, int max) {
        selected = new String[max - min + 1];
        for (int i = 0; i < selected.length; min++, i++) {
            selected[i] = "" + min;
        }
    }


    @OnClick(R.id.tv_height)
    public void setTvHeight() {
        newStringArray(100, 200);
        onClikeTextView(tvHeight);
    }

    @OnClick(R.id.tv_weight)
    public void setTvWeight() {
        newStringArray(40, 100);
        onClikeTextView(tvWeight);
    }

    @OnClick(R.id.tv_smoke_num)
    public void setTvSmokeNum() {
        newStringArray(0, 40);
        onClikeTextView(tvSmokeNum);
    }

    @OnClick(R.id.tv_smoke_year)
    public void setTvSmokeYear() {
        newStringArray(0, 40);
        onClikeTextView(tvSmokeYear);
    }

    @OnClick(R.id.btn_forecast)
    public void commit() {
        sendRequest();

    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }

}
