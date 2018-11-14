// Generated code from Butter Knife. Do not modify!
package my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyInforActivity_ViewBinding<T extends MyInforActivity> implements Unbinder {
  protected T target;

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  private View view2131296561;

  private View view2131296562;

  private View view2131296563;

  private View view2131296564;

  private View view2131296559;

  private View view2131296565;

  private View view2131296560;

  private View view2131296353;

  @UiThread
  public MyInforActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'exit'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296662 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
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
    target.inforImg = Utils.findRequiredViewAsType(source, R.id.infor_img, "field 'inforImg'", CircleImageView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_img, "field 'inforLayoutImg' and method 'setInforImg'");
    target.inforLayoutImg = Utils.castView(view, R.id.infor_layout_img, "field 'inforLayoutImg'", RelativeLayout.class);
    view2131296561 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforImg();
      }
    });
    target.inforAccount = Utils.findRequiredViewAsType(source, R.id.infor_account, "field 'inforAccount'", TextView.class);
    target.inforName = Utils.findRequiredViewAsType(source, R.id.infor_name, "field 'inforName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_name, "field 'inforLayoutName' and method 'setInforName'");
    target.inforLayoutName = Utils.castView(view, R.id.infor_layout_name, "field 'inforLayoutName'", RelativeLayout.class);
    view2131296562 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforName();
      }
    });
    target.inforRealName = Utils.findRequiredViewAsType(source, R.id.infor_real_name, "field 'inforRealName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_real_name, "field 'inforLayoutRealName' and method 'setInforRealName'");
    target.inforLayoutRealName = Utils.castView(view, R.id.infor_layout_real_name, "field 'inforLayoutRealName'", RelativeLayout.class);
    view2131296563 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforRealName();
      }
    });
    target.inforSex = Utils.findRequiredViewAsType(source, R.id.infor_sex, "field 'inforSex'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_sex, "field 'inforLayoutSex' and method 'setInforSex'");
    target.inforLayoutSex = Utils.castView(view, R.id.infor_layout_sex, "field 'inforLayoutSex'", RelativeLayout.class);
    view2131296564 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforSex();
      }
    });
    target.inforAge = Utils.findRequiredViewAsType(source, R.id.infor_age, "field 'inforAge'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_age, "field 'inforLayoutAge' and method 'setInforAge'");
    target.inforLayoutAge = Utils.castView(view, R.id.infor_layout_age, "field 'inforLayoutAge'", RelativeLayout.class);
    view2131296559 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforAge();
      }
    });
    target.inforTel = Utils.findRequiredViewAsType(source, R.id.infor_tel, "field 'inforTel'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_tel, "field 'inforLayoutTel' and method 'setInforTel'");
    target.inforLayoutTel = Utils.castView(view, R.id.infor_layout_tel, "field 'inforLayoutTel'", RelativeLayout.class);
    view2131296565 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforTel();
      }
    });
    target.inforEmail = Utils.findRequiredViewAsType(source, R.id.infor_email, "field 'inforEmail'", TextView.class);
    view = Utils.findRequiredView(source, R.id.infor_layout_email, "field 'inforLayoutEmail' and method 'setInforEmail'");
    target.inforLayoutEmail = Utils.castView(view, R.id.infor_layout_email, "field 'inforLayoutEmail'", RelativeLayout.class);
    view2131296560 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setInforEmail();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_infor_commit, "field 'btnInforCommit' and method 'setUser'");
    target.btnInforCommit = Utils.castView(view, R.id.btn_infor_commit, "field 'btnInforCommit'", TextView.class);
    view2131296353 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setUser();
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
    target.inforImg = null;
    target.inforLayoutImg = null;
    target.inforAccount = null;
    target.inforName = null;
    target.inforLayoutName = null;
    target.inforRealName = null;
    target.inforLayoutRealName = null;
    target.inforSex = null;
    target.inforLayoutSex = null;
    target.inforAge = null;
    target.inforLayoutAge = null;
    target.inforTel = null;
    target.inforLayoutTel = null;
    target.inforEmail = null;
    target.inforLayoutEmail = null;
    target.btnInforCommit = null;

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296561.setOnClickListener(null);
    view2131296561 = null;
    view2131296562.setOnClickListener(null);
    view2131296562 = null;
    view2131296563.setOnClickListener(null);
    view2131296563 = null;
    view2131296564.setOnClickListener(null);
    view2131296564 = null;
    view2131296559.setOnClickListener(null);
    view2131296559 = null;
    view2131296565.setOnClickListener(null);
    view2131296565 = null;
    view2131296560.setOnClickListener(null);
    view2131296560 = null;
    view2131296353.setOnClickListener(null);
    view2131296353 = null;

    this.target = null;
  }
}
