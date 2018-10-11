package ask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ask.model.AskItem;

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
}
