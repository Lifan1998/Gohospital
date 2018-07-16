package my;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.life.R;

/**
 * Created by lenovo on 2018/7/11.
 */

public class MyInforActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_myinfor);
        initView();
    }

    private void initView() {

    }

    @Override
    public void onClick(View v) {

    }
}

