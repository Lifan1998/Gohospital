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

import org.json.JSONException;
import org.json.JSONObject;

import config.App;
import user.ForgetPassActivity;
import user.LoginActivity;
import user.RegisterActivity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

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
                            //tv.setText("发送中");

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


}




/**
 * Created by Jackie on 2015/11/30.
 */

