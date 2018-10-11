package home;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.life.R;

/**
 * @author lifan
 * @date 2018/9/25 23:45
 * @email 2224779926@qq.com
 * @desc
 */

public class ForecastResultActivity extends Activity{
    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forecast);

    }
}
