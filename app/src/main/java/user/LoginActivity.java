package user;

/**
 * Created by lenovo on 2018/3/9.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.provider.ContactsContract;
        import android.text.Editable;
        import android.text.Layout;
        import android.text.TextWatcher;
        import android.text.method.HideReturnsTransformationMethod;
        import android.text.method.PasswordTransformationMethod;
        import android.util.Log;
        import android.view.View;
        import android.view.View.OnClickListener;
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
        import com.android.volley.Response.ErrorListener;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.example.life.R;

        import java.util.HashMap;
        import java.util.Map;

        import static android.content.ContentValues.TAG;

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

                break;
            case R.id.tv_code:
                Toast.makeText(LoginActivity.this,"已发送验证短信",Toast.LENGTH_SHORT).show();
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

                break;
        }


   }

    private void changeSign() {
       if(login_way==0){
           login_way=1;
            tvLabel.setText("用帐号密码登录");
           code.setVisibility(View.INVISIBLE);
           tv_code.setVisibility(View.INVISIBLE);
           password.setVisibility(View.VISIBLE);

       } else {
           login_way=0;
           tvLabel.setText("用短信验证码登录");
           code.setVisibility(View.VISIBLE);
           tv_code.setVisibility(View.VISIBLE);
           password.setVisibility(View.INVISIBLE);
       }
    }


    private   void login(){
        //Volley上传数据给服务器
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String httpurl = "http://192.168.43.1:8080/login";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("TAG",response);
                        String token = "";
                        SharedPreferences settings = getSharedPreferences("base", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("token", token);
                        // 提交本次编辑
                        editor.commit();



                        Log.d(TAG, "response -> " + response);
                        finish();
                    }
                }, new ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, error.getMessage(), error);
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();

                }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                if(login_way==0){
                    map.put("login_way",login_way+"" );
                    map.put("username", username.getText().toString());
                    map.put("code",code.getText().toString());

                }else{
                    map.put("login_way",login_way+"" );
                    map.put("username", username.getText().toString());
                    map.put("password",password.getText().toString());
                }

                return map;
            }
        };
        requestQueue.add(stringRequest);

    }

}
