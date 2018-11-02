package news;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import main.SearchActivity;
import main.SearchFragment;

/**
 * Created by lenovo on 2018/7/12.
 */

public class NewsFragment extends Fragment implements View.OnClickListener {
    String[] mTitle = new String[]{"推荐", "减肥", "养生", "母婴", "美容", "防癌", "男性", "女性", "运动", "营养", "其他"};
    TabLayout mTabLayout;
    ViewPager mViewPager;
    @BindView(R.id.iv_richscan)
    ImageView ivRichscan;
    @BindView(R.id.searchedit)
    EditText searchedit;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initData();
        initView(view);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onClick(View v) {

    }

    private void initData() {

    }

    private void initView(View v) {
        mTabLayout = v.findViewById(R.id.tl_tab);
        mViewPager = v.findViewById(R.id.vp_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position % mTitle.length];
            }

            @Override
            public Fragment getItem(int position) {
                //创建Fragment并返回
                TabFragment fragment = new TabFragment();
                fragment.setType(mTitle[position % mTitle.length]);
                //fragment.init();
                return fragment;
            }

            @Override
            public int getCount() {
                return mTitle.length;
            }
        });
        //将ViewPager关联到TabLayout上
        mTabLayout.setupWithViewPager(mViewPager);

        //  设置监听,注意:如果设置了setOnTabSelectedListener,则setupWithViewPager不会生效
        //  因为setupWithViewPager内部也是通过设置该监听来触发ViewPager的切换的.

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换ViewPager
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick(R.id.searchedit)
    public void search() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("type", SearchFragment.TYPE_News);
        getActivity().startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
