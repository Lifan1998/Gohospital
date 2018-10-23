// Generated code from Butter Knife. Do not modify!
package home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131230959;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.ivRichscan = Utils.findRequiredViewAsType(source, R.id.iv_richscan, "field 'ivRichscan'", ImageView.class);
    target.layoutSearchEdit = Utils.findRequiredViewAsType(source, R.id.layout_search_edit, "field 'layoutSearchEdit'", FrameLayout.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_forecast, "field 'ivForecast' and method 'onClickF'");
    target.ivForecast = Utils.castView(view, R.id.iv_forecast, "field 'ivForecast'", ImageView.class);
    view2131230959 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickF();
      }
    });
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivRichscan = null;
    target.layoutSearchEdit = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.ivForecast = null;
    target.banner = null;

    view2131230959.setOnClickListener(null);
    view2131230959 = null;

    this.target = null;
  }
}
