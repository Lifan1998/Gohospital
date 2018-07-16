package news;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.life.R;

/**
 * Created by lenovo on 2018/7/12.
 */

public class NewsFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }


    @Override
    public void onClick(View v) {

    }
}
