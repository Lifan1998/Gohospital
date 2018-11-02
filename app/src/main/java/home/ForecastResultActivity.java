package home;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lifan
 * @date 2018/9/25 23:45
 * @email 2224779926@qq.com
 * @desc
 */

public class ForecastResultActivity extends Activity {
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.forecast_name)
    TextView forecastName;
    @BindView(R.id.tv_forecast_result)
    TextView tvForecastResult;

    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forecast_result);
        ButterKnife.bind(this);
        String name = getIntent().getStringExtra("name");
        String result  = getIntent().getStringExtra("result");
        if(name==null|"".equals(name)){
            name = "亲爱的用户";
        }
        tvTitle.setText("健康评估");
        tvForecastResult.setText(result+"%");
        forecastName.setText(name+"  您的预测结果如下！");

    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }

}
