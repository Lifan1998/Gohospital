package appoint.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.life.R;

import java.util.List;

import appoint.HospitalActivity;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lifan
 * @date 2018/8/4 0:13
 * @email 2224779926@qq.com
 * @desc
 */

public class DeptAdapter extends BaseAdapter {
    private Context context;
    private List<String> strs;
    private int defaultSelection = -1;
    private int tag = 0;


    public DeptAdapter(List<String> strs, Context context) {
        super();
        this.strs = strs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public Object getItem(int position) {
        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_appoint_keshi, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.itemKeshi.setText(strs.get(position));
        if(tag==1){
           holder.itemKeshi.setGravity(View.TEXT_ALIGNMENT_CENTER);

        }
        if(position == defaultSelection){
            holder.itemKeshi.setTextColor(holder.red);
            holder.itemKeshi.setBackgroundColor(holder.white);
        } else {
            holder.itemKeshi.setTextColor(holder.brank);
            holder.itemKeshi.setBackgroundColor(holder.trans);
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_keshi)
        TextView itemKeshi;
        @BindColor(R.color.text_red)
        int red;
        @BindColor(R.color.text_white)
        int white;
        @BindColor(R.color.transparent)
        int trans;
        @BindColor(R.color.brank)
        int brank;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    public void setSelectSelection(int position){
        if(!(position<0||position>strs.size())){
            defaultSelection = position;
            notifyDataSetChanged();
        }

    }
    public void setFlag(int tag){
        this.tag = tag;
    }
}
