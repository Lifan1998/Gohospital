package ask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.life.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import ask.adapter.AskAdapter;
import ask.model.AskItem;
import news.adapter.NewsAdapter;
import news.model.DataBean;
import news.model.Result;

/**
 * @author lifan
 * @date 2018/10/4 15:17
 * @email 2224779926@qq.com
 * @desc
 */


public class TabFragment extends Fragment {

    private String type;
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private AskAdapter askAdapter;
    String stringjson ="";


    private List<AskItem> list;


    public void setTitle(String type) {
        this.type = type;
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

        initData(type);

        // 设置适配器

        askAdapter = new AskAdapter(getActivity(), list);
        mPullRefreshListView.setAdapter(askAdapter);


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
    }


    private class GetDataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return stringjson;
        }

        @Override
        protected void onPostExecute(String result) {
            //mListItems.add(result);
            //mAdapter.notifyDataSetChanged();
            list.addAll(parseJson(result));
            askAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }


    private void initData(String type) {
        list = new ArrayList<>();
        list = parseJson(stringjson);


    }


    private List<AskItem> parseJson(String jsonStr) {
        Gson gson = new Gson();
        //DataBean dataBean = gson.fromJson(jsonStr, DataBean.class);
        Log.i("ddd", "databean");


        return Utils.getAskItems();
    }
}
