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

public class HospitalAdapter$ViewHolder_ViewBinding<T extends HospitalAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HospitalAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.itemHospitalView = Utils.findRequiredViewAsType(source, R.id.item_hospital_view, "field 'itemHospitalView'", ImageView.class);
    target.itemHospitalName = Utils.findRequiredViewAsType(source, R.id.item_hospital_name, "field 'itemHospitalName'", TextView.class);
    target.itemHospitalGrade = Utils.findRequiredViewAsType(source, R.id.item_hospital_grade, "field 'itemHospitalGrade'", TextView.class);
    target.itemHospitalAddress = Utils.findRequiredViewAsType(source, R.id.item_hospital_address, "field 'itemHospitalAddress'", TextView.class);
    target.itemHospitalScore = Utils.findRequiredViewAsType(source, R.id.item_hospital_score, "field 'itemHospitalScore'", TextView.class);
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

    this.target = null;
  }
}
