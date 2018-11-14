// Generated code from Butter Knife. Do not modify!
package ask.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommentAdapter$ViewHolder_ViewBinding<T extends CommentAdapter.ViewHolder> implements Unbinder {
  protected T target;

  private View view2131296622;

  @UiThread
  public CommentAdapter$ViewHolder_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.itemAskImage = Utils.findRequiredViewAsType(source, R.id.item_ask_image, "field 'itemAskImage'", CircleImageView.class);
    target.itemAskName = Utils.findRequiredViewAsType(source, R.id.item_ask_name, "field 'itemAskName'", TextView.class);
    target.itemAskIdentity = Utils.findRequiredViewAsType(source, R.id.item_ask_identity, "field 'itemAskIdentity'", TextView.class);
    target.itemAskTime = Utils.findRequiredViewAsType(source, R.id.item_ask_time, "field 'itemAskTime'", TextView.class);
    target.itemCommentCommendSum = Utils.findRequiredViewAsType(source, R.id.item_comment_commend_sum, "field 'itemCommentCommendSum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_commend, "field 'ivCommend' and method 'selectCommend'");
    target.ivCommend = Utils.castView(view, R.id.iv_commend, "field 'ivCommend'", ImageView.class);
    view2131296622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectCommend();
      }
    });
    target.itemAskComment = Utils.findRequiredViewAsType(source, R.id.item_ask_comment, "field 'itemAskComment'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemAskImage = null;
    target.itemAskName = null;
    target.itemAskIdentity = null;
    target.itemAskTime = null;
    target.itemCommentCommendSum = null;
    target.ivCommend = null;
    target.itemAskComment = null;

    view2131296622.setOnClickListener(null);
    view2131296622 = null;

    this.target = null;
  }
}
