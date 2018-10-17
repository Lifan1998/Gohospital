// Generated code from Butter Knife. Do not modify!
package appoint;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeptActivity_ViewBinding<T extends DeptActivity> implements Unbinder {
  protected T target;

  private View view2131230966;

  @UiThread
  public DeptActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.liDoctors = Utils.findRequiredViewAsType(source, R.id.li_doctors, "field 'liDoctors'", ListView.class);
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'OnClicked1'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131230966 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClicked1();
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.liDoctors = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;

    view2131230966.setOnClickListener(null);
    view2131230966 = null;

    this.target = null;
  }
}
