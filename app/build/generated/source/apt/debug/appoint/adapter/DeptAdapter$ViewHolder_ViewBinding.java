// Generated code from Butter Knife. Do not modify!
package appoint.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeptAdapter$ViewHolder_ViewBinding<T extends DeptAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public DeptAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.itemKeshi = Utils.findRequiredViewAsType(source, R.id.item_keshi, "field 'itemKeshi'", TextView.class);

    Context context = source.getContext();
    Resources res = context.getResources();
    Resources.Theme theme = context.getTheme();
    target.red = Utils.getColor(res, theme, R.color.text_red);
    target.white = Utils.getColor(res, theme, R.color.text_white);
    target.trans = Utils.getColor(res, theme, R.color.transparent);
    target.brank = Utils.getColor(res, theme, R.color.brank);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemKeshi = null;

    this.target = null;
  }
}
