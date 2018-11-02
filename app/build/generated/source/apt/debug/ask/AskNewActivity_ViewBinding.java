// Generated code from Butter Knife. Do not modify!
package ask;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AskNewActivity_ViewBinding<T extends AskNewActivity> implements Unbinder {
  protected T target;

  private View view2131296544;

  private View view2131296591;

  @UiThread
  public AskNewActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'exit'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296544 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    target.editAskTitle = Utils.findRequiredViewAsType(source, R.id.edit_ask_title, "field 'editAskTitle'", EditText.class);
    target.editAskIntro = Utils.findRequiredViewAsType(source, R.id.edit_ask_intro, "field 'editAskIntro'", EditText.class);
    target.tvAskType = Utils.findRequiredViewAsType(source, R.id.tv_ask_type, "field 'tvAskType'", TextView.class);
    view = Utils.findRequiredView(source, R.id.my_ask_type, "field 'myAskType' and method 'type'");
    target.myAskType = Utils.castView(view, R.id.my_ask_type, "field 'myAskType'", LinearLayout.class);
    view2131296591 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.type();
      }
    });
    target.btnAskCommit = Utils.findRequiredViewAsType(source, R.id.btn_ask_commit, "field 'btnAskCommit'", TextView.class);
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
    target.editAskTitle = null;
    target.editAskIntro = null;
    target.tvAskType = null;
    target.myAskType = null;
    target.btnAskCommit = null;

    view2131296544.setOnClickListener(null);
    view2131296544 = null;
    view2131296591.setOnClickListener(null);
    view2131296591 = null;

    this.target = null;
  }
}
