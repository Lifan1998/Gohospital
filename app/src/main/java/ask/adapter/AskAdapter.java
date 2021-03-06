package ask.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.life.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import appoint.adapter.HospitalAdapter;
import ask.model.AskItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author lifan
 * @date 2018/10/4 15:06
 * @email 2224779926@qq.com
 * @desc
 */

public class AskAdapter extends BaseAdapter {
    private Context context;
    private List<AskItem> askItems;


    public AskAdapter(Context context, List<AskItem> askItems) {
        super();
        this.context = context;
        this.askItems = askItems;
    }

    @Override
    public int getCount() {
        return askItems.size();
    }

    @Override
    public Object getItem(int position) {
        return askItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_ask, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        holder.itemAskCollect.setText(askItems.get(position).getCollect()+"");
        holder.itemAskComment.setText(askItems.get(position).getComment()+"");
        holder.itemAskName.setText(askItems.get(position).getName());
        holder.itemAskTitle.setText(askItems.get(position).getTitle());
        holder.itemAskTime.setText(askItems.get(position).getTime());

        //选择显示方式 图片or文字
        switch (askItems.get(position).getImageurl().size()){
            case 3:
                Picasso.get().load(askItems.get(position).getImageurl().get(2)).fit().into(holder.itemAskImage3);
            case 2:
                Picasso.get().load(askItems.get(position).getImageurl().get(1)).fit().into(holder.itemAskImage2);
            case 1:
                Picasso.get().load(askItems.get(position).getImageurl().get(0)).fit().into(holder.itemAskImage1);
                break;
            case 0:
                holder.askLayImage.setVisibility(View.INVISIBLE);
                holder.itemAskIntro.setVisibility(View.VISIBLE);
                holder.itemAskIntro.setText(askItems.get(position).getIntro());
                break;
        }


        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.item_ask_image)
        CircleImageView itemAskImage;
        @BindView(R.id.item_ask_name)
        TextView itemAskName;
        @BindView(R.id.item_ask_time)
        TextView itemAskTime;
        @BindView(R.id.item_ask_title)
        TextView itemAskTitle;
        @BindView(R.id.item_ask_intro)
        TextView itemAskIntro;
        @BindView(R.id.item_ask_image1)
        ImageView itemAskImage1;
        @BindView(R.id.item_ask_image2)
        ImageView itemAskImage2;
        @BindView(R.id.item_ask_image3)
        ImageView itemAskImage3;
        @BindView(R.id.item_ask_collect)
        TextView itemAskCollect;
        @BindView(R.id.item_ask_comment)
        TextView itemAskComment;
        @BindView(R.id.ask_layimage)
        LinearLayout askLayImage;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

