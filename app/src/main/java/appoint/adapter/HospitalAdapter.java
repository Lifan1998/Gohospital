package appoint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;


import appoint.entity.Hospital;

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
       ViewHolder holder ;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_appoint_hospital,null);
            holder = new ViewHolder();
            holder.mNameTV =  convertView.findViewById(R.id.hospital_name);
            holder.mGradeTV =  convertView.findViewById(R.id.hospital_grade);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mNameTV.setText(hospitals.get(position).name);
        holder.mGradeTV.setText(hospitals.get(position).grade);
        return convertView;
    }

    static class ViewHolder {
        TextView mNameTV;
        TextView mGradeTV;
    }
}
