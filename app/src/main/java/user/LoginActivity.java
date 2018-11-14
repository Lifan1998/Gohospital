package user;

/**
 * Created by lenovo on 2018/3/9.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.util.Log;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.os.Bundle;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.example.life.R;

        import org.json.JSONException;
        import org.json.JSONObject;

        import config.App;
        import config.Preferences;
        import user.util.CountDownTimerUtils;
        import user.util.Utils;

/**
 * &#x767b;&#x5f55;&#x754c;&#x9762;Demo
 *
 * @author ZHY
 *
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText username,password,code;
    private TextView tv_code,tv_register,tv_forget;
    private ImageView iv_return;
    private Button btn_login;
    private LinearLayout sign_change;
    private TextView tvLabel;
    private String TAG = "LoginActivity";
    /**
    * 短信验证码
    **/
   public static String CAPTCHA;


    private int login_way  = 0;

    public LoginActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView() {
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        password.setVisibility(View.INVISIBLE);
        code = findViewById(R.id.edit_code);
        tv_code = findViewById(R.id.tv_code);
        iv_return = findViewById(R.id.iv_return);
        tv_register = findViewById(R.id.tv_register);
        tv_forget = findViewById(R.id.tv_forgetpass);
        btn_login =findViewById(R.id.btn_login);
        sign_change = findViewById(R.id.sign_change);
        tvLabel = findViewById(R.id.tv_label);

        tv_forget.setOnClickListener(this);
        iv_return.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_code.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        sign_change.setOnClickListener(this);


    }

   @Override
   public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_return: finish();
                break;
            case R.id.tv_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_code:
                Toast.makeText(LoginActivity.this,"已发送验证短信",Toast.LENGTH_SHORT).show();
                new CountDownTimerUtils(tv_code,30*1000,1000);

                Utils.sendMessage(username.getText().toString(),this,tv_code);
                break;
            case R.id.sign_change:
                changeSign();
                break;
            case R.id.btn_login:
                login();
                break;

            case R.id.tv_forgetpass:
                intent = new Intent(this, ForgetPassActivity.class);
                startActivity(intent);
                finish();

                break;
        }


   }

    private void changeSign() {
       if(login_way==0){
           login_way=1;
            tvLabel.setText("帐号密码登录");
           code.setVisibility(View.INVISIBLE);
           tv_code.setVisibility(View.INVISIBLE);
           password.setVisibility(View.VISIBLE);

       } else {
           login_way=0;
           tvLabel.setText("短信验证码登录");
           code.setVisibility(View.VISIBLE);
           tv_code.setVisibility(View.VISIBLE);
           password.setVisibility(View.INVISIBLE);
       }
    }


    private void login(){
        String httpurl = null;
        if(login_way==0){

            httpurl = App.RemoteUrl+"login?" +"flag="+login_way+"&tel="+username.getText().toString()+
                    "&password="+code.getText().toString();

        } else {
            httpurl = App.RemoteUrl+"login?" +"flag="+login_way+"&tel="+username.getText().toString()+
                    "&password="+password.getText().toString();
        }
        RequestQueue mQueue = Volley.newRequestQueue(LoginActivity.this);

        Log.v("LoginActivity",httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            String token = jsonObject1.getString("token");
                            Preferences.getInstance().setToken(token);
                            user.util.Utils.loginIM(username.getText().toString());
                            Log.v("LoginActivity",token);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finish();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
            }
        });
        mQueue.add(stringRequest);


    }





}
