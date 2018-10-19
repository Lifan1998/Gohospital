package home;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.life.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import appoint.AppointmentActivity;
import ask.Utils;
import ask.adapter.AskAdapter;
import ask.model.AskItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import home.adapter.GridAdapter;
import news.adapter.NewsAdapter;
import news.model.DataBean;
import news.model.Result;
import util.App;

/**
 * Created by lenovo on 2018/4/18.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.iv_richscan)
    ImageView ivRichscan;
    @BindView(R.id.layout_search_edit)
    FrameLayout layoutSearchEdit;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.iv_forecast)
    ImageView ivForecast;
    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;

    private GridView gridView;
    private GridAdapter adapter;

    private List<Result> newsList = new
            LinkedList<>();
    private List<AskItem> askItemList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private PullToRefreshListView homeNewsList;
    private ListView homeAskList;
    public  List<Integer> images=new ArrayList<>();
    public  List<String> titles=new ArrayList<>();

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:

                    adapter = new GridAdapter(getActivity());
                    gridView.setAdapter(adapter);

                    break;
            }
        }


    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView appointImage = view.findViewById(R.id.appointimage);
        appointImage.setOnClickListener(this);
        gridView = view.findViewById(R.id.gv_home);
        homeNewsList = (PullToRefreshListView) view.findViewById(R.id.home_news_list);
        homeAskList = (ListView) view.findViewById(R.id.home_ask_list);


        homeAskList.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });

        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
        new Thread() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(10);
            }

            ;
        }.start();

        initAskDate();
        AskAdapter askAdapter = new AskAdapter(getActivity(), askItemList);
        homeAskList.setAdapter(askAdapter);

        initNewsDate();

        newsAdapter = new NewsAdapter(getActivity(), newsList);
        Log.v("HomeActivity", newsList.toString() + newsAdapter.toString());
        homeNewsList.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        homeNewsList.setAdapter(newsAdapter);


        homeNewsList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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

        initBanner();

    }

    private void initAskDate() {
        askItemList.addAll(Utils.getAskItems());

    }

    private void initNewsDate() {

       newsList.addAll(news.util.Utils.jsonToResult(stringjson));
        Log.v("HomeFragment",newsList.toString());

    }

    private void initBanner(){
        images.add(R.drawable.item_ask_iv1);
        titles.add("第一张图片");
        images.add(R.drawable.item_ask_iv2);
        titles.add("第二张图片");
        images.add(R.drawable.item_news_iv1);
        titles.add("第三张图片");
        images.add(R.drawable.item_news_iv2);
        titles.add("第四张图片");



        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner的高度为手机屏幕的四分之一
        //banner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, App.H/4));
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appointimage:
                Activity context = getActivity();
                context.startActivity(new Intent(context, AppointmentActivity.class));
                break;

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_forecast)
    public void onClickF() {
        getActivity().startActivity(new Intent(getActivity(), ForecastActivity.class));
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

            //initNewsDate();
            //newsList.addAll(parseJson(stringjson));
            newsAdapter.notifyDataSetChanged();
            homeNewsList.onRefreshComplete();
        }
    }


    private String stringjson = "[{\"tag\":\"运动\",\"img1Url\":null,\"img2Url\":null,\"img3Url\":null,\"aname\":\"运动把健康捍卫到底\",\"aid\":11,\"aurl\":\"http://120.79.241.203:8080/GoHospital/article/article11.html\",\"atime\":1520757272000,\"aauthor\":\"帆帆老师\"}]";
}

