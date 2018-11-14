// Generated code from Butter Knife. Do not modify!
package news.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsAdapter$ViewHolderTwo_ViewBinding<T extends NewsAdapter.ViewHolderTwo> implements Unbinder {
  protected T target;

  @UiThread
  public NewsAdapter$ViewHolderTwo_ViewBinding(T target, View source) {
    this.target = target;

    target.itemNews2Title = Utils.findRequiredViewAsType(source, R.id.item_news2_title, "field 'itemNews2Title'", TextView.class);
    target.itemNews2Author = Utils.findRequiredViewAsType(source, R.id.item_news2_author, "field 'itemNews2Author'", TextView.class);
    target.itemNews2Time = Utils.findRequiredViewAsType(source, R.id.item_news2_time, "field 'itemNews2Time'", TextView.class);
    target.itemNews2Recommend = Utils.findRequiredViewAsType(source, R.id.item_news2_recommend, "field 'itemNews2Recommend'", TextView.class);
    target.itemNews2Image1 = Utils.findRequiredViewAsType(source, R.id.item_news2_image1, "field 'itemNews2Image1'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemNews2Title = null;
    target.itemNews2Author = null;
    target.itemNews2Time = null;
    target.itemNews2Recommend = null;
    target.itemNews2Image1 = null;

    this.target = null;
  }
}
