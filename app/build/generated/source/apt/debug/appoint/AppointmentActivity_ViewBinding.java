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

public class AppointmentActivity_ViewBinding<T extends AppointmentActivity> implements Unbinder {
  protected T target;

  private View view2131231035;

  private View view2131230945;

  private View view2131230921;

  private View view2131231102;

  @UiThread
  public AppointmentActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.search_image, "field 'searchImage' and method 'onViewClicked'");
    target.searchImage = Utils.castView(view, R.id.search_image, "field 'searchImage'", ImageView.class);
    view2131231035 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.appointmentListView = Utils.findRequiredViewAsType(source, R.id.appointment_listView, "field 'appointmentListView'", ListView.class);
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'onViewClicked'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131230945 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_msg, "field 'ivMsg' and method 'onViewClicked'");
    target.ivMsg = Utils.castView(view, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_msg_num, "field 'tvMsgNum' and method 'onViewClicked'");
    target.tvMsgNum = Utils.castView(view, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    view2131231102 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.searchImage = null;
    target.appointmentListView = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;

    view2131231035.setOnClickListener(null);
    view2131231035 = null;
    view2131230945.setOnClickListener(null);
    view2131230945 = null;
    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131231102.setOnClickListener(null);
    view2131231102 = null;

    this.target = null;
  }
}
