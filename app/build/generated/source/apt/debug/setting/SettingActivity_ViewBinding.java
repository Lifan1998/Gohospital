// Generated code from Butter Knife. Do not modify!
package setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding<T extends SettingActivity> implements Unbinder {
  protected T target;

  private View view2131296544;

  private View view2131296514;

  private View view2131296766;

  private View view2131296328;

  @UiThread
  public SettingActivity_ViewBinding(final T target, View source) {
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
    view = Utils.findRequiredView(source, R.id.iv_msg, "field 'ivMsg' and method 'startMessage'");
    target.ivMsg = Utils.castView(view, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    view2131296514 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startMessage();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_msg_num, "field 'tvMsgNum' and method 'startMessage'");
    target.tvMsgNum = Utils.castView(view, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    view2131296766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startMessage();
      }
    });
    target.layoutTitle = Utils.findRequiredViewAsType(source, R.id.layout_title, "field 'layoutTitle'", RelativeLayout.class);
    target.btnAbout = Utils.findRequiredViewAsType(source, R.id.btn_about, "field 'btnAbout'", TextView.class);
    target.btnComplain = Utils.findRequiredViewAsType(source, R.id.btn_complain, "field 'btnComplain'", TextView.class);
    target.btnUpdate = Utils.findRequiredViewAsType(source, R.id.btn_update, "field 'btnUpdate'", TextView.class);
    target.btnDestroy = Utils.findRequiredViewAsType(source, R.id.btn_destroy, "field 'btnDestroy'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_logout, "field 'btnLogout' and method 'logout'");
    target.btnLogout = Utils.castView(view, R.id.btn_logout, "field 'btnLogout'", TextView.class);
    view2131296328 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.logout();
      }
    });
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
    target.btnAbout = null;
    target.btnComplain = null;
    target.btnUpdate = null;
    target.btnDestroy = null;
    target.btnLogout = null;

    view2131296544.setOnClickListener(null);
    view2131296544 = null;
    view2131296514.setOnClickListener(null);
    view2131296514 = null;
    view2131296766.setOnClickListener(null);
    view2131296766 = null;
    view2131296328.setOnClickListener(null);
    view2131296328 = null;

    this.target = null;
  }
}
