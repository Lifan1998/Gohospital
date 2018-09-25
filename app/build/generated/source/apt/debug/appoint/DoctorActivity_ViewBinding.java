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
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DoctorActivity_ViewBinding<T extends DoctorActivity> implements Unbinder {
  protected T target;

  @UiThread
  public DoctorActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.itemDoctorImage = Utils.findRequiredViewAsType(source, R.id.item_doctor_image, "field 'itemDoctorImage'", ImageView.class);
    target.itemDoctorName = Utils.findRequiredViewAsType(source, R.id.item_doctor_name, "field 'itemDoctorName'", TextView.class);
    target.itemDoctorGroup = Utils.findRequiredViewAsType(source, R.id.item_doctor_group, "field 'itemDoctorGroup'", TextView.class);
    target.itemDoctorHospital = Utils.findRequiredViewAsType(source, R.id.item_doctor_hospital, "field 'itemDoctorHospital'", TextView.class);
    target.itemDoctorScore = Utils.findRequiredViewAsType(source, R.id.item_doctor_score, "field 'itemDoctorScore'", TextView.class);
    target.itemDoctorGrade = Utils.findRequiredViewAsType(source, R.id.item_doctor_grade, "field 'itemDoctorGrade'", TextView.class);
    target.doctorChat = Utils.findRequiredViewAsType(source, R.id.doctor_chat, "field 'doctorChat'", LinearLayout.class);
    target.liAppointTime = Utils.findRequiredViewAsType(source, R.id.li_appoint_time, "field 'liAppointTime'", ListView.class);
    target.layoutReturn = Utils.findRequiredViewAsType(source, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
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
    target.doctorChat = null;
    target.liAppointTime = null;
    target.layoutReturn = null;
    target.tvTitle = null;
    target.ivMsg = null;
    target.tvMsgNum = null;

    this.target = null;
  }
}
