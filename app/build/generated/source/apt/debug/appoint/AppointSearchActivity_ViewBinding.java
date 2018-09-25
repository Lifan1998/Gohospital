// Generated code from Butter Knife. Do not modify!
package appoint;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.life.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AppointSearchActivity_ViewBinding<T extends AppointSearchActivity> implements Unbinder {
  protected T target;

  @UiThread
  public AppointSearchActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.liSearchHospital = Utils.findRequiredViewAsType(source, R.id.li_search_hospital, "field 'liSearchHospital'", ListView.class);
    target.liSearchDoctor = Utils.findRequiredViewAsType(source, R.id.li_search_doctor, "field 'liSearchDoctor'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.liSearchHospital = null;
    target.liSearchDoctor = null;

    this.target = null;
  }
}
