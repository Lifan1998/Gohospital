package my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.life.R;

import appoint.AppointTabFragment;
import appoint.DoctorTabFragment;
import appoint.HospitalTabFragment;
import ask.TabFragment;
import butterknife.ButterKnife;

/**
 * @author lifan
 * @date 2018/10/21 10:23
 * @email 2224779926@qq.com
 * @desc
 */

public class MyLoveFragment extends Fragment {
    private static final String TAG = MyLoveFragment.class.getSimpleName();
    String[] mTitle ;
    private int type;
    private static final int TYPE_APPOINT = 1;
    private static final int TYPE_LOVE = 2;
    private static final int TYPE_ASK = 3;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        type = getArguments().getInt("type");

        initView(view);

        return view;
    }

    private void initView(View v) {
        switch (type){
            case TYPE_APPOINT: mTitle = new String[]{"未完成","已完成"};break;

            case TYPE_LOVE : mTitle = new String[]{"文章","问答","医院","医生"};break;
            case TYPE_ASK: mTitle = new String[]{"我的问答"};break;
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
                Log.v(TAG,mTitle[position % mTitle.length]+"---"+position);
                //创建Fragment并返回
                if (type == TYPE_LOVE) {
                    switch (position) {
                        case 0:
                            news.TabFragment newsTabFragment = new news.TabFragment();
                            newsTabFragment.setType(mTitle[position % mTitle.length]);
                            return newsTabFragment;
                        case 1:
                            ask.TabFragment askTabFragment = new ask.TabFragment();
                            askTabFragment.setTitle(mTitle[position % mTitle.length]);
                            Log.v(TAG,"askTabstart"+"---"+position);
                            return askTabFragment;
                        case 2:
                            HospitalTabFragment hospitalTabFragment =new HospitalTabFragment();
                            hospitalTabFragment.setType(mTitle[position % mTitle.length]);
                            Log.v(TAG,"HTabstart"+"---"+position);
                            return hospitalTabFragment;
                        case 3:
                            DoctorTabFragment doctorTabFragment =  new DoctorTabFragment();
                            doctorTabFragment.setType(mTitle[position % mTitle.length]);
                            Log.v(TAG,"DTabstart"+"---"+position);
                            return doctorTabFragment;
                    }
                }
                if (type == TYPE_APPOINT) {
                    switch (position) {

                        case 0:
                            AppointTabFragment appointTabFragment = new AppointTabFragment();
                            appointTabFragment.setType(mTitle[position % mTitle.length]);
                            return appointTabFragment;
                        case 1:
                            AppointTabFragment appointTabFragment1 = new AppointTabFragment();
                            appointTabFragment1.setType(mTitle[position % mTitle.length]);
                            return appointTabFragment1;

                    }
                }

                if (type == TYPE_ASK) {
                    switch (position) {
                        case 0:
                            ask.TabFragment askTabFragment = new ask.TabFragment();
                            askTabFragment.setTitle(mTitle[position % mTitle.length]);
                            return askTabFragment;

                    }
                }
                ask.TabFragment askTabFragment = new ask.TabFragment();
                askTabFragment.setTitle(mTitle[position % mTitle.length]);
                return askTabFragment;

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
