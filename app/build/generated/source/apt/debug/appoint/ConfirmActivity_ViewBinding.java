// Generated code from Butter Knife. Do not modify!
package appoint;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmActivity_ViewBinding<T extends ConfirmActivity> implements Unbinder {
  protected T target;

  private View view2131296631;

  private View view2131297052;

  private View view2131296345;

  @UiThread
  public ConfirmActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.itemDoctorName = Utils.findRequiredViewAsType(source, R.id.item_doctor_name, "field 'itemDoctorName'", TextView.class);
    target.itemDoctorGroup = Utils.findRequiredViewAsType(source, R.id.item_doctor_group, "field 'itemDoctorGroup'", TextView.class);
    target.itemDoctorHospital = Utils.findRequiredViewAsType(source, R.id.item_doctor_hospital, "field 'itemDoctorHospital'", TextView.class);
    target.itemDoctorScore = Utils.findRequiredViewAsType(source, R.id.item_doctor_score, "field 'itemDoctorScore'", TextView.class);
    target.itemDoctorGrade = Utils.findRequiredViewAsType(source, R.id.item_doctor_grade, "field 'itemDoctorGrade'", TextView.class);
    target.tvAppointTime = Utils.findRequiredViewAsType(source, R.id.tv_appoint_time, "field 'tvAppointTime'", TextView.class);
    target.confirmName = Utils.findRequiredViewAsType(source, R.id.confirm_name, "field 'confirmName'", EditText.class);
    target.confirmTele = Utils.findRequiredViewAsType(source, R.id.confirm_tele, "field 'confirmTele'", EditText.class);
    target.confirmId = Utils.findRequiredViewAsType(source, R.id.confirm_id, "field 'confirmId'", EditText.class);
    target.layoutReturn = Utils.findRequiredViewAsType(source, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
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
    target.itemDoctorImage = Utils.findRequiredViewAsType(source, R.id.item_doctor_image, "field 'itemDoctorImage'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_appoint_confirm, "field 'btnAppointConfirm' and method 'confirm'");
    target.btnAppointConfirm = Utils.castView(view, R.id.btn_appoint_confirm, "field 'btnAppointConfirm'", TextView.class);
    view2131296345 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.confirm();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemDoctorName = null;
    target.itemDoctorGroup = null;
    target.itemDoctorHospital = null;
    target.itemDoctorScore = null;
    target.itemDoctorGrade = null;
    target.tvAppointTime = null;
    target.confirmName = null;
    target.confirmTele = null;
    target.confirmId = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;
    target.itemDoctorImage = null;
    target.btnAppointConfirm = null;

    view2131296631.setOnClickListener(null);
    view2131296631 = null;
    view2131297052.setOnClickListener(null);
    view2131297052 = null;
    view2131296345.setOnClickListener(null);
    view2131296345 = null;

    this.target = null;
  }
}
