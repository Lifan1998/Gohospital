// Generated code from Butter Knife. Do not modify!
package news;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
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

public class NewsOpenActivity_ViewBinding<T extends NewsOpenActivity> implements Unbinder {
  protected T target;

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  private View view2131296630;

  private View view2131296622;

  @UiThread
  public NewsOpenActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'close'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296662 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.close();
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
    target.newswebview = Utils.findRequiredViewAsType(source, R.id.newswebview, "field 'newswebview'", WebView.class);
    view = Utils.findRequiredView(source, R.id.iv_love, "field 'ivLove' and method 'selectLove'");
    target.ivLove = Utils.castView(view, R.id.iv_love, "field 'ivLove'", ImageView.class);
    view2131296630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectLove();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_commend, "field 'ivCommend' and method 'selectCommend'");
    target.ivCommend = Utils.castView(view, R.id.iv_commend, "field 'ivCommend'", ImageView.class);
    view2131296622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectCommend();
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
    target.newswebview = null;
    target.ivLove = null;
    target.ivCommend = null;

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296630.setOnClickListener(null);
    view2131296630 = null;
    view2131296622.setOnClickListener(null);
    view2131296622 = null;

    this.target = null;
  }
}
