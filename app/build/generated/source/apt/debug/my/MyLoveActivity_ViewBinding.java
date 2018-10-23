// Generated code from Butter Knife. Do not modify!
package my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyLoveActivity_ViewBinding<T extends MyLoveActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MyLoveActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.layoutReturn = Utils.findRequiredViewAsType(source, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    target.layoutTitle = Utils.findRequiredViewAsType(source, R.id.layout_title, "field 'layoutTitle'", RelativeLayout.class);
    target.mylovefragment = Utils.findRequiredViewAsType(source, R.id.mylovefragment, "field 'mylovefragment'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.layoutTitle = null;
    target.mylovefragment = null;

    this.target = null;
  }
}
