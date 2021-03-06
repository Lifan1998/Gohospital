// Generated code from Butter Knife. Do not modify!
package home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
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

  private View view2131296631;

  private View view2131297052;

  private View view2131296626;

  private View view2131296307;

  private View view2131296905;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.ivRichscan = Utils.findRequiredViewAsType(source, R.id.iv_richscan, "field 'ivRichscan'", ImageView.class);
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
    view = Utils.findRequiredView(source, R.id.iv_forecast, "field 'ivForecast' and method 'onClickF'");
    target.ivForecast = Utils.castView(view, R.id.iv_forecast, "field 'ivForecast'", ImageView.class);
    view2131296626 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickF();
      }
    });
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
    view = Utils.findRequiredView(source, R.id.appointimage, "method 'appoint'");
    view2131296307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.appoint();
      }
    });
    view = Utils.findRequiredView(source, R.id.searchedit, "method 'search'");
    view2131296905 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.search();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivRichscan = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.ivForecast = null;
    target.banner = null;

    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296626.setOnClickListener(null);
    view2131296626 = null;
    view2131296307.setOnClickListener(null);
    view2131296307 = null;
    view2131296905.setOnClickListener(null);
    view2131296905 = null;

    this.target = null;
  }
}
