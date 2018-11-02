package ask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.R;

import ask.model.AskItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import config.CollectionUtils;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author lifan
 * @date 2018/10/20 16:32
 * @email 2224779926@qq.com
 * @desc
 */

public class AskOpenActivity extends Activity {
    @BindView(R.id.layout_return)
    LinearLayout layoutReturn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.tv_msg_num)
    TextView tvMsgNum;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.ask_title)
    TextView askTitle;
    @BindView(R.id.item_ask_image)
    CircleImageView itemAskImage;
    @BindView(R.id.item_ask_name)
    TextView itemAskName;
    @BindView(R.id.item_ask_time)
    TextView itemAskTime;
    @BindView(R.id.ask_intro)
    TextView askIntro;
    @BindView(R.id.item_ask_image1)
    ImageView itemAskImage1;
    @BindView(R.id.item_ask_image2)
    ImageView itemAskImage2;
    @BindView(R.id.item_ask_image3)
    ImageView itemAskImage3;
    @BindView(R.id.edit_commend)
    EditText editCommend;
    @BindView(R.id.btn_commend)
    TextView btnCommend;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_commend)
    ImageView ivCommend;
    private AskItem askItem;

    @Override
    protected void onCreate(Bundle saveInstanceStart) {
        super.onCreate(saveInstanceStart);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ask_open);
        ButterKnife.bind(this);
        askItem = getIntent().getParcelableExtra("askItem");
        CollectionUtils.isInCollect(getApplicationContext(),CollectionUtils.FLAG_ASK,askItem.getId(),ivLove);
        ininView();

    }

    private void ininView() {
        tvTitle.setText("问题详情");
        askTitle.setText(askItem.getTitle());
        askIntro.setText(askItem.getIntro());
        itemAskName.setText(askItem.getName());
        itemAskTime.setText(askItem.getTime());
    }

    /**
     * 是否收藏
     */
    @OnClick(R.id.iv_love)
    public void selectLove(){
        if(ivLove.isSelected()){
            ivLove.setSelected(false);
            CollectionUtils.collection(AskOpenActivity.this,CollectionUtils.FLAG_ASK,askItem.getId(),0);
            Toast.makeText(getApplicationContext(),"已取消收藏",Toast.LENGTH_SHORT).show();
        }else{
            ivLove.setSelected(true);
            CollectionUtils.collection(AskOpenActivity.this,CollectionUtils.FLAG_ASK,askItem.getId(),1);
            Toast.makeText(getApplicationContext(),"已收藏",Toast.LENGTH_SHORT).show();
        }

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
    @OnClick(R.id.layout_return)
    public void close(){
        finish();
    }


}
