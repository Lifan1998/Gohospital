package loading;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.life.R;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import home.HomeActivity;
import loading.DownLoadUtils.MyCallBack;

/** 更新提醒工具类 */
public class VersionUpdateUtils {
	private static final int MESSAGE_NET_EEOR = 101;
	private static final int MESSAGE_IO_EEOR = 102;
	private static final int MESSAGE_JSON_EEOR = 103;
	private static final int MESSAGE_SHOEW_DIALOG = 104;
	protected static final int MESSAGE_ENTERHOME = 105;
	/** 用于更新UI */
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MESSAGE_IO_EEOR:
				Toast.makeText(context, "IO异常", Toast.LENGTH_SHORT).show();
				enterHome();
				break;
			case MESSAGE_JSON_EEOR:
				Toast.makeText(context, "JSON解析异常", Toast.LENGTH_SHORT).show();
				enterHome();
				break;
			case MESSAGE_NET_EEOR:
				Toast.makeText(context, "网络异常", Toast.LENGTH_SHORT).show();
				enterHome();
				break;
			case MESSAGE_SHOEW_DIALOG:
				showUpdateDialog(versionEntity);
				break;
			case MESSAGE_ENTERHOME:
				Intent intent = new Intent(context,HomeActivity.class);
				context.startActivity(intent);
				context.finish();
				break;
			}
		};
	};
	/** 本地版本号 */
	private String mVersion;
	private Activity context;
	private ProgressDialog mProgressDialog;
	private VersionEntity versionEntity;

	
	public VersionUpdateUtils(String Version,Activity activity) {
		mVersion = Version;
		context = activity;
	}

	/**
	 * 获取服务器版本号
	 */
	
	public void getCloudVersion(){
		
			RequestQueue mQueue =Volley.newRequestQueue(context);
			JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://10.0.2.2:8080/updateinfo.html",null,
					new Response.Listener<JSONObject>() {
							
						@Override
						public void onResponse(JSONObject response) {
							
							Log.v("TAG", response.toString());

							versionEntity = new VersionEntity();
							try {
							String code = response.getString("code");
							versionEntity.versioncode = code;
							String des = response.getString("des");
							versionEntity.description = des;
							String apkurl = response.getString("apkurl");
							versionEntity.apkurl = apkurl;
							Log.v("TAG", apkurl);
							System.out.print(apkurl);
							
							} catch (JSONException e) {
								
								handler.sendEmptyMessage(MESSAGE_JSON_EEOR);
								e.printStackTrace();
							}
							if (!mVersion.equals(versionEntity.versioncode)) {
								// 版本号不一致
								
								handler.sendEmptyMessage(MESSAGE_SHOEW_DIALOG);
							} else {
								enterHome();
							}
							
						}
					}, new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError error) {
							
							Log.e("TAG", error.getMessage(),error);
							handler.sendEmptyMessage(MESSAGE_NET_EEOR);
						}
					})
			{
				protected Response<JSONObject> parseNetworkResponse(NetworkResponse response){
					JSONObject jsonObject;
					try {
						jsonObject = new JSONObject(new String(response.data,"UTF-8"));
						return Response.success(jsonObject,HttpHeaderParser.parseCacheHeaders(response));
					} catch (UnsupportedEncodingException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						return Response.error(new ParseError(e));
					}
					return null;
					
				}
			};
			
			mQueue.add(jsonObjectRequest);
				
			
			
		
		
	}

	/**
	 * 弹出更新提示对话框
	 * 
	 * @param versionEntity
	 */
	private void showUpdateDialog(final VersionEntity versionEntity) {
		// 创建dialog
		AlertDialog.Builder builder = new Builder(context);
		builder.setTitle("检查到新版本：" + versionEntity.versioncode);// 设置标题
		builder.setMessage(versionEntity.description);// 根据服务器返回描述,设置升级描述信息
		builder.setCancelable(false);// 设置不能点击手机返回按钮隐藏对话框
		builder.setIcon(R.drawable.ic_launcher);// 设置对话框图标
		// 设置立即升级按钮点击事件  
		builder.setPositiveButton("立即升级",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						initProgressDialog();
						downloadNewApk(versionEntity.apkurl);
					}
				});
		// 设置暂不升级按钮点击事件
		builder.setNegativeButton("暂不升级",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						enterHome();
					}
				});
		// 对话框必须调用show方法 否则不显示
		builder.show();
	}
	
	/**
	 * 初始化进度条对话框
	 */
	private void initProgressDialog() {
		mProgressDialog = new ProgressDialog(context);
		mProgressDialog.setMessage("准备下载...");
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.show();
	}

	/***
	 * 下载新版本
	 */

	//public final static String SD_FOLDER = Environment.getExternalStorageDirectory()+ "/VersionChecker/";
	//private static final String TAG = AppInnerDownLoder.class.getSimpleName();

	protected void downloadNewApk(String apkurl) {
		DownLoadUtils downLoadUtils = new DownLoadUtils();
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
		{
		// 获得存储卡的路径
			String sdpath = android.os.Environment.getExternalStorageDirectory() + "/";
            // 获取跟目录
            String sdDir = Environment.getExternalStorageDirectory().toString();
            Log.v("TAG",sdDir);
            Log.v("TAG",sdpath);
        }else{
		    Log.v("TAG","储存卡无");
		}
		downLoadUtils.downapk(apkurl,"/mnt/sdcard/Gohospital.apk" , new MyCallBack() {
			
			@Override
			public void onSuccess(ResponseInfo<File> arg0) {
				// TODO Auto-generated method stub
				mProgressDialog.dismiss();
				Log.v("TAG", "下载成功");
				MyUtils.installApk(context);
			}
			
			@Override
			public void onLoadding(long total, long current, boolean isUploading) {
				// TODO Auto-generated method stub
				mProgressDialog.setMax((int)total);
				mProgressDialog.setMessage("正在下载...");
				Log.v("TAG", "正在下载");
				mProgressDialog.setProgress((int) current);
			}
			
			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				mProgressDialog.setMessage("下载失败");
				Log.v("TAG", "下载失败");
				mProgressDialog.dismiss();
				enterHome();
			}

			
		});
	}
	private void enterHome() {
		handler.sendEmptyMessageDelayed(MESSAGE_ENTERHOME, 1000);
	}
}
