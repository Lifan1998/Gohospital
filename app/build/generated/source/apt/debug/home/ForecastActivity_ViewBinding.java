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

  private View view2131296544;

  private View view2131296760;

  private View view2131296784;

  private View view2131296523;

  private View view2131296524;

  private View view2131296525;

  private View view2131296526;

  private View view2131296527;

  private View view2131296528;

  private View view2131296529;

  private View view2131296530;

  private View view2131296531;

  private View view2131296532;

  private View view2131296533;

  private View view2131296534;

  private View view2131296535;

  private View view2131296536;

  private View view2131296537;

  private View view2131296774;

  private View view2131296776;

  private View view2131296538;

  private View view2131296539;

  private View view2131296540;

  private View view2131296541;

  private View view2131296326;

  @UiThread
  public ForecastActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.layout_return, "field 'layoutReturn' and method 'exit'");
    target.layoutReturn = Utils.castView(view, R.id.layout_return, "field 'layoutReturn'", LinearLayout.class);
    view2131296544 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivMsg = Utils.findRequiredViewAsType(source, R.id.iv_msg, "field 'ivMsg'", ImageView.class);
    target.tvMsgNum = Utils.findRequiredViewAsType(source, R.id.tv_msg_num, "field 'tvMsgNum'", TextView.class);
    target.tvForecastName = Utils.findRequiredViewAsType(source, R.id.tv_forecast_name, "field 'tvForecastName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_height, "field 'tvHeight' and method 'setTvHeight'");
    target.tvHeight = Utils.castView(view, R.id.tv_height, "field 'tvHeight'", TextView.class);
    view2131296760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setTvHeight();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_weight, "field 'tvWeight' and method 'setTvWeight'");
    target.tvWeight = Utils.castView(view, R.id.tv_weight, "field 'tvWeight'", TextView.class);
    view2131296784 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setTvWeight();
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_1, "field 'label11' and method 'OnClickLabel'");
    target.label11 = Utils.castView(view, R.id.label_1_1, "field 'label11'", TextView.class);
    view2131296523 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_2, "field 'label12' and method 'OnClickLabel'");
    target.label12 = Utils.castView(view, R.id.label_1_2, "field 'label12'", TextView.class);
    view2131296524 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_3, "field 'label13' and method 'OnClickLabel'");
    target.label13 = Utils.castView(view, R.id.label_1_3, "field 'label13'", TextView.class);
    view2131296525 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_1_4, "field 'label14' and method 'OnClickLabel'");
    target.label14 = Utils.castView(view, R.id.label_1_4, "field 'label14'", TextView.class);
    view2131296526 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_2_1, "field 'label21', method 'OnClickLabel', and method 'radio1'");
    target.label21 = Utils.castView(view, R.id.label_2_1, "field 'label21'", TextView.class);
    view2131296527 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio1(Utils.<TextView>castParam(p0, "doClick", 0, "radio1", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_2_2, "field 'label22', method 'OnClickLabel', and method 'radio1'");
    target.label22 = Utils.castView(view, R.id.label_2_2, "field 'label22'", TextView.class);
    view2131296528 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio1(Utils.<TextView>castParam(p0, "doClick", 0, "radio1", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_3_1, "field 'label31', method 'OnClickLabel', and method 'radio2'");
    target.label31 = Utils.castView(view, R.id.label_3_1, "field 'label31'", TextView.class);
    view2131296529 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio2(Utils.<TextView>castParam(p0, "doClick", 0, "radio2", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_3_2, "field 'label32', method 'OnClickLabel', and method 'radio2'");
    target.label32 = Utils.castView(view, R.id.label_3_2, "field 'label32'", TextView.class);
    view2131296530 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio2(Utils.<TextView>castParam(p0, "doClick", 0, "radio2", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_1, "field 'label41' and method 'OnClickLabel'");
    target.label41 = Utils.castView(view, R.id.label_4_1, "field 'label41'", TextView.class);
    view2131296531 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_2, "field 'label42' and method 'OnClickLabel'");
    target.label42 = Utils.castView(view, R.id.label_4_2, "field 'label42'", TextView.class);
    view2131296532 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_3, "field 'label43' and method 'OnClickLabel'");
    target.label43 = Utils.castView(view, R.id.label_4_3, "field 'label43'", TextView.class);
    view2131296533 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_4_4, "field 'label44' and method 'OnClickLabel'");
    target.label44 = Utils.castView(view, R.id.label_4_4, "field 'label44'", TextView.class);
    view2131296534 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_1, "field 'label51', method 'OnClickLabel', and method 'radio3'");
    target.label51 = Utils.castView(view, R.id.label_5_1, "field 'label51'", TextView.class);
    view2131296535 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio3(Utils.<TextView>castParam(p0, "doClick", 0, "radio3", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_2, "field 'label52', method 'OnClickLabel', and method 'radio3'");
    target.label52 = Utils.castView(view, R.id.label_5_2, "field 'label52'", TextView.class);
    view2131296536 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio3(Utils.<TextView>castParam(p0, "doClick", 0, "radio3", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_5_3, "field 'label53', method 'OnClickLabel', and method 'radio3'");
    target.label53 = Utils.castView(view, R.id.label_5_3, "field 'label53'", TextView.class);
    view2131296537 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio3(Utils.<TextView>castParam(p0, "doClick", 0, "radio3", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_smoke_num, "field 'tvSmokeNum' and method 'setTvSmokeNum'");
    target.tvSmokeNum = Utils.castView(view, R.id.tv_smoke_num, "field 'tvSmokeNum'", TextView.class);
    view2131296774 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setTvSmokeNum();
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_smoke_year, "field 'tvSmokeYear' and method 'setTvSmokeYear'");
    target.tvSmokeYear = Utils.castView(view, R.id.tv_smoke_year, "field 'tvSmokeYear'", TextView.class);
    view2131296776 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setTvSmokeYear();
      }
    });
    view = Utils.findRequiredView(source, R.id.label_6_1, "field 'label61', method 'OnClickLabel', and method 'radio4'");
    target.label61 = Utils.castView(view, R.id.label_6_1, "field 'label61'", TextView.class);
    view2131296538 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio4(Utils.<TextView>castParam(p0, "doClick", 0, "radio4", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_6_2, "field 'label62', method 'OnClickLabel', and method 'radio4'");
    target.label62 = Utils.castView(view, R.id.label_6_2, "field 'label62'", TextView.class);
    view2131296539 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio4(Utils.<TextView>castParam(p0, "doClick", 0, "radio4", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_7_1, "field 'label71', method 'OnClickLabel', and method 'radio5'");
    target.label71 = Utils.castView(view, R.id.label_7_1, "field 'label71'", TextView.class);
    view2131296540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio5(Utils.<TextView>castParam(p0, "doClick", 0, "radio5", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.label_7_2, "field 'label72', method 'OnClickLabel', and method 'radio5'");
    target.label72 = Utils.castView(view, R.id.label_7_2, "field 'label72'", TextView.class);
    view2131296541 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClickLabel(Utils.<TextView>castParam(p0, "doClick", 0, "OnClickLabel", 0));
        target.radio5(Utils.<TextView>castParam(p0, "doClick", 0, "radio5", 0));
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_forecast, "field 'btnForecast' and method 'commit'");
    target.btnForecast = Utils.castView(view, R.id.btn_forecast, "field 'btnForecast'", TextView.class);
    view2131296326 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commit();
      }
    });
    target.tvBirth = Utils.findRequiredViewAsType(source, R.id.tv_birth, "field 'tvBirth'", TextView.class);
    target.tvHeight1 = Utils.findRequiredViewAsType(source, R.id.tv_height1, "field 'tvHeight1'", TextView.class);
    target.tvBmi = Utils.findRequiredViewAsType(source, R.id.tv_bmi, "field 'tvBmi'", TextView.class);

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
    target.btnForecast = null;
    target.tvBirth = null;
    target.tvHeight1 = null;
    target.tvBmi = null;

    view2131296544.setOnClickListener(null);
    view2131296544 = null;
    view2131296760.setOnClickListener(null);
    view2131296760 = null;
    view2131296784.setOnClickListener(null);
    view2131296784 = null;
    view2131296523.setOnClickListener(null);
    view2131296523 = null;
    view2131296524.setOnClickListener(null);
    view2131296524 = null;
    view2131296525.setOnClickListener(null);
    view2131296525 = null;
    view2131296526.setOnClickListener(null);
    view2131296526 = null;
    view2131296527.setOnClickListener(null);
    view2131296527 = null;
    view2131296528.setOnClickListener(null);
    view2131296528 = null;
    view2131296529.setOnClickListener(null);
    view2131296529 = null;
    view2131296530.setOnClickListener(null);
    view2131296530 = null;
    view2131296531.setOnClickListener(null);
    view2131296531 = null;
    view2131296532.setOnClickListener(null);
    view2131296532 = null;
    view2131296533.setOnClickListener(null);
    view2131296533 = null;
    view2131296534.setOnClickListener(null);
    view2131296534 = null;
    view2131296535.setOnClickListener(null);
    view2131296535 = null;
    view2131296536.setOnClickListener(null);
    view2131296536 = null;
    view2131296537.setOnClickListener(null);
    view2131296537 = null;
    view2131296774.setOnClickListener(null);
    view2131296774 = null;
    view2131296776.setOnClickListener(null);
    view2131296776 = null;
    view2131296538.setOnClickListener(null);
    view2131296538 = null;
    view2131296539.setOnClickListener(null);
    view2131296539 = null;
    view2131296540.setOnClickListener(null);
    view2131296540 = null;
    view2131296541.setOnClickListener(null);
    view2131296541 = null;
    view2131296326.setOnClickListener(null);
    view2131296326 = null;

    this.target = null;
  }
}
