package home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.tv_birth)
    TextView tvBirth;
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


    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);
        tvTitle.setText("健康评估");

    }
    @OnClick({R.id.label_1_1,R.id.label_1_2,R.id.label_1_3,R.id.label_1_4
            ,R.id.label_2_1,R.id.label_2_2,R.id.label_3_1,R.id.label_3_2
            ,R.id.label_4_1,R.id.label_4_2,R.id.label_4_3,R.id.label_4_4
            ,R.id.label_5_1,R.id.label_5_2,R.id.label_5_3
            ,R.id.label_6_1,R.id.label_6_2
            ,R.id.label_7_1,R.id.label_7_2
    })
    public void OnClickLabel(TextView tv){
        change(tv);



    }

    private void change(TextView tv){
        if(tv.isSelected()){
            tv.setTextColor(brank);
            tv.setBackgroundColor(gray);
            tv.setSelected(false);
        } else {
            tv.setTextColor(white);
            tv.setBackgroundColor(blue);
            tv.setSelected(true);
        }
    }

}
