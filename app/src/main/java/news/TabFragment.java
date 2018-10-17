package news;

/**
 * @author lifan
 * @date 2018/10/2 21:33
 * @email 2224779926@qq.com
 * @desc
 */



import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.life.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import news.adapter.NewsAdapter;
import news.model.DataBean;
import news.model.Result;


public class TabFragment extends Fragment {

    private String type;
    /**
     * 上拉刷新的控件
     */
    private PullToRefreshListView mPullRefreshListView;
    private NewsAdapter newsAdapter;


    private List<Result> list;


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

        newsAdapter = new NewsAdapter(getActivity(),list);
        mPullRefreshListView.setAdapter(newsAdapter);


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
            newsAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
        }
    }



    private void initData(String type) {
        list = new ArrayList<>();
        list =  parseJson(stringjson);


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
            "            \"intro\": “2018第35届昌平区春季马拉松将于4月1日在北京昌平新城滨河森林公园鸣枪开赛，本届比赛的参赛规模将达到2000人。每一次持之以恒的奔跑，每一场步履不停的马拉...”\n" +
            "        },\n" +
            "        {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot11.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"国际儿科名医五一杭州保贝儿童医院义诊 重磅惊喜等着你\",\n" +
            "            \"type\": 1,\n" +
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
            "            \"intro\": “崔教授回忆，当年同时期从事屈光手术专业的医生有许多转行从事其他专业，而自己坚持了下来。.”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot6.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"大咖来了|伊琳娜·波波娃担任合肥华夏 白癜风国际外籍专家\",\n" +
            "            \"type\": 0,\n" +
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
            "            \"intro\": “深圳同仁妇产医院重视人才的挖掘和培养，汇聚知名的妇科医师数十名，并组织业内十几位知名医院妇科医学....”\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot11.jpg\",\n" +
            "            ],\n" +
            "            \"title\": \"韩晓明-成都成华脑康医院\",\n" +
            "            \"type\": 1,\n" +
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
            "            \"intro\": \"人格类型不仅可以解释人们在与外界环境打交道时采用何种互动方式，还能从中洞察出睡眠习惯。2.检查室温：在凉爽和光线昏暗的屋子里最容易获得高质量睡眠，理..\"\n" +
            "        },\n" +
            "    {\n" +
            "            \"imageUrl\": [\n" +
            "                \"http://10.0.3.2:8080/iNews/photo/photo_hot7.jpg\"\n" +
            "            ],\n" +
            "            \"title\": \"【倒计时3天】美国·北京·上海儿科名医坐诊杭州保贝儿童医\",\n" +
            "            \"type\": 0,\n" +
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







