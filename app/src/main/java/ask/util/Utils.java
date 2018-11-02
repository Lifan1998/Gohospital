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


    public static List<AskItem> jsonToAskItems(String json){
        LinkedList<AskItem> askItems = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++){
                AskItem askItem = new AskItem();
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                Log.v("JsonParser",jsonObject.toString());
                String[] s = {jsonObject.optString("imgurl1"),jsonObject.optString("imgurl2"),jsonObject.optString("imgurl3")};
                ArrayList<String> images = new ArrayList<>();
                for(String ss :s){
                    if(!"null".equals(ss)){
                        images.add(ss);
                    }

                }
                Log.v("Json",images.toString()+images.size());
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

    public static String dataToString(long data){
        Date date = new Date(data);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = simpleDateFormat.format(date);
        //如果是今天或者昨天的显示yyyy-MM-dd HH:mm  其余是显示yyyy-MM-dd
        if(date1.equals(simpleDateFormat.format(new Date()))){
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date1 = "当天"+simpleDateFormat1.format(date);
        }
        if((System.currentTimeMillis()/86400000)-(date.getTime()/86400000)>=0&&(System.currentTimeMillis()/86400000)-(date.getTime()/86400000)<=1){
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date1 = "昨天"+simpleDateFormat1.format(date);
        }
       return date1;

    }
}
