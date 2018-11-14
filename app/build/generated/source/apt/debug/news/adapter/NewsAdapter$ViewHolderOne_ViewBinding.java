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

public class NewsAdapter$ViewHolderOne_ViewBinding<T extends NewsAdapter.ViewHolderOne> implements Unbinder {
  protected T target;

  @UiThread
  public NewsAdapter$ViewHolderOne_ViewBinding(T target, View source) {
    this.target = target;

    target.itemNews1Title = Utils.findRequiredViewAsType(source, R.id.item_news1_title, "field 'itemNews1Title'", TextView.class);
    target.itemNews1Image1 = Utils.findRequiredViewAsType(source, R.id.item_news1_image1, "field 'itemNews1Image1'", ImageView.class);
    target.itemNews1Image2 = Utils.findRequiredViewAsType(source, R.id.item_news1_image2, "field 'itemNews1Image2'", ImageView.class);
    target.itemNews1Image3 = Utils.findRequiredViewAsType(source, R.id.item_news1_image3, "field 'itemNews1Image3'", ImageView.class);
    target.itemNews1Author = Utils.findRequiredViewAsType(source, R.id.item_news1_author, "field 'itemNews1Author'", TextView.class);
    target.itemNews1Time = Utils.findRequiredViewAsType(source, R.id.item_news1_time, "field 'itemNews1Time'", TextView.class);
    target.itemNews1Recommend = Utils.findRequiredViewAsType(source, R.id.item_news1_recommend, "field 'itemNews1Recommend'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemNews1Title = null;
    target.itemNews1Image1 = null;
    target.itemNews1Image2 = null;
    target.itemNews1Image3 = null;
    target.itemNews1Author = null;
    target.itemNews1Time = null;
    target.itemNews1Recommend = null;

    this.target = null;
  }
}
