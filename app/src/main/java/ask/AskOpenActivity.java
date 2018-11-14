package ask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import ask.adapter.CommentAdapter;
import ask.model.AskItem;
import ask.model.Comment;
import ask.util.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import config.App;
import config.CollectionUtils;
import config.Preferences;
import de.hdodenhof.circleimageview.CircleImageView;
import msg.MsgActivity;
import user.LoginActivity;

import static com.android.volley.VolleyLog.TAG;

/**
 * @author lifan
 * @date 2018/10/20 16:32
 * @email 2224779926@qq.com
 * @desc
 */

public class AskOpenActivity extends Activity {
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
    @BindView(R.id.ask_title)
    TextView askTitle;
    @BindView(R.id.item_ask_image)
    CircleImageView itemAskImage;
    @BindView(R.id.item_ask_name)
    TextView itemAskName;
    @BindView(R.id.item_ask_time)
    TextView itemAskTime;
    @BindView(R.id.ask_intro)
    TextView askIntro;
    @BindView(R.id.item_ask_image1)
    ImageView itemAskImage1;
    @BindView(R.id.item_ask_image2)
    ImageView itemAskImage2;
    @BindView(R.id.item_ask_image3)
    ImageView itemAskImage3;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_commend)
    ImageView ivCommend;
    @BindView(R.id.tv_ask_type)
    TextView tvAskType;
    @BindView(R.id.my_ask_type)
    LinearLayout myAskType;
    @BindView(R.id.item_comment_list)
    ListView itemCommentList;
    @BindView(R.id.edit_comment)
    EditText editComment;
    @BindView(R.id.btn_comment)
    TextView btnComment;

    private AskItem askItem;
    private CommentAdapter commentAdapter;
    private List<Comment> comments;

    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ask_open);
        ButterKnife.bind(this);
        askItem = getIntent().getParcelableExtra("askItem");
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
        CollectionUtils.isInCollect(getApplicationContext(), CollectionUtils.FLAG_ASK, askItem.getId(), ivLove);
        initView();

    }

    private void initView() {
        tvTitle.setText("问题详情");
        //选择显示方式 图片or文字
        switch (askItem.getImageurl().size()){
            case 3:
                Picasso.get().load(askItem.getImageurl().get(2)).fit().into(itemAskImage3);
            case 2:
                Picasso.get().load(askItem.getImageurl().get(1)).fit().into(itemAskImage2);
            case 1:
                Picasso.get().load(askItem.getImageurl().get(0)).fit().into(itemAskImage1);
                break;
            case 0:
                break;
        }
        askTitle.setText(askItem.getTitle());
        askIntro.setText(askItem.getIntro());
        itemAskName.setText(askItem.getName());
        itemAskTime.setText(askItem.getTime());
        comments = new LinkedList<>();
        commentAdapter = new CommentAdapter(this, comments);

        itemCommentList.setAdapter(commentAdapter);
        initComment(askItem.getId());

    }

    private void initComment(int askID) {
        String httpurl = App.LocalUrl+"queryAllReply?tId="+askID;

        RequestQueue mQueue = Volley.newRequestQueue(this);

        Log.v("AskOpenActivity", httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            JSONArray jsonArray = jsonObject1.getJSONArray("userCommnet");
                            comments = Utils.jsonToComments(jsonArray.toString());
                            Log.v("AskOpenActivity", "Comment:" + comments.toString());
                            commentAdapter = new CommentAdapter(AskOpenActivity.this, comments);
                            itemCommentList.setAdapter(commentAdapter);
                            commentAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(), volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(stringRequest);

    }

        /**
         * 是否收藏
         */
    @OnClick(R.id.iv_love)
    public void selectLove() {
        if(!Preferences.getInstance().isSign()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return;
        }
        if (ivLove.isSelected()) {
            ivLove.setSelected(false);
            CollectionUtils.collection(AskOpenActivity.this, CollectionUtils.FLAG_ASK, askItem.getId(), 0);
            Toast.makeText(getApplicationContext(), "已取消收藏", Toast.LENGTH_SHORT).show();
        } else {
            ivLove.setSelected(true);
            CollectionUtils.collection(AskOpenActivity.this, CollectionUtils.FLAG_ASK, askItem.getId(), 1);
            Toast.makeText(getApplicationContext(), "已收藏", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 是否点赞
     */
    @OnClick(R.id.iv_commend)
    public void selectCommend() {
        if(!Preferences.getInstance().isSign()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return;
        }
        if (ivCommend.isSelected()) {
            ivCommend.setSelected(false);

        } else {
            ivCommend.setSelected(true);
        }
    }

    @OnClick(R.id.layout_return)
    public void close() {
        finish();
    }

    @OnClick(R.id.my_ask_type)
    public void type() {

        final String[] selected = new String[]{"按热度", "按时间","只看医生"};
        AlertDialog alertDialog = new AlertDialog
                .Builder(this)
                .setItems(selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvAskType.setText(selected[which]);
                    }
                }).create();
        alertDialog.show();


    }


    @OnClick(R.id.btn_comment)
    public void btnComment(){
        if(!Preferences.getInstance().isSign()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return;
        }

        String token = Preferences.getInstance().getToken();
        String commentText = editComment.getText().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String httpurl = App.LocalUrl+"addReply?tId="+askItem.getId()+"&rContent="+commentText +
                "&rTime="+ simpleDateFormat.format(new Date())+
                "&token="+token;

        RequestQueue mQueue = Volley.newRequestQueue(this);

        Log.v("AskOpenActivity",httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("AskOpenActivity","response:"+response.toString());
                        Toast.makeText(getApplicationContext(),"已发送",Toast.LENGTH_SHORT).show();
                        initComment(askItem.getId());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
            }
        });
        mQueue.add(stringRequest);

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
