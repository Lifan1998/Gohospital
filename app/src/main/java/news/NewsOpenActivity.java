package news;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;

import java.util.HashMap;
import java.util.Map;

import ask.AskOpenActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.App;
import config.CollectionUtils;
import config.Preferences;
import msg.MsgActivity;
import user.LoginActivity;

import static com.android.volley.VolleyLog.TAG;

/**
 * @author lifan
 * @date 2018/10/20 11:11
 * @email 2224779926@qq.com
 * @desc
 */

public class NewsOpenActivity extends Activity {
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
    @BindView(R.id.newswebview)
    WebView newswebview;

    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_commend)
    ImageView ivCommend;


    private int id;
    private String aurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_open);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra("id", 0);
        aurl = getIntent().getStringExtra("aurl");
        CollectionUtils.isInCollect(getApplicationContext(),CollectionUtils.FLAG_NEWS,id,ivLove);
        initView();
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
        updateType(getIntent().getStringExtra("type"));
    }

    private void initView() {
        String s = getIntent().getStringExtra("title");
        if(s.length()<10){
            tvTitle.setText(s);
        } else {
            tvTitle.setText(s.substring(0,10)+"...");
        }

        newswebview.loadUrl(aurl);

    }


    private void updateType(final String type) {
        String httpurl = App.testHttpUrl + "updateAccount";
        SharedPreferences sharedPreferences = getSharedPreferences("base", 0);
        final String token = sharedPreferences.getString("token", "");
        if (token.equals("")) {
            return;
        }
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.v(TAG, volleyError.getMessage(), volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("token", token);
                map.put("keywords", type);
                map.put("flag", 1 + "");
                return map;
            }
        };
        mQueue.add(stringRequest);
    }

    @OnClick(R.id.iv_love)
    public void selectLove(){
        if(!Preferences.getInstance().isSign()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if(ivLove.isSelected()){
            ivLove.setSelected(false);
            CollectionUtils.collection(getApplicationContext(),CollectionUtils.FLAG_NEWS,id,0);

        }else{
            ivLove.setSelected(true);
            CollectionUtils.collection(getApplicationContext(),CollectionUtils.FLAG_NEWS,id,1);

        }
    }
    @OnClick(R.id.iv_commend)
    public void selectCommend(){
        if(!Preferences.getInstance().isSign()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        ivCommend.setSelected(true);
    }
    @OnClick(R.id.layout_return)
    public void close(){
        finish();
    }
    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(this, MsgActivity.class));
        } else {
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
