// Generated code from Butter Knife. Do not modify!
package appoint.adapter;

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

public class AppointAdapter$ViewHolder_ViewBinding<T extends AppointAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public AppointAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.itemDoctorImage = Utils.findRequiredViewAsType(source, R.id.item_doctor_image, "field 'itemDoctorImage'", ImageView.class);
    target.itemDoctorName = Utils.findRequiredViewAsType(source, R.id.item_doctor_name, "field 'itemDoctorName'", TextView.class);
    target.itemDoctorGroup = Utils.findRequiredViewAsType(source, R.id.item_doctor_group, "field 'itemDoctorGroup'", TextView.class);
    target.itemDoctorHospital = Utils.findRequiredViewAsType(source, R.id.item_doctor_hospital, "field 'itemDoctorHospital'", TextView.class);
    target.itemDoctorScore = Utils.findRequiredViewAsType(source, R.id.item_doctor_score, "field 'itemDoctorScore'", TextView.class);
    target.itemDoctorGrade = Utils.findRequiredViewAsType(source, R.id.item_doctor_grade, "field 'itemDoctorGrade'", TextView.class);
    target.tvAppointTime = Utils.findRequiredViewAsType(source, R.id.tv_appoint_time, "field 'tvAppointTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.itemDoctorImage = null;
    target.itemDoctorName = null;
    target.itemDoctorGroup = null;
    target.itemDoctorHospital = null;
    target.itemDoctorScore = null;
    target.itemDoctorGrade = null;
    target.tvAppointTime = null;

    this.target = null;
  }
}
