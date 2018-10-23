// Generated code from Butter Knife. Do not modify!
package news.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsAdapter$ViewHolderThree_ViewBinding<T extends NewsAdapter.ViewHolderThree> implements Unbinder {
  protected T target;

  @UiThread
  public NewsAdapter$ViewHolderThree_ViewBinding(T target, View source) {
    this.target = target;

    target.itemNews3Title = Utils.findRequiredViewAsType(source, R.id.item_news3_title, "field 'itemNews3Title'", TextView.class);
    target.itemNews3Intro = Utils.findRequiredViewAsType(source, R.id.item_news3_intro, "field 'itemNews3Intro'", TextView.class);
    target.itemNews3Author = Utils.findRequiredViewAsType(source, R.id.item_news3_author, "field 'itemNews3Author'", TextView.class);
    target.itemNews3Time = Utils.findRequiredViewAsType(source, R.id.item_news3_time, "field 'itemNews3Time'", TextView.class);
    target.itemNews3Comment = Utils.findRequiredViewAsType(source, R.id.item_news3_comment, "field 'itemNews3Comment'", TextView.class);
    target.itemNews3Recommend = Utils.findRequiredViewAsType(source, R.id.item_news3_recommend, "field 'itemNews3Recommend'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemNews3Title = null;
    target.itemNews3Intro = null;
    target.itemNews3Author = null;
    target.itemNews3Time = null;
    target.itemNews3Comment = null;
    target.itemNews3Recommend = null;

    this.target = null;
  }
}
