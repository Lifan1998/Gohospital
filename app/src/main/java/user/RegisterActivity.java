package user;

/**
 * Created by lenovo on 2018/3/9.
 */




import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;

import org.json.JSONException;
import org.json.JSONObject;

import user.util.Utils;
import config.App;

/**
 * 注册
 *
 * @author ZHY
 *
 */
public class RegisterActivity extends Activity implements OnClickListener {
    private EditText username,name,password,code;
    private Button btn_register;
    private ImageView iv_return;
    private TextView tv_code;
    /**
     * 短信验证码
     **/
    public static String CAPTCHA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView() {
        username = findViewById(R.id.edit_username);
        name = findViewById(R.id.edit_name);
        password = findViewById(R.id.edit_password);
        code = findViewById(R.id.edit_code);
        tv_code = findViewById(R.id.tv_code);
        iv_return = findViewById(R.id.iv_return);
        btn_register = findViewById(R.id.btn_register);

        tv_code.setOnClickListener(this);
        iv_return.setOnClickListener(this);
        btn_register.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_return:
                finish();
                break;
            case R.id.btn_register:
                register();
                break;
            case R.id.tv_code:
                Toast.makeText(RegisterActivity.this,"已发送验证短信",Toast.LENGTH_SHORT).show();
                Utils.sendMessage(username.getText().toString(),this,tv_code);
                break;

        }
    }

    //注册
    private void register(){

        if (CAPTCHA == null){
            Toast.makeText(RegisterActivity.this,"未发送验证短信",Toast.LENGTH_SHORT).show();
            return;
        } else if (CAPTCHA.equals(code.getText().toString())){

            RequestQueue mQueue = Volley.newRequestQueue(RegisterActivity.this);

            String httpurl = App.testHttpUrl+"registerAccount?tel="+username.getText().toString()+
                    "&name="+name.getText().toString()+"&password="+password.getText().toString();
            Log.v("LoginActivity",httpurl);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("LoginActivity","response:"+response.toString());
                            try {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                                String token = jsonObject1.getString("token");
                                SharedPreferences settings = getSharedPreferences("base", 0);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putString("token", token);
                                // 提交本次编辑
                                editor.commit();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                }
            });
            mQueue.add(stringRequest);


        } else {
            Toast.makeText(RegisterActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
        }



    }

}
