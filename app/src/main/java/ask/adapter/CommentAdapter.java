package ask.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import ask.model.Comment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author lifan
 * @date 2018/11/5 0:02
 * @email 2224779926@qq.com
 * @desc
 */

public class CommentAdapter extends BaseAdapter {
    private Context context;
    private List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments) {
        super();
        this.context = context;
        this.comments = comments;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_comment, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.get().load(comments.get(position).getUserImgURL()).into(holder.itemAskImage);
        holder.itemAskName.setText(comments.get(position).getName());
        holder.itemAskTime.setText(comments.get(position).getDate());
        if(comments.get(position).getUserType()==Comment.TYPE_D){
            holder.itemAskIdentity.setVisibility(View.VISIBLE);
        }else {
            holder.itemAskIdentity.setVisibility(View.INVISIBLE);
        }
        holder.itemCommentCommendSum.setText(comments.get(position).getCommendSum()+"");
        holder.itemAskComment.setText(comments.get(position).getCommentText());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.item_ask_image)
        CircleImageView itemAskImage;
        @BindView(R.id.item_ask_name)
        TextView itemAskName;
        @BindView(R.id.item_ask_identity)
        TextView itemAskIdentity;
        @BindView(R.id.item_ask_time)
        TextView itemAskTime;
        @BindView(R.id.item_comment_commend_sum)
        TextView itemCommentCommendSum;
        @BindView(R.id.iv_commend)
        ImageView ivCommend;
        @BindView(R.id.item_ask_comment)
        TextView itemAskComment;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
        /**
         * 是否点赞
         */
        @OnClick(R.id.iv_commend)
        public void selectCommend(){
            if(ivCommend.isSelected()){
                ivCommend.setSelected(false);

            }else{
                ivCommend.setSelected(true);

            }

        }
    }
}
