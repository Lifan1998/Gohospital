package main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.life.R;

import appoint.DoctorTabFragment;
import appoint.HospitalTabFragment;
import appoint.entity.Doctor;
import appoint.entity.Hospital;
import my.MyLoveFragment;

/**
 * @author lifan
 * @date 2018/10/22 9:31
 * @email 2224779926@qq.com
 * @desc
 */

public class SearchFragment extends Fragment {
    private static final String TAG = SearchFragment.class.getSimpleName();
    String[] mTitle ;
    private int type;
    private String searchContent;
    public static final int TYPE_All = 1;
    public static final int TYPE_Doctor = 2;
    public static final int TYPE_News = 3;
    public static final int TYPE_ASK = 4;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        type = getArguments().getInt("type");
        searchContent = getArguments().getString("searchContent");
        initView(view);

        return view;
    }

    private void initView(View v) {
        switch (type){
            case TYPE_All: mTitle = new String[]{"文章","问答","医院","医生"};break;
            case TYPE_Doctor: mTitle = new String[]{"医院","医生"};break;
            case TYPE_News : mTitle = new String[]{"文章"};break;
            case TYPE_ASK: mTitle = new String[]{"问答"};break;
        }



        mTabLayout = v.findViewById(R.id.tab_layout);
        mViewPager = v.findViewById(R.id.vp_pager1);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position % mTitle.length];
            }

            @Override
            public Fragment getItem(int position) {

                //创建Fragment并返回
                if (type == TYPE_All) {
                    switch (position){

                        case 0:
                            news.TabFragment newsTabFragment = new news.TabFragment();
                            newsTabFragment.setType(mTitle[position % mTitle.length]);
                            newsTabFragment.setSearchContent(searchContent);
                            return newsTabFragment;
                        case 1:
                            ask.TabFragment askTabFragment = new ask.TabFragment();
                            askTabFragment.setTitle(mTitle[position % mTitle.length]);
                            askTabFragment.setSearchContent(searchContent);
                            return askTabFragment;
                        case 2:
                            HospitalTabFragment hospitalTabFragment =new HospitalTabFragment();
                            hospitalTabFragment.setType(mTitle[position % mTitle.length]);
                            hospitalTabFragment.setSearchContent(searchContent);
                            return hospitalTabFragment;
                        case 3:
                            DoctorTabFragment doctorTabFragment =  new DoctorTabFragment();
                            doctorTabFragment.setType(mTitle[position % mTitle.length]);
                            doctorTabFragment.setSearchContent(searchContent);
                            return doctorTabFragment;
                    }
                }
                if (type == TYPE_Doctor) {
                    switch (position) {

                        case 0:
                            HospitalTabFragment hospitalTabFragment =new HospitalTabFragment();
                            hospitalTabFragment.setType(mTitle[position % mTitle.length]);
                            hospitalTabFragment.setSearchContent(searchContent);
                            return hospitalTabFragment;
                        case 1:
                            DoctorTabFragment doctorTabFragment =  new DoctorTabFragment();
                            doctorTabFragment.setType(mTitle[position % mTitle.length]);
                            doctorTabFragment.setSearchContent(searchContent);
                            return doctorTabFragment;

                    }
                }

                if (type == TYPE_News) {
                    switch (position) {
                        case 0:
                            news.TabFragment newsTabFragment = new news.TabFragment();
                            newsTabFragment.setType(mTitle[position % mTitle.length]);
                            newsTabFragment.setSearchContent(searchContent);
                            return newsTabFragment;

                    }
                }
                if (type == TYPE_ASK) {
                    switch (position) {
                        case 0:
                            ask.TabFragment askTabFragment = new ask.TabFragment();
                            askTabFragment.setTitle(mTitle[position % mTitle.length]);
                            askTabFragment.setSearchContent(searchContent);
                            return askTabFragment;

                    }
                }


                return null;
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
}
