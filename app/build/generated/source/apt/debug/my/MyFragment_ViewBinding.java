// Generated code from Butter Knife. Do not modify!
package my;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyFragment_ViewBinding<T extends MyFragment> implements Unbinder {
  protected T target;

  private View view2131231040;

  private View view2131231042;

  private View view2131231041;

  @UiThread
  public MyFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.tvUsername = Utils.findRequiredViewAsType(source, R.id.tv_username, "field 'tvUsername'", TextView.class);
    view = Utils.findRequiredView(source, R.id.my_appoint, "field 'myAppoint' and method 'startMyLove'");
    target.myAppoint = Utils.castView(view, R.id.my_appoint, "field 'myAppoint'", LinearLayout.class);
    view2131231040 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startMyLove(Utils.<LinearLayout>castParam(p0, "doClick", 0, "startMyLove", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.my_love, "field 'myLove' and method 'startMyLove'");
    target.myLove = Utils.castView(view, R.id.my_love, "field 'myLove'", LinearLayout.class);
    view2131231042 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startMyLove(Utils.<LinearLayout>castParam(p0, "doClick", 0, "startMyLove", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.my_ask, "field 'myAsk' and method 'startMyLove'");
    target.myAsk = Utils.castView(view, R.id.my_ask, "field 'myAsk'", LinearLayout.class);
    view2131231041 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startMyLove(Utils.<LinearLayout>castParam(p0, "doClick", 0, "startMyLove", 0));
      }
    });
    target.ivLogoSetting = Utils.findRequiredViewAsType(source, R.id.iv_logo_setting, "field 'ivLogoSetting'", ImageView.class);
    target.ivLogoZx = Utils.findRequiredViewAsType(source, R.id.iv_logo_zx, "field 'ivLogoZx'", ImageView.class);
    target.profileImage = Utils.findRequiredViewAsType(source, R.id.profile_image, "field 'profileImage'", CircleImageView.class);
    target.aboutLine = Utils.findRequiredView(source, R.id.about_line, "field 'aboutLine'");
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvUsername = null;
    target.myAppoint = null;
    target.myLove = null;
    target.myAsk = null;
    target.ivLogoSetting = null;
    target.ivLogoZx = null;
    target.profileImage = null;
    target.aboutLine = null;

    view2131231040.setOnClickListener(null);
    view2131231040 = null;
    view2131231042.setOnClickListener(null);
    view2131231042 = null;
    view2131231041.setOnClickListener(null);
    view2131231041 = null;

    this.target = null;
  }
}
