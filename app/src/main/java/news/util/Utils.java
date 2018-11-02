package news.util;

import android.provider.ContactsContract;
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

import appoint.entity.Hospital;
import news.model.Result;

/**
 * @author lifan
 * @date 2018/10/19 19:48
 * @email 2224779926@qq.com
 * @desc
 */

public class Utils {
    public static List<Result> jsonToResult(String json){
        LinkedList<Result> results = new LinkedList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i=0;i<jsonArray.length();i++){
                Result result = new Result();

                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                Log.v("JsonParser",jsonObject.toString());
                String[] s = {jsonObject.optString("img1Url"),jsonObject.optString("img2Url"),jsonObject.optString("img3Url")};
                ArrayList<String> images = new ArrayList<>();
                for(String ss :s){
                    Log.v("JsonParser",ss);
                    if (!"null".equals(ss)){
                       images.add(ss);
                    }
                }
                if(images.size()== 2){
                    images.remove(1);
                }
                result.setImageUrl(images);
                result.setType(images.size());
                result.setAuthor(jsonObject.optString("aauthor"));
                result.setComment(new Random().nextInt(100));
                result.setRecommend(new Random().nextInt(1000));
                result.setTitle(jsonObject.optString("aname"));
                result.setId(jsonObject.getInt("aid"));
                result.setIntro(jsonObject.getString("aname"));
                result.setAurl(jsonObject.getString("aurl"));
                result.setTime(dataToString(jsonObject.getLong("atime")));
                results.add(result);
                Log.v("JsonParser",result.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return results;
    }

    private static String dataToString(long data){

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
