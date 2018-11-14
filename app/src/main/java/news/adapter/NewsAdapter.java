package news.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;
import com.lidroid.xutils.BitmapUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import news.model.Result;

/**
 * @author lifan
 * @date 2018/10/3 23:01
 * @email 2224779926@qq.com
 * @desc
 */

/**
 * Created by Administrator on 2016/4/10.
 */
public class NewsAdapter extends BaseAdapter {
    private Context context;

    private List<Result> dataList;

    private LayoutInflater inflater;

    private final int TYPE_COUNT = 4;

    private final int TYPE_ONE = 3;

    private final int TYPE_TWO = 1;

    private final int TYPE_THREE = 0;

    private int currentType;



    public NewsAdapter(Context context, List<Result> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        Result result = dataList.get(position);
        List<String> imageUrls = result.getImageUrl();
        currentType = getItemViewType(position);
        //根据currentType来加载不同的布局,并复用convertview
        if (currentType == TYPE_ONE) {
            ViewHolderOne viewHolderOne;
            //首先判断convertview==null
            if (convertView == null) {

                convertView = inflater.inflate(R.layout.item_news_1, null);
                viewHolderOne = new ViewHolderOne(convertView);

                convertView.setTag(viewHolderOne);
            } else {
                viewHolderOne = (ViewHolderOne) convertView.getTag();
            }
            Picasso.get().load(imageUrls.get(0)).fit().into(viewHolderOne.itemNews1Image1);
            Picasso.get().load(imageUrls.get(1)).fit().into(viewHolderOne.itemNews1Image2);
            Picasso.get().load(imageUrls.get(2)).fit().into(viewHolderOne.itemNews1Image3);
            Log.v("Adapter",imageUrls.get(0));
            viewHolderOne.itemNews1Title.setText(result.getTitle());
            //viewHolderOne.itemNews1Comment.setText(result.getComment()+"");
            viewHolderOne.itemNews1Time.setText(result.getTime());
            viewHolderOne.itemNews1Author.setText(result.getAuthor()+"|");
            viewHolderOne.itemNews1Recommend.setText(result.getRecommend()+"");


        } else if (currentType == TYPE_TWO) {
            ViewHolderTwo viewHolderTwo;
            if (convertView == null) {

                convertView = inflater.inflate(R.layout.item_news_2, null);
                viewHolderTwo = new ViewHolderTwo(convertView);
                convertView.setTag(viewHolderTwo);
            } else {
                viewHolderTwo = (ViewHolderTwo) convertView.getTag();
            }
            Picasso.get().load(imageUrls.get(0)).fit().into(viewHolderTwo.itemNews2Image1);

            viewHolderTwo.itemNews2Title.setText(result.getTitle());
            //viewHolderTwo.itemNews2Comment.setText(result.getComment()+"");
            viewHolderTwo.itemNews2Time.setText(result.getTime());
            viewHolderTwo.itemNews2Author.setText(result.getAuthor()+"|");
            viewHolderTwo.itemNews2Recommend.setText(result.getRecommend()+"");

        } else if (currentType == TYPE_THREE) {
            ViewHolderThree viewHolderThree;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_news_3, null);
                viewHolderThree = new ViewHolderThree(convertView);
                convertView.setTag(viewHolderThree);

            } else {
                viewHolderThree = (ViewHolderThree) convertView.getTag();
            }
            viewHolderThree.itemNews3Title.setText(result.getTitle());
            viewHolderThree.itemNews3Intro.setText(result.getIntro());
            //viewHolderThree.itemNews3Comment.setText(result.getComment()+"");
            viewHolderThree.itemNews3Time.setText(result.getTime());
            viewHolderThree.itemNews3Author.setText(result.getAuthor()+"|");
            viewHolderThree.itemNews3Recommend.setText(result.getRecommend()+"");

        }


        return convertView;
    }


    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("debug", "position=" + position);
        Result result = dataList.get(position);
        Log.i("ddd", "result=" + result);
        int type = result.getType();
        switch (type) {
            case TYPE_ONE:
                return TYPE_ONE;

            case TYPE_TWO:
                return TYPE_TWO;

            case TYPE_THREE:
                return TYPE_THREE;
            default:
                return -1;
        }
    }


    static class ViewHolderOne {
        @BindView(R.id.item_news1_title)
        TextView itemNews1Title;
        @BindView(R.id.item_news1_image1)
        ImageView itemNews1Image1;
        @BindView(R.id.item_news1_image2)
        ImageView itemNews1Image2;
        @BindView(R.id.item_news1_image3)
        ImageView itemNews1Image3;
        @BindView(R.id.item_news1_author)
        TextView itemNews1Author;
        @BindView(R.id.item_news1_time)
        TextView itemNews1Time;

        @BindView(R.id.item_news1_recommend)
        TextView itemNews1Recommend;

        ViewHolderOne(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderTwo {
        @BindView(R.id.item_news2_title)
        TextView itemNews2Title;
        @BindView(R.id.item_news2_author)
        TextView itemNews2Author;
        @BindView(R.id.item_news2_time)
        TextView itemNews2Time;

        @BindView(R.id.item_news2_recommend)
        TextView itemNews2Recommend;
        @BindView(R.id.item_news2_image1)
        ImageView itemNews2Image1;

        ViewHolderTwo(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolderThree {
        @BindView(R.id.item_news3_title)
        TextView itemNews3Title;
        @BindView(R.id.item_news3_intro)
        TextView itemNews3Intro;
        @BindView(R.id.item_news3_author)
        TextView itemNews3Author;
        @BindView(R.id.item_news3_time)
        TextView itemNews3Time;

        @BindView(R.id.item_news3_recommend)
        TextView itemNews3Recommend;

        ViewHolderThree(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
