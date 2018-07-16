package main;

import com.example.life.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ask.AskFragment;
import home.HomeFragment;
import init.MyUtils;
import init.SplashActivity;
import init.VersionUpdateUtils;
import my.MyFragment;
import news.NewsFragment;


public class MainActivity extends Activity implements View.OnClickListener{
	private long mExitTime;
	private LinearLayout ly_one,ly_two,ly_three,ly_four;
	private TextView mTextView1,mTextView2,mTextView3,mTextView4;


	private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private AskFragment askFragment;
    private MyFragment myFragment;

    private FragmentTransaction transaction;

	/** 本地版本号 */
	private String mVersion;


	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		bindView();
		ly_one.performClick();
		updatecheck();

	}

	private void updatecheck() {
		mVersion = MyUtils.getVersion(getApplicationContext());
		final VersionUpdateUtils updateUtils = new VersionUpdateUtils(mVersion,
				MainActivity.this);
		new Thread() {
			public void run() {
				// 获取服务器版本号
				updateUtils.getCloudVersion();
			};
		}.start();
	}


	private void bindView() {

		ly_one = findViewById(R.id.ly_tab_menu_home);
		ly_two = findViewById(R.id.ly_tab_menu_news);
		ly_three = findViewById(R.id.ly_tab_menu_ask);
		ly_four =findViewById(R.id.ly_tab_menu_my);

		mTextView1 = findViewById(R.id.tab_menu_home);
		mTextView2 = findViewById(R.id.tab_menu_news);
		mTextView3 = findViewById(R.id.tab_menu_ask);
		mTextView4 =  findViewById(R.id.tab_menu_my);

		ly_one.setOnClickListener(this);
		ly_two.setOnClickListener(this);
		ly_three.setOnClickListener(this);
		ly_four.setOnClickListener(this);

	}

	//重置所有文本的选中状态
	private void setSelected() {
		mTextView1.setSelected(false);
		mTextView2.setSelected(false);
		mTextView3.setSelected(false);
		mTextView4.setSelected(false);

	}
	@Override
	public void onClick(View v) {
		transaction = getFragmentManager().beginTransaction();



		if(homeFragment!=null) {
         transaction.hide(homeFragment);
        }
        if(newsFragment!=null){
		    transaction.hide(newsFragment);
        }
        if(askFragment!=null){
            transaction.hide(askFragment);
        }
        if(myFragment!=null){
            transaction.hide(myFragment);
        }

		switch (v.getId()) {
			case R.id.ly_tab_menu_home:
				setSelected();
				mTextView1.setSelected(true);

				if(homeFragment==null){
					homeFragment = new HomeFragment();
                   transaction.add(R.id.fragment_container, homeFragment);
                }else{
					transaction.show(homeFragment);
				}
				transaction.commit();
				break;
			case R.id.ly_tab_menu_news:
				setSelected();
				mTextView2.setSelected(true);

				if(newsFragment==null){
					newsFragment = new NewsFragment();
					transaction.add(R.id.fragment_container,newsFragment);
				}else{
					transaction.show(newsFragment);
				}
				transaction.commit();
				break;
            case R.id.ly_tab_menu_ask:
                setSelected();
                mTextView3.setSelected(true);


                if(askFragment==null){
                    askFragment = new AskFragment();
                    transaction.add(R.id.fragment_container,askFragment);
                }else{
                    transaction.show(askFragment);
                }
                transaction.commit();

                break;
			case R.id.ly_tab_menu_my:
				setSelected();
				mTextView4.setSelected(true);


				if(myFragment==null){
					myFragment = new MyFragment();
					transaction.add(R.id.fragment_container,myFragment);
				}else{
					transaction.show(myFragment);
				}
				transaction.commit();

				break;
		}
	}

	/***
	 * 按两次返回键退出程序
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			} else {
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}


	
}

