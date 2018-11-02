// Generated code from Butter Knife. Do not modify!
package ask;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AskFragment_ViewBinding<T extends AskFragment> implements Unbinder {
  protected T target;

  private View view2131296680;

  @UiThread
  public AskFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.searchedit, "method 'search'");
    view2131296680 = view;
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
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    view2131296680.setOnClickListener(null);
    view2131296680 = null;

    this.target = null;
  }
}
