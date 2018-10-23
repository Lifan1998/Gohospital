// Generated code from Butter Knife. Do not modify!
package ask.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AskAdapter$ViewHolder_ViewBinding<T extends AskAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public AskAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.itemAskImage = Utils.findRequiredViewAsType(source, R.id.item_ask_image, "field 'itemAskImage'", CircleImageView.class);
    target.itemAskName = Utils.findRequiredViewAsType(source, R.id.item_ask_name, "field 'itemAskName'", TextView.class);
    target.itemAskTime = Utils.findRequiredViewAsType(source, R.id.item_ask_time, "field 'itemAskTime'", TextView.class);
    target.itemAskTitle = Utils.findRequiredViewAsType(source, R.id.item_ask_title, "field 'itemAskTitle'", TextView.class);
    target.itemAskIntro = Utils.findRequiredViewAsType(source, R.id.item_ask_intro, "field 'itemAskIntro'", TextView.class);
    target.itemAskImage1 = Utils.findRequiredViewAsType(source, R.id.item_ask_image1, "field 'itemAskImage1'", ImageView.class);
    target.itemAskImage2 = Utils.findRequiredViewAsType(source, R.id.item_ask_image2, "field 'itemAskImage2'", ImageView.class);
    target.itemAskImage3 = Utils.findRequiredViewAsType(source, R.id.item_ask_image3, "field 'itemAskImage3'", ImageView.class);
    target.itemAskCollect = Utils.findRequiredViewAsType(source, R.id.item_ask_collect, "field 'itemAskCollect'", TextView.class);
    target.itemAskComment = Utils.findRequiredViewAsType(source, R.id.item_ask_comment, "field 'itemAskComment'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemAskImage = null;
    target.itemAskName = null;
    target.itemAskTime = null;
    target.itemAskTitle = null;
    target.itemAskIntro = null;
    target.itemAskImage1 = null;
    target.itemAskImage2 = null;
    target.itemAskImage3 = null;
    target.itemAskCollect = null;
    target.itemAskComment = null;

    this.target = null;
  }
}
