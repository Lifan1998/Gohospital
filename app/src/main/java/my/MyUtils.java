package my;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.netease.nim.uikit.api.NimUIKit;

import org.json.JSONException;
import org.json.JSONObject;

import config.App;
import msg.MsgUtils;
import my.model.User;

/**
 * @author lifan
 * @date 2018/11/12 14:47
 * @email 2224779926@qq.com
 * @desc
 */

public class MyUtils {
    public static User getUser(String token, Context context){
        User user = null;


        //1为医生，0为用户
        final int flag = 0;
        RequestQueue mQueue = Volley.newRequestQueue(context);
        String httpurl = App.LocalUrl+"getInfoById?id="+
                "&flag="+flag;
        Log.v("LoginActivity",httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject0 = jsonObject.getJSONObject("model");
                            JSONObject jsonObject1 = jsonObject0.getJSONObject("user");


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
        mQueue.add(stringRequest);

        return user;
    }
}
