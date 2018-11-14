package my;

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
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.App;
import config.Preferences;
import de.hdodenhof.circleimageview.CircleImageView;
import msg.MsgActivity;
import msg.MsgUtils;
import my.model.User;
import user.LoginActivity;

/**
 * Created by lenovo on 2018/7/11.
 */

public class MyInforActivity extends Activity {
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
    @BindView(R.id.infor_img)
    CircleImageView inforImg;
    @BindView(R.id.infor_layout_img)
    RelativeLayout inforLayoutImg;
    @BindView(R.id.infor_account)
    TextView inforAccount;
    @BindView(R.id.infor_name)
    TextView inforName;
    @BindView(R.id.infor_layout_name)
    RelativeLayout inforLayoutName;
    @BindView(R.id.infor_real_name)
    TextView inforRealName;
    @BindView(R.id.infor_layout_real_name)
    RelativeLayout inforLayoutRealName;
    @BindView(R.id.infor_sex)
    TextView inforSex;
    @BindView(R.id.infor_layout_sex)
    RelativeLayout inforLayoutSex;
    @BindView(R.id.infor_age)
    TextView inforAge;
    @BindView(R.id.infor_layout_age)
    RelativeLayout inforLayoutAge;
    @BindView(R.id.infor_tel)
    TextView inforTel;
    @BindView(R.id.infor_layout_tel)
    RelativeLayout inforLayoutTel;
    @BindView(R.id.infor_email)
    TextView inforEmail;
    @BindView(R.id.infor_layout_email)
    RelativeLayout inforLayoutEmail;
    @BindView(R.id.btn_infor_commit)
    TextView btnInforCommit;



    private User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_myinfor);
        user = getIntent().getParcelableExtra("user");
        Log.v("MyFragment",user.toString());
        ButterKnife.bind(this);
        initView();
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }

    }

    private void initView() {
        tvTitle.setText("个人资料");
        tvMsgNum.setVisibility(View.INVISIBLE);
        ivMsg.setVisibility(View.INVISIBLE);
        inforRealName.setText(user.getName());
        inforName.setText(user.getuName());
        inforEmail.setText(user.getuEmail());
        inforSex.setText(user.getuSex());
        inforAccount.setText(user.getuTel());
        inforTel.setText(user.getuTel());
    }


    @OnClick(R.id.infor_layout_img)
    public void setInforImg(){

    }
    @OnClick(R.id.infor_layout_age)
    public void setInforAge(){

        final String[] selected = new String[60];
        for (int i=0;i<selected.length;i++){
            selected[i] = i+10+"";
        }
        AlertDialog alertDialog = new AlertDialog
                .Builder(this)
                .setItems(selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inforAge.setText(selected[which]);

                    }
                }).create();
        alertDialog.show();

    }
    @OnClick(R.id.infor_layout_email)
    public void setInforEmail(){
        View view = getLayoutInflater().inflate(R.layout.half_dialog_view, null);
        final EditText editText = (EditText) view.findViewById(R.id.dialog_edit);
        editText.setHint(inforEmail.getText());
        AlertDialog dialog = new AlertDialog.Builder(this)
                //.setTitle("电话")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        inforEmail.setText(content);

                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }
    @OnClick(R.id.infor_layout_name)
    public void setInforName(){
        View view = getLayoutInflater().inflate(R.layout.half_dialog_view, null);
        final EditText editText = (EditText) view.findViewById(R.id.dialog_edit);
        editText.setHint(inforName.getText());
        AlertDialog dialog = new AlertDialog.Builder(this)
                //.setTitle("电话")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        inforName.setText(content);

                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }
    @OnClick(R.id.infor_layout_real_name)
    public void setInforRealName(){
        View view = getLayoutInflater().inflate(R.layout.half_dialog_view, null);
        final EditText editText = (EditText) view.findViewById(R.id.dialog_edit);
        editText.setHint(inforRealName.getText());
        AlertDialog dialog = new AlertDialog.Builder(this)
                //.setTitle("电话")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        inforRealName.setText(content);
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }
    @OnClick(R.id.infor_layout_sex)
    public void setInforSex(){
        final String[] selected = new String[]{"未选择", "男","女"};
        AlertDialog alertDialog = new AlertDialog
                .Builder(this)
                .setItems(selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inforSex.setText(selected[which]);

                    }
                }).create();
        alertDialog.show();
    }


    @OnClick(R.id.infor_layout_tel)
    public void setInforTel(){

        View view = getLayoutInflater().inflate(R.layout.half_dialog_view, null);
        final EditText editText = (EditText) view.findViewById(R.id.dialog_edit);
        editText.setHint(inforTel.getText());
        AlertDialog dialog = new AlertDialog.Builder(this)
                //.setTitle("电话")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        inforTel.setText(content);
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }


    @OnClick(R.id.btn_infor_commit)
    public void setUser(){
        btnInforCommit.setText("保存中...");
        String token = Preferences.getInstance().getToken();
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        String httpurl = App.RemoteUrl+"insertIntoUser?token="+token+
                "&uTel="+inforTel.getText()+
                "&uEmail="+inforEmail.getText()+
                "&uName="+inforName.getText()+
                "&uSex="+inforSex.getText()+
                "&uAge="+inforAge.getText()+
                "&Name="+inforRealName.getText();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        btnInforCommit.setText("保存成功");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
                btnInforCommit.setText("保存失败");
            }
        });
        mQueue.add(stringRequest);


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

