// Generated code from Butter Knife. Do not modify!
package main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import com.quinny898.library.persistentsearch.SearchBox;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding<T extends SearchActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SearchActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.searchFragment = Utils.findRequiredViewAsType(source, R.id.search_fragment, "field 'searchFragment'", FrameLayout.class);
    target.search = Utils.findRequiredViewAsType(source, R.id.searchbox, "field 'search'", SearchBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.searchFragment = null;
    target.search = null;

    this.target = null;
  }
}
