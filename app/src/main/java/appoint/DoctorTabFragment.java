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
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.json.JSONArray;

import java.util.LinkedList;
import java.util.List;

import appoint.adapter.DoctorAdapter;
import appoint.entity.Doctor;
import appoint.utils.JsonParser;

import config.App;

import static com.android.volley.VolleyLog.TAG;

/**
 * @author lifan
 * @date 2018/10/22 10:04
 * @email 2224779926@qq.com
 * @desc
 */

public class DoctorTabFragment extends Fragment {
    private String type;
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private DoctorAdapter doctorAdapter;

    /**
     * 搜索关键字
     */
    private String searchContent;
    private List<Doctor>  list;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (list != null) {
                        doctorAdapter = new DoctorAdapter(list,getActivity());
                        mPullRefreshListView.setAdapter(doctorAdapter);
                    }
                    break;
            }
        }

        ;
    };


    public void setType(String type) {
        this.type = type;
    }
    public void setSearchContent(String searchContent){
        this.searchContent = searchContent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news1, container, false);
        list = new LinkedList<>();
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
        initData();
    }


    private class GetDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            //mListItems.add(result);
            //mAdapter.notifyDataSetChanged();
            initData();
            doctorAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }


    private void initData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("base", 0);
        String token = sharedPreferences.getString("token","1");

        String httpurl = App.testHttpUrl+"getDocByDept?hId=1&hDept=内科&hRoom=消化内科";
        if(searchContent!=null){
            //搜索医生
            httpurl = App.testHttpUrl+"searchDoctor?keywords="+searchContent+"&startId="+1;
        } else if("医生".equals(type)){
            //收藏的医生
            httpurl = App.testHttpUrl+"getCollectionDoc?token="+token;
        }


        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        Log.v("DoctorsTab","成功"+jsonArray.toString());
                        list.addAll(JsonParser.jsonToDoctors(jsonArray.toString()));
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
}
