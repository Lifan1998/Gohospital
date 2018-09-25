package greendao;

import android.content.Context;

import org.greenrobot.greendao.database.Database;



/**
 * @author lifan
 * @date 2018/8/3 17:31
 * @email 2224779926@qq.com
 * @desc
 */

public class DatabaseUtils {
    private  static  String DATABASE_NAME = "gohospiatl";
    private  static DaoSession daoSessiom;

    public  static DaoSession getDaoSession(Context  context){

        if(daoSessiom==null){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,DATABASE_NAME);
            Database db = devOpenHelper.getWritableDb();
            DaoMaster daoMaster = new DaoMaster(db);
            daoSessiom =daoMaster.newSession();
        }
        return daoSessiom;
    }
}
