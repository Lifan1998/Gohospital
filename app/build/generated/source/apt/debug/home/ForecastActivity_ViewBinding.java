// Generated code from Butter Knife. Do not modify!
package home;

import android.content.Context;
import android.content.res.Resources;
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

public class ForecastActivity_ViewBinding<T extends ForecastActivity> implements Unbinder {
  protected T target;

  private View view2131230972;

  private View view2131230973;

  private View view2131230974;

  private View view2131230975;

  private View view2131230976;

  private View view2131230977;

  private View view2131230978;

  private View view2131230979;

  private View view2131230980;

  private View view2131230981;

  private View view2131230982;

  private View view2131230983;

  private View view2131230984;

  private View view2131230985;

  private View view2131230986;

  private View view2131230987;

  private View view2131230988;

  private View view2131230989;

  private View view2131230990;

  @UiThread
  public ForecastActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.layoutReturn = Utils.findRequiredViewAsType(source, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    target.tvForecastName = Utils.findRequiredViewAsType(source, R.id.tv_forecast_name, "field 'tvForecastName'", EditText.class);
    target.tvBirth = Utils.findRequiredViewAsType(source, R.id.tv_birth, "field 'tvBirth'", TextView.class);
    target.tvHeight = Utils.findRequiredViewAsType(source, R.id.tv_height, "field 'tvHeight'", TextView.class);
    target.tvWeight = Utils.findRequiredViewAsType(source, R.id.tv_weight, "field 'tvWeight'", TextView.class);
    view = Utils.findRequiredView(source, R.id.label_1_1, "field 'label11' and method 'OnClickLabel'");
    target.label11 = Utils.castView(view, R.id.label_1_1, "field 'label11'", TextView.class);
    view2131230972 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_2, "field 'label12' and method 'OnClickLabel'");
    target.label12 = Utils.castView(view, R.id.label_1_2, "field 'label12'", TextView.class);
    view2131230973 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_3, "field 'label13' and method 'OnClickLabel'");
    target.label13 = Utils.castView(view, R.id.label_1_3, "field 'label13'", TextView.class);
    view2131230974 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_4, "field 'label14' and method 'OnClickLabel'");
    target.label14 = Utils.castView(view, R.id.label_1_4, "field 'label14'", TextView.class);
    view2131230975 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_2_1, "field 'label21' and method 'OnClickLabel'");
    target.label21 = Utils.castView(view, R.id.label_2_1, "field 'label21'", TextView.class);
    view2131230976 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_2_2, "field 'label22' and method 'OnClickLabel'");
    target.label22 = Utils.castView(view, R.id.label_2_2, "field 'label22'", TextView.class);
    view2131230977 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_3_1, "field 'label31' and method 'OnClickLabel'");
    target.label31 = Utils.castView(view, R.id.label_3_1, "field 'label31'", TextView.class);
    view2131230978 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_3_2, "field 'label32' and method 'OnClickLabel'");
    target.label32 = Utils.castView(view, R.id.label_3_2, "field 'label32'", TextView.class);
    view2131230979 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_1, "field 'label41' and method 'OnClickLabel'");
    target.label41 = Utils.castView(view, R.id.label_4_1, "field 'label41'", TextView.class);
    view2131230980 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_2, "field 'label42' and method 'OnClickLabel'");
    target.label42 = Utils.castView(view, R.id.label_4_2, "field 'label42'", TextView.class);
    view2131230981 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_3, "field 'label43' and method 'OnClickLabel'");
    target.label43 = Utils.castView(view, R.id.label_4_3, "field 'label43'", TextView.class);
    view2131230982 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_4, "field 'label44' and method 'OnClickLabel'");
    target.label44 = Utils.castView(view, R.id.label_4_4, "field 'label44'", TextView.class);
    view2131230983 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_1, "field 'label51' and method 'OnClickLabel'");
    target.label51 = Utils.castView(view, R.id.label_5_1, "field 'label51'", TextView.class);
    view2131230984 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_2, "field 'label52' and method 'OnClickLabel'");
    target.label52 = Utils.castView(view, R.id.label_5_2, "field 'label52'", TextView.class);
    view2131230985 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_3, "field 'label53' and method 'OnClickLabel'");
    target.label53 = Utils.castView(view, R.id.label_5_3, "field 'label53'", TextView.class);
    view2131230986 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    target.tvSmokeNum = Utils.findRequiredViewAsType(source, R.id.tv_smoke_num, "field 'tvSmokeNum'", TextView.class);
    target.tvSmokeYear = Utils.findRequiredViewAsType(source, R.id.tv_smoke_year, "field 'tvSmokeYear'", TextView.class);
    view = Utils.findRequiredView(source, R.id.label_6_1, "field 'label61' and method 'OnClickLabel'");
    target.label61 = Utils.castView(view, R.id.label_6_1, "field 'label61'", TextView.class);
    view2131230987 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_6_2, "field 'label62' and method 'OnClickLabel'");
    target.label62 = Utils.castView(view, R.id.label_6_2, "field 'label62'", TextView.class);
    view2131230988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_7_1, "field 'label71' and method 'OnClickLabel'");
    target.label71 = Utils.castView(view, R.id.label_7_1, "field 'label71'", TextView.class);
    view2131230989 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_7_2, "field 'label72' and method 'OnClickLabel'");
    target.label72 = Utils.castView(view, R.id.label_7_2, "field 'label72'", TextView.class);
    view2131230990 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    Resources.Theme theme = context.getTheme();
    target.white = Utils.getColor(res, theme, R.color.text_white);
    target.blue = Utils.getColor(res, theme, R.color.text_blue);
    target.brank = Utils.getColor(res, theme, R.color.brank);
    target.gray = Utils.getColor(res, theme, R.color.qmui_config_color_gray_9);
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
    target.tvForecastName = null;
    target.tvBirth = null;
    target.tvHeight = null;
    target.tvWeight = null;
    target.label11 = null;
    target.label12 = null;
    target.label13 = null;
    target.label14 = null;
    target.label21 = null;
    target.label22 = null;
    target.label31 = null;
    target.label32 = null;
    target.label41 = null;
    target.label42 = null;
    target.label43 = null;
    target.label44 = null;
    target.label51 = null;
    target.label52 = null;
    target.label53 = null;
    target.tvSmokeNum = null;
    target.tvSmokeYear = null;
    target.label61 = null;
    target.label62 = null;
    target.label71 = null;
    target.label72 = null;

    view2131230972.setOnClickListener(null);
    view2131230972 = null;
    view2131230973.setOnClickListener(null);
    view2131230973 = null;
    view2131230974.setOnClickListener(null);
    view2131230974 = null;
    view2131230975.setOnClickListener(null);
    view2131230975 = null;
    view2131230976.setOnClickListener(null);
    view2131230976 = null;
    view2131230977.setOnClickListener(null);
    view2131230977 = null;
    view2131230978.setOnClickListener(null);
    view2131230978 = null;
    view2131230979.setOnClickListener(null);
    view2131230979 = null;
    view2131230980.setOnClickListener(null);
    view2131230980 = null;
    view2131230981.setOnClickListener(null);
    view2131230981 = null;
    view2131230982.setOnClickListener(null);
    view2131230982 = null;
    view2131230983.setOnClickListener(null);
    view2131230983 = null;
    view2131230984.setOnClickListener(null);
    view2131230984 = null;
    view2131230985.setOnClickListener(null);
    view2131230985 = null;
    view2131230986.setOnClickListener(null);
    view2131230986 = null;
    view2131230987.setOnClickListener(null);
    view2131230987 = null;
    view2131230988.setOnClickListener(null);
    view2131230988 = null;
    view2131230989.setOnClickListener(null);
    view2131230989 = null;
    view2131230990.setOnClickListener(null);
    view2131230990 = null;

    this.target = null;
  }
}
