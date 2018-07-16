package appoint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;

import appoint.entity.Doctor;

/**
 * Created by lenovo on 2018/4/18.
 */

public class DoctorAdapter extends BaseAdapter {
    private Context context;
    private List<Doctor> doctors;
    public DoctorAdapter(List<Doctor> doctors, Context context) {
        super();
        this.doctors = doctors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return doctors.size();
    }

    @Override
    public Object getItem(int position) {
        return doctors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_appoint_doctor, null);
            holder = new ViewHolder();
            holder.mMameTV = convertView.findViewById(R.id.tv_name);
            holder.mDepartmentTV = convertView.findViewById(R.id.tv_department);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mMameTV.setText(doctors.get(position).name);
        holder.mDepartmentTV.setText(doctors.get(position).department);
        return convertView;
    }

    static class ViewHolder {
        TextView mMameTV;
        TextView mDepartmentTV;
    }
}
