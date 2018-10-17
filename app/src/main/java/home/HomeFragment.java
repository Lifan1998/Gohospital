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

    private List<Result> newsList = new ArrayList<>();
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

        newsList = parseJson(stringjson);

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
            newsList.addAll(parseJson(stringjson));
            newsAdapter.notifyDataSetChanged();
            homeNewsList.onRefreshComplete();
        }
    }

    private List<Result> parseJson(String jsonStr) {
        Gson gson = new Gson();
        DataBean dataBean = gson.fromJson(jsonStr, DataBean.class);
        Log.i("ddd", "databean");
        if (dataBean != null) {
            return dataBean.getResult();
        }
        return null;
    }

    private String stringjson = "{\n" +
            "    \"type\": \"类型\",\n" +
            "    \"result\": [\n" +
            "        {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot1.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"济南远大脑康医院焦虑症治疗费用贵吗？\",\n" +
            "            \"type\": 0,\n" +
            "            \"time\": \"2018-06-01\",\n" +
            "            \"author\": \"陈勇\",\n" +
            "            \"comment\": 5,\n" +
            "            \"recommend\": 2,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [],\n" +
            "            \"title\": \"合肥华夏彩云行动专家组义诊、亲诊即将开启\",\n" +
            "            \"type\": 2,\n" +
            "            \"time\": \"2018-06-02\",\n" +
            "            \"author\":  \"钱卫国\",\n" +
            "            \"comment\": 4,\n" +
            "            \"recommend\": 3,\n" +
            "            \"intro\": \"2018第35届昌平区春季马拉松将于4月1日在北京昌平新城滨河森林公园鸣枪开赛，本届比赛的参赛规模将达到2000人。每一次持之以恒的奔跑，每一场步履不停的马拉...\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot11.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"国际儿科名医五一杭州保贝儿童医院义诊 重磅惊喜等着你\",\n" +
            "            \"type\": 0,\n" +
            "            \"time\": \"2018-06-03\",\n" +
            "            \"author\":  \"钱佳益\",\n" +
            "            \"comment\": 4,\n" +
            "            \"recommend\": 21,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [ ],\n" +
            "            \"title\": \"中韩男科高峰论坛暨脱细胞异体生物补片临床应用推广会在锡\",\n" +
            "            \"type\": 2,\n" +
            "            \"time\": \"2018-06-04\",\n" +
            "            \"author\":\"钱家驹\",\n" +
            "            \"comment\": 4,\n" +
            "            \"recommend\": 7,\n" +
            "            \"intro\": \"崔教授回忆，当年同时期从事屈光手术专业的医生有许多转行从事其他专业，而自己坚持了下来。\"\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot6.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"大咖来了|伊琳娜·波波娃担任合肥华夏 白癜风国际外籍专家\",\n" +
            "            \"type\": 1,\n" +
            "            \"time\": \"2018-06-05\",\n" +
            "            \"author\": \"海昌\",\n" +
            "            \"comment\": 7,\n" +
            "            \"recommend\": 1,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot8.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"杭州保贝儿童医院怎么样？杭州治疗儿童多动症医院\",\n" +
            "            \"type\": 1,\n" +
            "            \"time\": \"2018-06-06\",\n" +
            "            \"author\": \"浩皛\",\n" +
            "            \"comment\": 1,\n" +
            "            \"recommend\": 6,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "        {\n" +
            "            \"imageUrl\": [],\n" +
            "            \"title\": \"钦州协和医院到底如何？钦州协和医院“用心服务、感恩患\",\n" +
            "            \"type\": 2,\n" +
            "            \"time\": \"2018-06-07\",\n" +
            "            \"author\": \"海荣\",\n" +
            "            \"comment\": 2,\n" +
            "            \"recommend\": 8,\n" +
            "            \"intro\": \"深圳同仁妇产医院重视人才的挖掘和培养，汇聚知名的妇科医师数十名，并组织业内十几位知名医院妇科医学....\"\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot11.jpg\",\n" +
            "            ],\n" +
            "            \"title\": \"韩晓明-成都成华脑康医院\",\n" +
            "            \"type\": 0,\n" +
            "            \"time\": \"2018-06-08\",\n" +
            "            \"author\":\"海昌\",\n" +
            "            \"comment\": 6,\n" +
            "            \"recommend\": 7,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "        {\n" +
            "            \"imageUrl\": [ ],\n" +
            "            \"title\": \"滁州同济医院用心服务获好评\",\n" +
            "            \"type\": 2,\n" +
            "            \"time\": \"2018-06-09\",\n" +
            "            \"author\": \"浩歌\",\n" +
            "            \"comment\": 7,\n" +
            "            \"recommend\": 2,\n" +
            "            \"intro\": \"人格类型不仅可以解释人们在与外界环境打交道时采用何种互动方式，还能从中洞察出睡眠习惯。2.检查室温：在凉爽和光线昏暗的屋子里最容易获得高质量睡眠，理...\"\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot7.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"【倒计时3天】美国·北京·上海儿科名医坐诊杭州保贝儿童医\",\n" +
            "            \"type\": 1,\n" +
            "            \"time\": \"2018-06-10\",\n" +
            "            \"author\":\"浩邈\",\n" +
            "            \"comment\": 7,\n" +
            "            \"recommend\": 6,\n" +
            "            \"intro\": “”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [],\n" +
            "            \"title\": \"大连美琳达妇儿医院怎么样 以医疗人文关怀为中心 诚信品牌\",\n" +
            "            \"type\": 2,\n" +
            "            \"time\": \"2018-06-11\",\n" +
            "            \"author\": \"吕姓\",\n" +
            "            \"comment\": 4,\n" +
            "            \"recommend\": 6,\n" +
            "            \"intro\": \"“娉娉袅袅十三余，豆蔻梢头二月初”，看到这些美妙的诗句，不免让人想到校园中天真烂漫的女孩子。然而，近期...\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}

