// Generated code from Butter Knife. Do not modify!
package main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import com.quinny898.library.persistentsearch.SearchBox;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity__ViewBinding<T extends SearchActivity_> implements Unbinder {
  protected T target;

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  @UiThread
  public SearchActivity__ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.searchFragment = Utils.findRequiredViewAsType(source, R.id.search_fragment, "field 'searchFragment'", FrameLayout.class);
    target.search = Utils.findRequiredViewAsType(source, R.id.searchbox, "field 'search'", SearchBox.class);
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
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.searchFragment = null;
    target.search = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.layoutTitle = null;

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;

    this.target = null;
  }
}
