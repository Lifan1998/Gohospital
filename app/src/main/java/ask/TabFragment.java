package ask;

import android.content.Intent;
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

import ask.adapter.AskAdapter;
import ask.model.AskItem;
import ask.util.Utils;
import config.App;
import config.Preferences;

import static com.android.volley.VolleyLog.TAG;
import static com.android.volley.VolleyLog.e;


/**
 * @author lifan
 * @date 2018/10/4 15:17
 * @email 2224779926@qq.com
 * @desc
 */


public class TabFragment extends Fragment {

    private String type = "推荐";
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private AskAdapter askAdapter;


    private List<AskItem> list;
    private int count = 0;
    private String searchContent;
    public void setSearchContent(String searchContent){
        this.searchContent = searchContent;
    }




    public void setTitle(String type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news1, container, false);
        list = new LinkedList<>();
        askAdapter = new AskAdapter(getActivity(),list);
        init(view);
        return view;
        //askAdapter = new AskAdapter(getActivity(),list);


    }

    private void init(View view) {
        mPullRefreshListView = view.findViewById(R.id.pull_refresh_list);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullRefreshListView.setAdapter(askAdapter);
        initData();



        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.e("TAG", "onPullDownToRefresh");
                //这里写下拉刷新的任务
                //list.clear();
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.e("TAG", "onPullUpToRefresh");
                //这里写上拉加载更多的任务
                new GetDataTask().execute();
            }
        });
        mPullRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),AskOpenActivity.class);
                AskItem askItem = (AskItem)askAdapter.getItem(position-1);
                intent.putExtra("askItem",askItem);
                startActivity(intent);
            }
        });
    }


    private class GetDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            Log.e("TAG", "doInBackground");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            initData();
            Log.e("TAG", "doInBackground");
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("TAG", "onPostExecute");
            askAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }


    private void initData() {
        String httpurl = null;
        String token = Preferences.getInstance().getToken();
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());


        if("推荐".equals(type)){
            //推荐的问答，应用在首页，Tab
            httpurl = App.testHttpUrl+"getRecommendForum?token="+token+"&startId=" +count++;
        } else if("我的问答".equals(type)){
            //我的提问
            httpurl = App.testHttpUrl+"getOwnForum?token="+token;
        } else if("问答".equals(type)){
            //收藏问答

            httpurl = App.testHttpUrl+"getCollectionForum?token="+token;
        }else if(searchContent!=null){
            //搜索
            httpurl = App.testHttpUrl+"getForumByKeywords?keywords="+searchContent+"&startId="+count++;
        } else {
            //Tab
            httpurl = App.testHttpUrl + "getForumByKeywords?" + "keywords=" + type + "&startId=" + count++;
        }

        Log.v(TabFragment.class.getSimpleName(),httpurl);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        Log.v("AskTab","成功"+jsonArray.toString());
                        list.addAll(Utils.jsonToAskItems(jsonArray.toString()));
                        askAdapter.notifyDataSetChanged();


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
