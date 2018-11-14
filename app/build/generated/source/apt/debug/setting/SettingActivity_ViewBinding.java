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

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  private View view2131296344;

  private View view2131296350;

  private View view2131296358;

  private View view2131296351;

  private View view2131296355;

  @UiThread
  public SettingActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'exit'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296662 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_msg, "field 'ivMsg' and method 'msgStart'");
    target.ivMsg = Utils.castView(view, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    view2131296631 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.msgStart();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_msg_num, "field 'tvMsgNum' and method 'msgStart'");
    target.tvMsgNum = Utils.castView(view, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    view2131297052 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.msgStart();
      }
    });
    target.layoutTitle = Utils.findRequiredViewAsType(source, R.id.layout_title, "field 'layoutTitle'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_about, "field 'btnAbout' and method 'setBtnAbout'");
    target.btnAbout = Utils.castView(view, R.id.btn_about, "field 'btnAbout'", TextView.class);
    view2131296344 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setBtnAbout();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_complain, "field 'btnComplain' and method 'setBtnComplain'");
    target.btnComplain = Utils.castView(view, R.id.btn_complain, "field 'btnComplain'", TextView.class);
    view2131296350 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setBtnComplain();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_update, "field 'btnUpdate' and method 'setBtnUpdate'");
    target.btnUpdate = Utils.castView(view, R.id.btn_update, "field 'btnUpdate'", TextView.class);
    view2131296358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setBtnUpdate();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_destroy, "field 'btnDestroy' and method 'logout'");
    target.btnDestroy = Utils.castView(view, R.id.btn_destroy, "field 'btnDestroy'", TextView.class);
    view2131296351 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.logout();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_logout, "field 'btnLogout' and method 'logout'");
    target.btnLogout = Utils.castView(view, R.id.btn_logout, "field 'btnLogout'", TextView.class);
    view2131296355 = view;
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

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296344.setOnClickListener(null);
    view2131296344 = null;
    view2131296350.setOnClickListener(null);
    view2131296350 = null;
    view2131296358.setOnClickListener(null);
    view2131296358 = null;
    view2131296351.setOnClickListener(null);
    view2131296351 = null;
    view2131296355.setOnClickListener(null);
    view2131296355 = null;

    this.target = null;
  }
}
