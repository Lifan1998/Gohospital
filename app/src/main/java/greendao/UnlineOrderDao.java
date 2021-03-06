package greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import appoint.entity.UnlineOrder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UNLINE_ORDER".
*/
public class UnlineOrderDao extends AbstractDao<UnlineOrder, Void> {

    public static final String TABLENAME = "UNLINE_ORDER";

    /**
     * Properties of entity UnlineOrder.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id_order = new Property(0, int.class, "id_order", false, "ID_ORDER");
        public final static Property Appoint_time = new Property(1, String.class, "appoint_time", false, "APPOINT_TIME");
        public final static Property Order_time = new Property(2, String.class, "order_time", false, "ORDER_TIME");
        public final static Property Id_user = new Property(3, int.class, "id_user", false, "ID_USER");
        public final static Property Id_doctor = new Property(4, int.class, "id_doctor", false, "ID_DOCTOR");
    }


    public UnlineOrderDao(DaoConfig config) {
        super(config);
    }
    
    public UnlineOrderDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UNLINE_ORDER\" (" + //
                "\"ID_ORDER\" INTEGER NOT NULL ," + // 0: id_order
                "\"APPOINT_TIME\" TEXT," + // 1: appoint_time
                "\"ORDER_TIME\" TEXT," + // 2: order_time
                "\"ID_USER\" INTEGER NOT NULL ," + // 3: id_user
                "\"ID_DOCTOR\" INTEGER NOT NULL );"); // 4: id_doctor
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UNLINE_ORDER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UnlineOrder entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId_order());
 
        String appoint_time = entity.getAppoint_time();
        if (appoint_time != null) {
            stmt.bindString(2, appoint_time);
        }
 
        String order_time = entity.getOrder_time();
        if (order_time != null) {
            stmt.bindString(3, order_time);
        }
        stmt.bindLong(4, entity.getId_user());
        stmt.bindLong(5, entity.getId_doctor());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UnlineOrder entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId_order());
 
        String appoint_time = entity.getAppoint_time();
        if (appoint_time != null) {
            stmt.bindString(2, appoint_time);
        }
 
        String order_time = entity.getOrder_time();
        if (order_time != null) {
            stmt.bindString(3, order_time);
        }
        stmt.bindLong(4, entity.getId_user());
        stmt.bindLong(5, entity.getId_doctor());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UnlineOrder readEntity(Cursor cursor, int offset) {
        UnlineOrder entity = new UnlineOrder( //
            cursor.getInt(offset + 0), // id_order
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // appoint_time
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // order_time
            cursor.getInt(offset + 3), // id_user
            cursor.getInt(offset + 4) // id_doctor
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UnlineOrder entity, int offset) {
        entity.setId_order(cursor.getInt(offset + 0));
        entity.setAppoint_time(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOrder_time(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setId_user(cursor.getInt(offset + 3));
        entity.setId_doctor(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UnlineOrder entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UnlineOrder entity) {
        return null;
    }

    @Override
    public boolean hasKey(UnlineOrder entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
