package main;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.Preferences;
import msg.MsgActivity;
import user.LoginActivity;

/**
 * @author lifan
 * @date 2018/10/21 22:49
 * @email 2224779926@qq.com
 * @desc
 */

public class SearchActivity_ extends FragmentActivity {
    @BindView(R.id.search_fragment)
    FrameLayout searchFragment;
    @BindView(R.id.searchbox)
    SearchBox search;
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
    private FragmentTransaction transaction;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        type = getIntent().getIntExtra("type", -1);
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
        initView();

    }

    private void initView() {
        search.enableVoiceRecognition(this);

        for (int x = 0; x < 10; x++) {
            SearchResult option = new SearchResult("123Result " + Integer.toString(x), getResources().getDrawable(R.drawable.ic_history));
            search.addSearchable(option);
        }
        search.setLogoText("搜索");
        search.setLogoTextColor(R.color.apptheme);
        //search.revealFromMenuItem(R.id.action_search, this);
        search.setMenuListener(new SearchBox.MenuListener() {

            @Override
            public void onMenuClick() {
                //Hamburger has been clicked
                Toast.makeText(SearchActivity_.this, "Menu click", Toast.LENGTH_LONG).show();
            }

        });
        search.setSearchListener(new SearchBox.SearchListener() {

            @Override
            public void onSearchOpened() {
                //Use this to tint the screen
                Log.v("SearchBox", "onSearchOpened()");
            }

            @Override
            public void onSearchClosed() {
                //Use this to un-tint the screen
                Log.v("SearchBox", "onSearchOpened()");
            }

            @Override
            public void onSearchTermChanged(String s) {
                Log.v("SearchBox", "onSearchTermChanged" + s);
            }


            @Override
            public void onSearch(String searchTerm) {
                Toast.makeText(SearchActivity_.this, searchTerm + " Searched", Toast.LENGTH_LONG).show();
                Log.v("SearchBox", "onSearch" + searchTerm);
                setSearchFragment(searchTerm);

            }

            @Override
            public void onResultClick(SearchResult result) {
                //React to a result being clicked
                Log.v("SearchBox", "onResultClick" + result);
                setSearchFragment(result.title);
            }


            @Override
            public void onSearchCleared() {
                Log.v("SearchBox", "onSearchCleared()");
            }

        });
        search.setOverflowMenu(R.menu.overflow_menu);
        search.setOverflowMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.test_menu_item:
                        Toast.makeText(SearchActivity_.this, "Clicked!", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            search.populateEditText(matches.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setSearchFragment(String searchContent) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        bundle.putString("searchContent", searchContent);
        SearchFragment search = new SearchFragment();
        search.setArguments(bundle);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.search_fragment, search);
        transaction.show(search);
        transaction.commit();
    }
    @OnClick(R.id.layout_return)
    public void exit(){
        finish();
    }
    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(this, MsgActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
