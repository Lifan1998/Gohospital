package home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.life.R;


/**GridView显示界面用到的Adapter*/
public class GridAdapter extends BaseAdapter {
	
	int[] imageId = { R.drawable.erke,
			 R.drawable.fuchanke, R.drawable.pifuke, R.drawable.erke1, R.drawable.punei,R.drawable.xiaohua,
			 R.drawable.guke,R.drawable.gengduo};
	public String[] names = { "儿科","妇产科","心血管科","中医科","眼科","消化内科",
			"泌尿外科", "心胸外科" };
	private Context context;
	
	public GridAdapter(Context context) {
		this.context = context;
	}
	// 设置gridView一个多少个条目
	@Override
	public int getCount() {
		return 8;
	}
	// 设置每个条目的界面
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.item_home, null);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
		TextView tv_name = (TextView) view.findViewById(R.id.item_doctor_name);
		iv_icon.setImageResource(imageId[position]);
		tv_name.setText(names[position]);
		return view;
	}
	//  后面两个方法暂时不需要设置
	@Override
	public Object getItem(int position) {
		return names[position];
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
}