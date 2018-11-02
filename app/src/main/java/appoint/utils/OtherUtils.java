package appoint.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import config.App;

/**
 * @author lifan
 * @date 2018/8/11 17:37
 * @email 2224779926@qq.com
 * @desc
 */

public class OtherUtils {

    public static String getHospitalName(int idHospital, Context context, final TextView textView){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        String httpurl = App.testHttpUrl+"getDocHospById?dId="+idHospital;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v(getClass().getName(),"response:"+response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONObject jsonObject1 = jsonObject.getJSONObject("model");
                            String name = jsonObject1.getString("token");
                            textView.setText(name);


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

        return "南京市某某医院 三级甲等";

    }
}
