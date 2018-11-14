// Generated code from Butter Knife. Do not modify!
package ask;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AskOpenActivity_ViewBinding<T extends AskOpenActivity> implements Unbinder {
  protected T target;

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  private View view2131296630;

  private View view2131296622;

  private View view2131296761;

  private View view2131296348;

  @UiThread
  public AskOpenActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'close'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296662 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.close();
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
    target.askTitle = Utils.findRequiredViewAsType(source, R.id.ask_title, "field 'askTitle'", TextView.class);
    target.itemAskImage = Utils.findRequiredViewAsType(source, R.id.item_ask_image, "field 'itemAskImage'", CircleImageView.class);
    target.itemAskName = Utils.findRequiredViewAsType(source, R.id.item_ask_name, "field 'itemAskName'", TextView.class);
    target.itemAskTime = Utils.findRequiredViewAsType(source, R.id.item_ask_time, "field 'itemAskTime'", TextView.class);
    target.askIntro = Utils.findRequiredViewAsType(source, R.id.ask_intro, "field 'askIntro'", TextView.class);
    target.itemAskImage1 = Utils.findRequiredViewAsType(source, R.id.item_ask_image1, "field 'itemAskImage1'", ImageView.class);
    target.itemAskImage2 = Utils.findRequiredViewAsType(source, R.id.item_ask_image2, "field 'itemAskImage2'", ImageView.class);
    target.itemAskImage3 = Utils.findRequiredViewAsType(source, R.id.item_ask_image3, "field 'itemAskImage3'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.iv_love, "field 'ivLove' and method 'selectLove'");
    target.ivLove = Utils.castView(view, R.id.iv_love, "field 'ivLove'", ImageView.class);
    view2131296630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectLove();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_commend, "field 'ivCommend' and method 'selectCommend'");
    target.ivCommend = Utils.castView(view, R.id.iv_commend, "field 'ivCommend'", ImageView.class);
    view2131296622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectCommend();
      }
    });
    target.tvAskType = Utils.findRequiredViewAsType(source, R.id.tv_ask_type, "field 'tvAskType'", TextView.class);
    view = Utils.findRequiredView(source, R.id.my_ask_type, "field 'myAskType' and method 'type'");
    target.myAskType = Utils.castView(view, R.id.my_ask_type, "field 'myAskType'", LinearLayout.class);
    view2131296761 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.type();
      }
    });
    target.itemCommentList = Utils.findRequiredViewAsType(source, R.id.item_comment_list, "field 'itemCommentList'", ListView.class);
    target.editComment = Utils.findRequiredViewAsType(source, R.id.edit_comment, "field 'editComment'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_comment, "field 'btnComment' and method 'btnComment'");
    target.btnComment = Utils.castView(view, R.id.btn_comment, "field 'btnComment'", TextView.class);
    view2131296348 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnComment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.layoutTitle = null;
    target.askTitle = null;
    target.itemAskImage = null;
    target.itemAskName = null;
    target.itemAskTime = null;
    target.askIntro = null;
    target.itemAskImage1 = null;
    target.itemAskImage2 = null;
    target.itemAskImage3 = null;
    target.ivLove = null;
    target.ivCommend = null;
    target.tvAskType = null;
    target.myAskType = null;
    target.itemCommentList = null;
    target.editComment = null;
    target.btnComment = null;

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296630.setOnClickListener(null);
    view2131296630 = null;
    view2131296622.setOnClickListener(null);
    view2131296622 = null;
    view2131296761.setOnClickListener(null);
    view2131296761 = null;
    view2131296348.setOnClickListener(null);
    view2131296348 = null;

    this.target = null;
  }
}
