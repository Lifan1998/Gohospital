package appoint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;

import appoint.entity.Hospital;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/4/18.
 */

public class HospitalAdapter extends BaseAdapter {
    private Context context;
    private List<Hospital> hospitals;


    public HospitalAdapter(List<Hospital> hospitals, Context context) {
        super();
        this.context = context;
        this.hospitals = hospitals;
    }

    @Override
    public int getCount() {
        return hospitals.size();
    }

    @Override
    public Object getItem(int position) {
        return hospitals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_appoint_hospital, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemHospitalName.setText(hospitals.get(position).name);
        holder.itemHospitalGrade.setText(hospitals.get(position).grade);
        holder.itemHospitalAddress.setText(hospitals.get(position).address);
        holder.itemHospitalScore.setText(hospitals.get(position).score);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_hospital_view)
        ImageView itemHospitalView;
        @BindView(R.id.item_hospital_name)
        TextView itemHospitalName;
        @BindView(R.id.item_hospital_grade)
        TextView itemHospitalGrade;
        @BindView(R.id.item_hospital_address)
        TextView itemHospitalAddress;
        @BindView(R.id.item_hospital_score)
        TextView itemHospitalScore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
