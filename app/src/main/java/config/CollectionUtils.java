package config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import user.LoginActivity;

/**
 * @author lifan
 * @date 2018/10/30 18:42
 * @email 2224779926@qq.com
 * @desc
 */

public class CollectionUtils {
    public static int FLAG_DOCTOR = 0;
    public static int FLAG_HOSPITAL = 1;
    public static int FLAG_NEWS = 2;
    public static int FLAG_ASK= 3;

    /**
     *
     * @param context
     * @param flag1 操作对象
     * @param aId  操作对象
     * @param flag2 1:添加 0:取消  收藏
     */
    public static void collection(Context context,int flag1,int aId,int flag2){
        String token  = Preferences.getInstance().getToken();
        String httpurl = App.LocalUrl+"collection?token="+ token+"&flag1="+flag1+"&aId="+aId+"&flag2="+flag2;
        RequestQueue mQueue = Volley.newRequestQueue(context);

        Log.v("LoginActivity",httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(getClass().getSimpleName(),volleyError.getMessage(),volleyError);
            }
        });
        mQueue.add(stringRequest);
    }
    public static void isInCollect(Context context, int flag1, int aId, final ImageView imageView){
        String token  = Preferences.getInstance().getToken();
        String httpurl = App.LocalUrl+"isInCollect?token="+token+"&flag1="+flag1+"&aId="+aId;
        RequestQueue mQueue = Volley.newRequestQueue(context);
        Log.v("LoginActivity",httpurl);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            boolean isSuccess = jsonObject1.getBoolean("isSuccess");
                           if(isSuccess){
                               imageView.setSelected(false);
                           } else {
                               imageView.setSelected(true);
                           }

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
