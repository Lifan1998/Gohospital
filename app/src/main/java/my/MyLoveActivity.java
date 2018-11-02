package my;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/7/11.
 */

public class MyLoveActivity extends FragmentActivity {
    private static final String TAG = MyLoveActivity.class.getSimpleName();
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
    @BindView(R.id.mylovefragment)
    FrameLayout mylovefragment;
    private FragmentTransaction transaction;
    private MyLoveFragment myLoveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mylove);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        int type = getIntent().getIntExtra("type", -1);
        switch (type) {
            case 1: tvTitle.setText("我的预约");break;
            case 2: tvTitle.setText("我的收藏");break;
            case 3: tvTitle.setText("我的问答");break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        myLoveFragment = new MyLoveFragment();
        myLoveFragment.setArguments(bundle);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.mylovefragment, myLoveFragment);
        transaction.show(myLoveFragment);
        transaction.commit();
    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }
}
