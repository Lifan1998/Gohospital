package user;

/**
 * Created by lenovo on 2018/3/9.
 */




import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import user.util.Utils;

import static android.content.ContentValues.TAG;
import static android.os.Build.*;

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
    //短信验证码
    private String CAPTCHA;



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
                CAPTCHA = Utils.getCode(username.getText().toString());
                break;

        }
    }

    //注册
    private void register(){

        if (CAPTCHA == null){
            Toast.makeText(RegisterActivity.this,"未发送验证短信",Toast.LENGTH_SHORT).show();
            return;
        } else if (CAPTCHA.equals(code.getText().toString())){

            //验证码正确，上传账号密码，保存token，跳转Activity

            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegisterActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
        }



    }

}
