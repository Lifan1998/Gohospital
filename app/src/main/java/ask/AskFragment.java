package ask;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.life.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import main.SearchActivity;


/**
 * Created by lenovo on 2018/7/12.
 */

public class AskFragment extends Fragment implements View.OnClickListener {
    String[] mTitle = new String[]{"推荐","儿科", "骨科", "妇产科", "皮肤科", "消化内科", "心血管", "精神心理科", "眼科", "耳鼻喉科"};
    TabLayout mTabLayout;
    ViewPager mViewPager;

    FloatingActionButton fab;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ask, container, false);
        fab = view.findViewById(R.id.fab);
        initView(view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onClick(View v) {

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
                fragment.setTitle(mTitle[position % mTitle.length]);
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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AskNewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick(R.id.searchedit)
    public void search(){
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("type",4);
        startActivity(intent);
    }
}
