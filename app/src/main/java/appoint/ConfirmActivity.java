package appoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appoint_confirm);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {



        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = confirmName.getText().toString();
                String tele = confirmTele.getText().toString();
                String id = confirmId.getText().toString();



                Toast.makeText(ConfirmActivity.this,"预约成功",Toast.LENGTH_SHORT);
            }
        });
    }
}
