// Generated code from Butter Knife. Do not modify!
package appoint;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmActivity_ViewBinding<T extends ConfirmActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ConfirmActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.itemDoctorName = Utils.findRequiredViewAsType(source, R.id.item_doctor_name, "field 'itemDoctorName'", TextView.class);
    target.itemDoctorGroup = Utils.findRequiredViewAsType(source, R.id.item_doctor_group, "field 'itemDoctorGroup'", TextView.class);
    target.itemDoctorHospital = Utils.findRequiredViewAsType(source, R.id.item_doctor_hospital, "field 'itemDoctorHospital'", TextView.class);
    target.itemDoctorScore = Utils.findRequiredViewAsType(source, R.id.item_doctor_score, "field 'itemDoctorScore'", TextView.class);
    target.itemDoctorGrade = Utils.findRequiredViewAsType(source, R.id.item_doctor_grade, "field 'itemDoctorGrade'", TextView.class);
    target.tvAppointTime = Utils.findRequiredViewAsType(source, R.id.tv_appoint_time, "field 'tvAppointTime'", TextView.class);
    target.confirmName = Utils.findRequiredViewAsType(source, R.id.confirm_name, "field 'confirmName'", EditText.class);
    target.confirmTele = Utils.findRequiredViewAsType(source, R.id.confirm_tele, "field 'confirmTele'", EditText.class);
    target.confirmId = Utils.findRequiredViewAsType(source, R.id.confirm_id, "field 'confirmId'", EditText.class);
    target.confirm = Utils.findRequiredViewAsType(source, R.id.confirm, "field 'confirm'", TextView.class);
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
    target.confirm = null;

    this.target = null;
  }
}
