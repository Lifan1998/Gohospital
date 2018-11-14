package user;

/**
 * Created by lenovo on 2018/3/9.
 */


//import android.support.v7.app.ActionBarActivity;

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

import java.util.HashMap;
import java.util.Map;

import config.Preferences;
import user.util.Utils;
import config.App;

import static android.content.ContentValues.TAG;

/**
 * 注册Demo
 *
 * @author ZHY
 *
 */
public class ForgetPassActivity extends Activity implements OnClickListener {
    private EditText username,password,password_,code;
    private ImageView iv_return;
    private TextView tv_code;
    private Button btn_reset;
    /**
     * 短信验证码
     **/
    public static String CAPTCHA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forgetpass);
        initView();
    }
    private void initView() {
        username = findViewById(R.id.edit_username);

        password = findViewById(R.id.edit_password);
        password_ = findViewById(R.id.edit_password_);
        code = findViewById(R.id.edit_code);
        tv_code = findViewById(R.id.tv_code);
        btn_reset = findViewById(R.id.btn_reset);
        iv_return = findViewById(R.id.iv_return);

        iv_return.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        tv_code.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_return:
                finish();
                break;
            case R.id.btn_reset:

                if(password_.getText().toString().equals(password.getText().toString())){
                    reset();
                }else{
                    Toast.makeText(ForgetPassActivity.this,"两次输入的密码不一致！",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_code:
                Toast.makeText(ForgetPassActivity.this,"已发送验证短信",Toast.LENGTH_SHORT).show();
                Utils.sendMessage(username.getText().toString(),this,tv_code);
                break;

        }
    }


    private void reset(){
        if (CAPTCHA == null){
            Toast.makeText(ForgetPassActivity.this,"未发送验证短信",Toast.LENGTH_SHORT).show();
            return;
        } else if (CAPTCHA.equals(code.getText().toString())){

        //Volley上传数据给服务器
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String httpurl = App.testHttpUrl+"forgetPass";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                        Toast.makeText(ForgetPassActivity.this,"重置成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
                Toast.makeText(ForgetPassActivity.this,"重置失败",Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("tel",username.getText().toString() );
                map.put("password",password.getText().toString());
                return map;
            }
        };
        requestQueue.add(stringRequest);
        } else {
            Toast.makeText(ForgetPassActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
        }
    }


}
