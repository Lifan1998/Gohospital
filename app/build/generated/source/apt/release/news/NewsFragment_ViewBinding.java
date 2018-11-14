// Generated code from Butter Knife. Do not modify!
package news;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsFragment_ViewBinding<T extends NewsFragment> implements Unbinder {
  protected T target;

  private View view2131296905;

  private View view2131296631;

  private View view2131297052;

  @UiThread
  public NewsFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.ivRichscan = Utils.findRequiredViewAsType(source, R.id.iv_richscan, "field 'ivRichscan'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.searchedit, "field 'searchedit' and method 'search'");
    target.searchedit = Utils.castView(view, R.id.searchedit, "field 'searchedit'", EditText.class);
    view2131296905 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.search();
      }
    });
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
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivRichscan = null;
    target.searchedit = null;
    target.ivMsg = null;
    target.tvMsgNum = null;

    view2131296905.setOnClickListener(null);
    view2131296905 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;

    this.target = null;
  }
}
