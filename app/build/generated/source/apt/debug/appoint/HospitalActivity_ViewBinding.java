// Generated code from Butter Knife. Do not modify!
package appoint;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HospitalActivity_ViewBinding<T extends HospitalActivity> implements Unbinder {
  protected T target;

  private View view2131296662;

  private View view2131296631;

  private View view2131297052;

  private View view2131296630;

  @UiThread
  public HospitalActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.itemHospitalView = Utils.findRequiredViewAsType(source, R.id.item_hospital_view, "field 'itemHospitalView'", ImageView.class);
    target.itemHospitalName = Utils.findRequiredViewAsType(source, R.id.item_hospital_name, "field 'itemHospitalName'", TextView.class);
    target.itemHospitalGrade = Utils.findRequiredViewAsType(source, R.id.item_hospital_grade, "field 'itemHospitalGrade'", TextView.class);
    target.itemHospitalAddress = Utils.findRequiredViewAsType(source, R.id.item_hospital_address, "field 'itemHospitalAddress'", TextView.class);
    target.itemHospitalScore = Utils.findRequiredViewAsType(source, R.id.item_hospital_score, "field 'itemHospitalScore'", TextView.class);
    target.liKeshi = Utils.findRequiredViewAsType(source, R.id.li_keshi, "field 'liKeshi'", ListView.class);
    target.liMenzhen = Utils.findRequiredViewAsType(source, R.id.li_menzhen, "field 'liMenzhen'", ListView.class);
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'onViewClicked'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296662 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_msg, "field 'ivMsg', method 'onViewClicked', and method 'msgStart'");
    target.ivMsg = Utils.castView(view, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    view2131296631 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
        target.msgStart();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_msg_num, "field 'tvMsgNum', method 'onViewClicked', and method 'msgStart'");
    target.tvMsgNum = Utils.castView(view, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    view2131297052 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
        target.msgStart();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_love, "field 'ivLove' and method 'selectLove'");
    target.ivLove = Utils.castView(view, R.id.iv_love, "field 'ivLove'", ImageView.class);
    view2131296630 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectLove();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemHospitalView = null;
    target.itemHospitalName = null;
    target.itemHospitalGrade = null;
    target.itemHospitalAddress = null;
    target.itemHospitalScore = null;
    target.liKeshi = null;
    target.liMenzhen = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.ivLove = null;

    view2131296662.setOnClickListener(null);
    view2131296662 = null;
    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296630.setOnClickListener(null);
    view2131296630 = null;

    this.target = null;
  }
}
