package appoint.utils;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import appoint.DoctorActivity;
import greendao.DatabaseUtils;

/**
 * @author lifan
 * @date 2018/8/11 17:37
 * @email 2224779926@qq.com
 * @desc
 */

public class OtherUtils {

    public static String getHospitalName(int idHospital){
        RequestQueue mQueue = Volley.newRequestQueue(null);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://120.79.241.203:8080/GoHospital/getDocById?dId=" + idHospital, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        response.toString();

                    }
                }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.e("TAG", error.getMessage(), error);

                }
            }) ;

            mQueue.add(jsonObjectRequest);



        return "南京市某某医院 三级甲等";

    }
}
