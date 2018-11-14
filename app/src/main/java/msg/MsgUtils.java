package msg;

import android.util.Log;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;

/**
 * @author lifan
 * @date 2018/11/9 23:25
 * @email 2224779926@qq.com
 * @desc
 */

public class MsgUtils {

    public static void addFriend(String account){
        final VerifyType verifyType = VerifyType.DIRECT_ADD;
        String msg = "好友请求附言";
        NIMClient.getService(FriendService.class).addFriend(new AddFriendData(account, verifyType, msg))
                .setCallback(new RequestCallback<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.v("addFriend","------");
                    }
                    @Override
                    public void onFailed(int i) {
                    }
                    @Override
                    public void onException(Throwable throwable) {
                    }
                });
    }
}
