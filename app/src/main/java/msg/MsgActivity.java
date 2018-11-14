package msg;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.life.R;
import com.netease.nim.uikit.business.contact.ContactsFragment;
import com.netease.nim.uikit.business.recent.RecentContactsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lifan
 * @date 2018/11/8 16:04
 * @email 2224779926@qq.com
 * @desc
 */

public class MsgActivity extends FragmentActivity {

    @BindView(R.id.msg_contain)
    FrameLayout msgContain;
    @BindView(R.id.msg_tab)
    TabLayout msgTab;
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


    private RecentContactsFragment recentContactsFragment;
    private ContactsFragment contactsFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_msg);
        ButterKnife.bind(this);
        tvTitle.setText("消息");
        ivMsg.setVisibility(View.INVISIBLE);
        tvMsgNum.setVisibility(View.INVISIBLE);
        initView();

    }

    private void initView() {
        msgTab.addTab(msgTab.newTab().setText("最近"));
        msgTab.addTab(msgTab.newTab().setText("联系人"));


        msgTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                if (recentContactsFragment != null) {
                    transaction.hide(recentContactsFragment);
                }
                if (contactsFragment != null) {
                    transaction.hide(contactsFragment);
                }


                if (tab.getText().toString().equals("最近")) {

                    if (recentContactsFragment == null) {
                        recentContactsFragment = new RecentContactsFragment();
                        transaction.add(R.id.msg_contain, recentContactsFragment);
                    } else {
                        transaction.show(recentContactsFragment);
                    }

                } else {

                    if (contactsFragment == null) {
                        contactsFragment = new ContactsFragment();
                        transaction.add(R.id.msg_contain, contactsFragment);
                    } else {
                        transaction.show(contactsFragment);
                    }

                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        msgTab.getTabAt(1).select();
        msgTab.getTabAt(0).select();


    }


}
