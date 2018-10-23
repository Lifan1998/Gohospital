package ask.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ask.model.AskItem;
import news.model.Result;

/**
 * @author lifan
 * @date 2018/10/5 0:50
 * @email 2224779926@qq.com
 * @desc
 */

public class Utils {

    static  String[] names = new String[]{"小小国旺","李帆de","李洪波","会飞的猪","黑暗之神"};
    static String[] titles = new String[]{"换季容易感冒怎么办？","爬山时脚扭了如何应对？","经常感觉胸闷有可能是什么原因？","婴儿发烧到底要不要散热？","哪些食物对肝有滋养作用的？"};
    public static List<AskItem> getAskItems(){
        ArrayList<AskItem> askItems = new ArrayList<>();
        for (int i=3;i<8;i++){
            AskItem askItem = new AskItem();
            askItem.setCollect(i*4);
            askItem.setComment(i*6);
            askItem.setName(names[i-3]);
            askItem.setTime("2018-9-"+i);
            askItem.setTitle(titles[i-3]);
            askItems.add(askItem);
        }
        return askItems;
    }

    public static List<AskItem> jsonToAskItems(String json){
        LinkedList<AskItem> askItems = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++){
                AskItem askItem = new AskItem();

                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                Log.v("JsonParser",jsonObject.toString());
                String[] s = {jsonObject.optString("img1Url"),jsonObject.optString("img2Url"),jsonObject.optString("img3Url")};
                ArrayList<String> images = new ArrayList<>();
                for(String ss :s){
                    if(!"null".equals(ss)){
                        images.add(ss);
                    }

                }
                askItem.setImageurl(images);
                askItem.setId(jsonObject.getInt("tid"));
                askItem.setTitle(jsonObject.optString("ttitle"));
                askItem.setTime(dataToString(jsonObject.getLong("tdate")));
                askItem.setName(jsonObject.getString("uname"));
                askItem.setComment(jsonObject.getInt("commentCount"));
                askItem.setCollect(jsonObject.getInt("forumCollect"));
                askItem.setIntro(jsonObject.getString("tcontent"));
                askItem.setUserUrl(jsonObject.getString("pic"));





                askItems.add(askItem);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return askItems;
    }

    private static String dataToString(long data){
        java.util.Date data1 = new Date(data);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(data1);
    }
}
