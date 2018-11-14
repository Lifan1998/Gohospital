package main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import com.example.life.R

import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.msg.MsgService
import com.quinny898.library.persistentsearch.SearchBox
import com.quinny898.library.persistentsearch.SearchResult

import kotlinx.android.synthetic.main.layout_titie.*
import kotlinx.android.synthetic.main.activity_search.searchbox




import config.Preferences
import msg.MsgActivity
import user.LoginActivity

/**
 * @author lifan
 * @date 2018/10/21 22:49
 * @email 2224779926@qq.com
 * @desc
 */

class SearchActivity : FragmentActivity() {

    private var transaction: FragmentTransaction? = null
    private var type: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_search)
        type = intent.getIntExtra("type", -1)

        initView()

    }

    private fun initView() {
        val unreadNum = NIMClient.getService(MsgService::class.java).totalUnreadCount
        if (unreadNum == 0) {
            tv_msg_num.visibility = View.INVISIBLE
        } else {
            tv_msg_num?.text = unreadNum.toString() + ""
        }
        searchbox?.enableVoiceRecognition(this)

        for (x in 0..9) {
            val option = SearchResult("123Result " + Integer.toString(x), resources.getDrawable(R.drawable.ic_history))
            searchbox?.addSearchable(option)
        }
        searchbox?.setLogoText("搜索")
        searchbox?.setLogoTextColor(R.color.apptheme)
        //search.revealFromMenuItem(R.id.action_search, this);
        searchbox.setMenuListener {
            //Hamburger has been clicked
            Toast.makeText(this@SearchActivity, "Menu click", Toast.LENGTH_LONG).show()
        }
        searchbox!!.setSearchListener(object : SearchBox.SearchListener {

            override fun onSearchOpened() {
                //Use this to tint the screen
                Log.v("SearchBox", "onSearchOpened()")
            }

            override fun onSearchClosed() {
                //Use this to un-tint the screen
                Log.v("SearchBox", "onSearchOpened()")
            }

            override fun onSearchTermChanged(s: String) {
                Log.v("SearchBox", "onSearchTermChanged" + s)
            }


            override fun onSearch(searchTerm: String) {
                Toast.makeText(this@SearchActivity, searchTerm + " Searched", Toast.LENGTH_LONG).show()
                Log.v("SearchBox", "onSearch" + searchTerm)
                setSearchFragment(searchTerm)

            }

            override fun onResultClick(result: SearchResult) {
                //React to a result being clicked
                Log.v("SearchBox", "onResultClick" + result)
                setSearchFragment(result.title)
            }


            override fun onSearchCleared() {
                Log.v("SearchBox", "onSearchCleared()")
            }

        })
        searchbox!!.setOverflowMenu(R.menu.overflow_menu)
        searchbox!!.setOverflowMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.test_menu_item -> {
                    Toast.makeText(this@SearchActivity, "Clicked!", Toast.LENGTH_SHORT).show()
                    return@OnMenuItemClickListener true
                }
            }
            false
        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK) {
            val matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            searchbox!!.populateEditText(matches[0])
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setSearchFragment(searchContent: String) {
        val bundle = Bundle()
        bundle.putInt("type", type)
        bundle.putString("searchContent", searchContent)
        val search = SearchFragment()
        search.arguments = bundle
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.search_fragment, search)
        transaction!!.show(search)
        transaction!!.commit()
    }


    fun exit() {
        layout_return?.setOnClickListener{
            finish()
        }
        finish()
    }


    fun msgStart() {
        iv_msg.setOnClickListener{
            if (Preferences.getInstance().isSign) {
                startActivity(Intent(this, MsgActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        tv_msg_num.setOnClickListener{
            if (Preferences.getInstance().isSign) {
                startActivity(Intent(this, MsgActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

    }



}
