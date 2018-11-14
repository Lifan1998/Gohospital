package home;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.msg.MsgService;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import appoint.AppointmentActivity;
import appoint.DeptActivity;
import ask.AskOpenActivity;
import ask.adapter.AskAdapter;
import ask.model.AskItem;
import ask.util.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import config.App;
import config.Preferences;
import home.adapter.GridAdapter;
import main.SearchActivity;
import main.SearchFragment;
import msg.MsgActivity;
import news.NewsOpenActivity;
import news.adapter.NewsAdapter;
import news.model.Result;
import user.LoginActivity;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by lenovo on 2018/4/18.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.iv_richscan)
    ImageView ivRichscan;
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

    private List<Result> newsList = new LinkedList<>();
    private List<AskItem> askItemList = new ArrayList<>();
    private List<Result> newsList1 = new LinkedList<>();

    private NewsAdapter newsAdapter;
    private AskAdapter askAdapter;

    private PullToRefreshListView homeNewsList;
    private ListView homeAskList;

    public List<String> images = new ArrayList<>();
    public List<String> titles = new ArrayList<>();
    private String token;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:
                    adapter = new GridAdapter(getActivity());
                    gridView.setAdapter(adapter);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String s = (String) gridView.getAdapter().getItem(position);
                            Log.v("HomeFragment",s);
                            Intent intent = new Intent(getActivity(), DeptActivity.class);
                            intent.putExtra("online",true);
                            intent.putExtra("onlineKey",s);
                            intent.putExtra("id", 1);
                            intent.putExtra("menzhen", s);
                            intent.putExtra("keshi", "内科");
                            startActivity(intent);


                        }
                    });
                    break;

            }
        }


    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        gridView = view.findViewById(R.id.gv_home);
        homeNewsList = (PullToRefreshListView) view.findViewById(R.id.home_news_list);
        homeAskList = (ListView) view.findViewById(R.id.home_ask_list);
        token = Preferences.getInstance().getToken();
        initView();

        return view;
    }

    public void initView() {
        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
        if(unreadNum==0){
            tvMsgNum.setVisibility(View.INVISIBLE);
        }else {
            tvMsgNum.setText(unreadNum+"");
        }
        new Thread() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(10);
            }

            ;
        }.start();
        //加载问答

        initAskDate();
        initBannerData();

        //加载文章
        newsAdapter = new NewsAdapter(getActivity(), newsList);
        initNewsDate();
        homeNewsList.setAdapter(newsAdapter);
        homeNewsList.setOnTouchListener(new View.OnTouchListener() {

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
        homeNewsList.setMode(PullToRefreshBase.Mode.DISABLED);
        homeNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Result item = (Result) newsAdapter.getItem(position-1);
                Intent intent = new Intent(getContext(), NewsOpenActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("aurl",item.getAurl());
                intent.putExtra("type","推荐");
                startActivity(intent);
            }
        });
        //initBanner();
        homeAskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), AskOpenActivity.class);
                AskItem askItem = (AskItem) askAdapter.getItem(position);
                intent.putExtra("askItem", askItem);
                startActivity(intent);
            }
        });


    }

    private void initAskDate() {

        String httpurl = App.testHttpUrl + "getRecommendForum?token=" + token + "&startId=0";
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {

                        Log.v("AskTab", "成功" + jsonArray.toString());
                        if(Utils.jsonToAskItems(jsonArray.toString()).size()>2){
                            askItemList = Utils.jsonToAskItems(jsonArray.toString()).subList(0,2);
                        }else {
                            askItemList = Utils.jsonToAskItems(jsonArray.toString());
                        }

                        askAdapter = new AskAdapter(getActivity(), askItemList);
                        homeAskList.setAdapter(askAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 0, 0f));
        mQueue.add(jsonArrayRequest);

    }

    private void initNewsDate() {
        String httpUrl;

        httpUrl = App.testHttpUrl + "getRecommendArticle?token=" + token + "&startId=0";
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        LinkedList<Result> list = (LinkedList<Result>) news.util.Utils.jsonToResult(jsonArray.toString());
                        if (list.size()>7){
                            newsList.addAll(list.subList(0,7));
                        } else {
                            newsList.addAll(list);
                        }


                        newsAdapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(jsonArrayRequest);
    }

    private void initBanner() {


        Iterator iterator = newsList1.iterator();
        Result result = null;
        while (iterator.hasNext()){
           result = (Result)iterator.next();
           images.add(result.getImageUrl().get(0));
           titles.add(result.getTitle());
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
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
        banner.setIndicatorGravity(BannerConfig.LEFT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Result item = (Result)newsList1.get(position);
                Intent intent = new Intent(getContext(),NewsOpenActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("aurl",item.getAurl());
                intent.putExtra("type","推荐");
                startActivity(intent);
            }
        });

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
    @OnClick(R.id.appointimage)
    public void appoint(){
        getActivity().startActivity(new Intent(getActivity(), AppointmentActivity.class));
    }

    @OnClick(R.id.searchedit)
    public void search(){
        Log.v("HomeFragment","R.id.searchedit");
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("type", SearchFragment.Companion.getTYPE_All());
        getActivity().startActivity(intent);
    }

    private void initBannerData(){
        String httpUrl;

        httpUrl = App.testHttpUrl + "getRecommendArticle2?token=" + token;
        Log.v("HomeActivity",httpUrl);
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(httpUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.v("HomeActivity",jsonArray.toString());
                        Log.v("HomeActivity",news.util.Utils.jsonToResult(jsonArray.toString()).toString());
                        newsList1.addAll(news.util.Utils.jsonToResult(jsonArray.toString()));
                        Log.v("HomeActivity",newsList1.toString());
                        initBanner();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(jsonArrayRequest);
    }
    @OnClick({R.id.iv_msg,R.id.tv_msg_num})
    public void msgStart(){

        if (Preferences.getInstance().isSign()){
            startActivity(new Intent(getActivity(), MsgActivity.class));
        } else {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

    }
}

