package home;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;

/**
 * Created by lenovo on 2018/3/8.
 */

public class MyFragment extends Fragment implements View.OnClickListener{
    private Context mContext;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
   // @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        btn_one = (Button)view.findViewById(R.id.btn_one);
        btn_two = (Button)view.findViewById(R.id.btn_two);
        btn_three = (Button)view.findViewById(R.id.btn_three);
        btn_four = (Button)view.findViewById(R.id.btn_four);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_one:
                TextView mTextViewDeal = (TextView)getActivity().findViewById(R.id.tab_menu_deal_num);
                mTextViewDeal.setText("11");
                mTextViewDeal.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_two:
                TextView mTextViewPoi = (TextView)getActivity().findViewById(R.id.tab_menu_poi_num);
                mTextViewPoi.setText("99");
                mTextViewPoi.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_three:
                TextView mTextViewMore = (TextView)getActivity().findViewById(R.id.tab_menu_more_num);
                mTextViewMore.setText("999+");
                mTextViewMore.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_four:
                ImageView mImageView = (ImageView) getActivity ().findViewById(R.id.tab_menu_setting_partner);
                mImageView.setVisibility(View.VISIBLE);
                break;
        }
    }
}