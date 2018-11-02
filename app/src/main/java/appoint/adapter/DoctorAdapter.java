package appoint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;

import appoint.entity.Doctor;
import appoint.utils.OtherUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

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
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_appoint_doctor, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemDoctorGrade.setText(doctors.get(position).getGrade());
        holder.itemDoctorGroup.setText(doctors.get(position).getGroup());
        OtherUtils.getHospitalName(doctors.get(position).getId_hospital(),context,holder.itemDoctorHospital);
        holder.itemDoctorName.setText(doctors.get(position).getName());
        holder.itemDoctorScore.setText(doctors.get(position).getScore());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_doctor_image)
        ImageView itemDoctorImage;
        @BindView(R.id.item_doctor_name)
        TextView itemDoctorName;
        @BindView(R.id.item_doctor_group)
        TextView itemDoctorGroup;
        @BindView(R.id.item_doctor_hospital)
        TextView itemDoctorHospital;
        @BindView(R.id.item_doctor_score)
        TextView itemDoctorScore;
        @BindView(R.id.item_doctor_grade)
        TextView itemDoctorGrade;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
