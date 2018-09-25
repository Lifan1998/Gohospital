package init;

import java.io.File;
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
import com.azhon.appupdate.manager.DownloadManager;
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



/** 更新提醒工具类 */
public class VersionUpdateUtils {
	private static final int MESSAGE_NET_EEOR = 101;
	private static final int MESSAGE_IO_EEOR = 102;
	private static final int MESSAGE_JSON_EEOR = 103;

	/** 用于更新UI */
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MESSAGE_IO_EEOR:
				Toast.makeText(context, "IO异常", Toast.LENGTH_SHORT).show();

				break;
			case MESSAGE_JSON_EEOR:
				Toast.makeText(context, "JSON解析异常", Toast.LENGTH_SHORT).show();

				break;
			case MESSAGE_NET_EEOR:
				Toast.makeText(context, "网络异常", Toast.LENGTH_SHORT).show();

				break;
			}
		};
	};
	/** 本地版本号 */
	private String mVersion;
	private Activity context;

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
			JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://192.168.137.1:8080/Test/updateinfo.html",null,
					new Response.Listener<JSONObject>() {
							
						@Override
						public void onResponse(JSONObject response) {
							
							Log.v("TAG", response.toString());

							versionEntity = new VersionEntity();
							try {

								versionEntity.versioncode = response.getString("code");

								versionEntity.description = response.getString("des");

								versionEntity.apkurl = response.getString("apkurl");

								versionEntity.versionName = response.getString("versionName");

								versionEntity.size = response.getString("size");

							
							} catch (JSONException e) {
								
								handler.sendEmptyMessage(MESSAGE_JSON_EEOR);
								e.printStackTrace();
							}
							download();
							
						}
					}, new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError error) {
							
							Log.e("TAG", error.getMessage(),error);
							handler.sendEmptyMessage(MESSAGE_NET_EEOR);
						}
					})
			{
				@Override
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




	private void download(){

		DownloadManager downloadManager = DownloadManager.getInstance(context);
		downloadManager.setApkName("Gohosiptal_v"+versionEntity.versionName+".apk")
				.setApkVersionCode(Integer.parseInt(versionEntity.versioncode))
				.setApkVersionName(versionEntity.versionName)
				.setApkDescription(versionEntity.description)
				.setApkSize(versionEntity.size)
				.setDownloadPath(Environment.getExternalStorageDirectory() + "/AppUpdate")
				.setApkUrl(versionEntity.apkurl)
				.setSmallIcon(R.drawable.ic_launcher)
				.setShowNewerToast(true)
				.download();
	}
}
