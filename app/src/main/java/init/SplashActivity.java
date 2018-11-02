package init;

import com.example.life.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import main.MainActivity;


/**
 * 欢迎页面
 * 
 * @author admin
 */
public class SplashActivity extends Activity {

	/** 应用版本号 */


	private TextView textView;
	private  Timer timer ;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置没有标题栏 在加载布局之前调用
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
        initView();

	}

	/** 初始化控件 */
	private void initView() {
        timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,2000);

		textView = findViewById(R.id.tv_tiaoguo);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			    timer.cancel();
                timerTask.cancel();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});


	}
}
