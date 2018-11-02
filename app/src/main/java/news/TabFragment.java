package news;

/**
 * @author lifan
 * @date 2018/10/2 21:33
 * @email 2224779926@qq.com
 * @desc
 */



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


import news.adapter.NewsAdapter;
import news.model.Result;
import news.util.Utils;
import config.App;

import static com.android.volley.VolleyLog.TAG;


public class TabFragment extends Fragment {

    private String type = "推荐";
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private NewsAdapter newsAdapter;
    private int count = 0;
    private LinkedList<Result> list = new LinkedList<>();
    private String searchContent;


    public void setType(String type) {
        this.type = type;
    }
    public void setSearchContent(String searchContent){
        this.searchContent = searchContent;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news1, container, false);
        init(view);
        return view;

    }

    private void init(View view) {
        mPullRefreshListView = view.findViewById(R.id.pull_refresh_list);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        newsAdapter = new NewsAdapter(getActivity(),list);
        mPullRefreshListView.setAdapter(newsAdapter);
        initData();
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Log.e("TAG", "onPullDownToRefresh");
                //这里写下拉刷新的任务
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
                Result item = (Result) newsAdapter.getItem(position-1);
                Intent intent = new Intent(getContext(),NewsOpenActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("aurl",item.getAurl());
                intent.putExtra("type",type);
                startActivity(intent);
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
            newsAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }



    public void initData(){
        String httpUrl ;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("base", 0);
        String token = sharedPreferences.getString("token","1");
        if ("".equals(token)){
            token = "1";
        }
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());

        if(type.equals("推荐")){
            httpUrl = App.testHttpUrl+"getRecommendArticle?token="+token+"&startId="+count++;
        } else if("文章".equals(type)){
            //收藏文章
            httpUrl = App.testHttpUrl+"getCollectionArticle?token="+token;
        } else if(searchContent!=null){
            //搜索
            httpUrl = App.testHttpUrl+"getRecommendArticle?token="+token+"&startId="+count++;
        } else {
            httpUrl = App.testHttpUrl+"selectArticle?"+"keywords="+type+"&startId="+count++;
        }

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        Log.v("NewsTab","成功"+jsonArray.toString());
                        list.addAll(Utils.jsonToResult(jsonArray.toString()));

                        newsAdapter.notifyDataSetChanged();
                        mPullRefreshListView.onRefreshComplete();

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







