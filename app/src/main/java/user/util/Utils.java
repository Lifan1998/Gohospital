package user.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nim.uikit.common.util.log.LogUtil;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;

import org.json.JSONException;
import org.json.JSONObject;

import config.App;
import config.Preferences;
import user.ForgetPassActivity;
import user.LoginActivity;
import user.RegisterActivity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * @author lifan
 * @date 2018/9/30 17:54
 * @email 2224779926@qq.com
 * @desc
 */

public class Utils {

    public static void sendMessage(String tel, final Context context, final TextView tv){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        String httpurl = App.testHttpUrl+"sendMessage?tel="+tel;

        Log.v(context.getClass().getSimpleName(),httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            String code = jsonObject1.getString("code");
                            LoginActivity.CAPTCHA = code;
                            ForgetPassActivity.CAPTCHA = code;
                            RegisterActivity.CAPTCHA = code;


                            Log.v(context.getClass().getSimpleName(),code);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000,0,0f));
        mQueue.add(stringRequest);

    }
    public static void loginIM(String account){
        Log.v("Login",account);

        NimUIKit.login(new LoginInfo(account, account), new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {
                LogUtil.i(TAG, "login NO Failed");
                Preferences.getInstance().setAccount(param.getAccount());
            }

            @Override
            public void onFailed(int code) {
                LogUtil.i(TAG, "login Failed");
            }

            @Override
            public void onException(Throwable exception) {

            }
        });
    }
}




