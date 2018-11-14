package main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.life.R

import appoint.DoctorTabFragment
import appoint.HospitalTabFragment
import appoint.entity.Doctor
import appoint.entity.Hospital
import my.MyLoveFragment
import java.util.*

@Suppress("DEPRECATION")
/**
 * @author lifan
 * @date 2018/10/22 9:31
 * @email 2224779926@qq.com
 * @desc
 */

class SearchFragment : Fragment() {
    internal var mTitle: Array<String> = null!!
    private var type: Int = 0
    private var searchContent: String? = null
    internal var mTabLayout: TabLayout = null!!
    internal var mViewPager: ViewPager = null!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search_result, container, false)
        type = arguments!!.getInt("type")
        searchContent = arguments!!.getString("searchContent")
        initView(view)

        return view
    }

    private fun initView(v: View) {
        when (type) {
            TYPE_All -> mTitle = arrayOf("文章", "问答", "医院", "医生")
            TYPE_Doctor -> mTitle = arrayOf("医院", "医生")
            TYPE_News -> mTitle = arrayOf("文章")
            TYPE_ASK -> mTitle = arrayOf("问答")
        }



        mTabLayout = v.findViewById(R.id.tab_layout)
        mViewPager = v.findViewById(R.id.vp_pager1)
        mViewPager.adapter = object : FragmentPagerAdapter(childFragmentManager) {
            //此方法用来显示tab上的名字
            override fun getPageTitle(position: Int): CharSequence? {
                return mTitle[position % mTitle.size]
            }

            override fun getItem(position: Int): Fragment? {

                //创建Fragment并返回
                if (type == TYPE_All) {
                    when (position) {

                        0 -> {
                            val newsTabFragment = news.TabFragment()
                            newsTabFragment.setType(mTitle[position % mTitle.size])
                            newsTabFragment.setSearchContent(searchContent)
                            return newsTabFragment
                        }
                        1 -> {
                            val askTabFragment = ask.TabFragment()
                            askTabFragment.setTitle(mTitle[position % mTitle.size])
                            askTabFragment.setSearchContent(searchContent)
                            return askTabFragment
                        }
                        2 -> {
                            val hospitalTabFragment = HospitalTabFragment()
                            hospitalTabFragment.setType(mTitle[position % mTitle.size])
                            hospitalTabFragment.setSearchContent(searchContent)
                            return hospitalTabFragment
                        }
                        3 -> {
                            val doctorTabFragment = DoctorTabFragment()
                            doctorTabFragment.setType(mTitle[position % mTitle.size])
                            doctorTabFragment.setSearchContent(searchContent)
                            return doctorTabFragment
                        }
                    }
                }
                if (type == TYPE_Doctor) {
                    when (position) {

                        0 -> {
                            val hospitalTabFragment = HospitalTabFragment()
                            hospitalTabFragment.setType(mTitle[position % mTitle.size])
                            hospitalTabFragment.setSearchContent(searchContent)
                            return hospitalTabFragment
                        }
                        1 -> {
                            val doctorTabFragment = DoctorTabFragment()
                            doctorTabFragment.setType(mTitle[position % mTitle.size])
                            doctorTabFragment.setSearchContent(searchContent)
                            return doctorTabFragment
                        }
                    }
                }

                if (type == TYPE_News) {
                    when (position) {
                        0 -> {
                            val newsTabFragment = news.TabFragment()
                            newsTabFragment.setType(mTitle[position % mTitle.size])
                            newsTabFragment.setSearchContent(searchContent)
                            return newsTabFragment
                        }
                    }
                }
                if (type == TYPE_ASK) {
                    when (position) {
                        0 -> {
                            val askTabFragment = ask.TabFragment()
                            askTabFragment.setTitle(mTitle[position % mTitle.size])
                            askTabFragment.setSearchContent(searchContent)
                            return askTabFragment
                        }
                    }
                }


                return null
            }

            override fun getCount(): Int {
                return mTitle.size
            }
        }
        //将ViewPager关联到TabLayout上
        mTabLayout.setupWithViewPager(mViewPager)

        //  设置监听,注意:如果设置了setOnTabSelectedListener,则setupWithViewPager不会生效
        //  因为setupWithViewPager内部也是通过设置该监听来触发ViewPager的切换的.
        /**
        mTabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                //切换ViewPager
                mViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        */
    }

    companion object {
        private val TAG = SearchFragment::class.java.simpleName
        val TYPE_All = 1
        val TYPE_Doctor = 2
        val TYPE_News = 3
        val TYPE_ASK = 4
    }
}
