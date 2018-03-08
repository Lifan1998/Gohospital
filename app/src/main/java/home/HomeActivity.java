package home;

import com.example.life.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends Activity implements View.OnClickListener{
	private long mExitTime;
	private LinearLayout ly_one,ly_two,ly_three,ly_four;
	private TextView mTextView1,mTextView2,mTextView3,mTextView4;
	private TextView mTextNum1,mTextNum2,mTextNum3;
	private ImageView mImageView;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);


		bindView();
		ly_one.performClick();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		MyFragment fg1 = new MyFragment();
		transaction.add(R.id.fragment_container,fg1);
		transaction.commit();
	}

	private void bindView() {

		ly_one = (LinearLayout)findViewById(R.id.ly_tab_menu_deal);
		ly_two = (LinearLayout)findViewById(R.id.ly_tab_menu_poi);
		ly_three = (LinearLayout)findViewById(R.id.ly_tab_menu_more);
		ly_four = (LinearLayout)findViewById(R.id.ly_tab_menu_user);

		mTextView1 = (TextView)findViewById(R.id.tab_menu_deal);
		mTextView2 = (TextView)findViewById(R.id.tab_menu_poi);
		mTextView3 = (TextView)findViewById(R.id.tab_menu_more);
		mTextView4 = (TextView)findViewById(R.id.tab_menu_user);

		mTextNum1 = (TextView)findViewById(R.id.tab_menu_deal_num);
		mTextNum2 = (TextView)findViewById(R.id.tab_menu_poi_num);
		mTextNum3 = (TextView)findViewById(R.id.tab_menu_more_num);

		mImageView = (ImageView)findViewById(R.id.tab_menu_setting_partner);

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

		switch (v.getId()) {
			case R.id.ly_tab_menu_deal:
				setSelected();
				mTextView1.setSelected(true);
				mTextNum1.setVisibility(View.INVISIBLE);
				break;
			case R.id.ly_tab_menu_poi:
				setSelected();
				mTextView2.setSelected(true);
				mTextNum2.setVisibility(View.INVISIBLE);
				break;
			case R.id.ly_tab_menu_more:
				setSelected();
				mTextView3.setSelected(true);
				mTextNum3.setVisibility(View.INVISIBLE);
				break;
			case R.id.ly_tab_menu_user:
				setSelected();
				mTextView4.setSelected(true);
				mImageView.setVisibility(View.INVISIBLE);
				break;
		}
	}


	public void startActivity(Class<?> cls) {
		Intent intent = new Intent(HomeActivity.this, cls);
		startActivity(intent);
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

