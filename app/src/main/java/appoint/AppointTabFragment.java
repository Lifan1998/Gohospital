package appoint;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import appoint.adapter.AppointAdapter;
import appoint.adapter.DoctorAdapter;
import appoint.entity.Doctor;
import appoint.utils.JsonParser;
import config.App;
import config.Preferences;
import greendao.DatabaseUtils;

import static com.android.volley.VolleyLog.TAG;
import static com.android.volley.VolleyLog.d;

/**
 * @author lifan
 * @date 2018/11/1 12:38
 * @email 2224779926@qq.com
 * @desc
 */

public class AppointTabFragment extends Fragment{
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private AppointAdapter appointAdapter;
    /**
     * 带预约的医生list
     */
    private List<Doctor> doctors;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (doctors != null) {
                       appointAdapter = new AppointAdapter(doctors,getActivity());
                        mPullRefreshListView.setAdapter(appointAdapter);
                    }
                    break;
            }
        }

        ;
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news1, container, false);
        doctors = new LinkedList<>();
        initData();

        init(view);
        return view;

    }

    private void init(View view) {
        mPullRefreshListView = view.findViewById(R.id.pull_refresh_list);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.e("TAG", "onPullDownToRefresh");
                //这里写下拉刷新的任务
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(
                    PullToRefreshBase<ListView> refreshView) {
                Log.e("TAG", "onPullUpToRefresh");
                //这里写上拉加载更多的任务
                new GetDataTask().execute();
            }
        });
        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    private class GetDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            initData();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            //刷新listView
            appointAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }


    private void initData() {
        String token = Preferences.getInstance().getToken();
        String httpurl ;

        if("已完成".equals(type)){
            httpurl = App.testHttpUrl+"showRegisteration?token="+token+"&state=1";
        } else {
            httpurl = App.testHttpUrl+"showRegisteration?token="+token+"&state=0";
        }


        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.v("AppointTab","成功"+jsonArray.toString());
                        for (int i=0;i<jsonArray.length();i++){
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int idDoctor = jsonObject.getInt("did");
                                Long time = jsonObject.getLong("apTime");
                                addDoctor(idDoctor,ask.util.Utils.dataToString(time));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mHandler.sendEmptyMessage(0);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(10000,0,0f));
        mQueue.add(jsonArrayRequest);
    }

    private void addDoctor(int id_doctor, final String time){
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        String httpUrl = App.LocalUrl+"getDocById?dId=" + id_doctor;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(httpUrl, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Log.v("TAG", response.toString());
                    Doctor doctor = JsonParser.jsonToDoctor(response.toString());
                    doctor.setScheduing(time);
                    doctors.add(doctor);
                    //appointAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);

            }});
        mQueue.add(jsonObjectRequest);
    }

}


