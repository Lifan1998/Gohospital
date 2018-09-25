package greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import appoint.entity.Hospital;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HOSPITAL".
*/
public class HospitalDao extends AbstractDao<Hospital, Void> {

    public static final String TABLENAME = "HOSPITAL";

    /**
     * Properties of entity Hospital.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Imageurl = new Property(1, String.class, "imageurl", false, "IMAGEURL");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Grade = new Property(3, String.class, "grade", false, "GRADE");
        public final static Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public final static Property Score = new Property(5, String.class, "score", false, "SCORE");
    }


    public HospitalDao(DaoConfig config) {
        super(config);
    }
    
    public HospitalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HOSPITAL\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"IMAGEURL\" TEXT," + // 1: imageurl
                "\"NAME\" TEXT," + // 2: name
                "\"GRADE\" TEXT," + // 3: grade
                "\"ADDRESS\" TEXT," + // 4: address
                "\"SCORE\" TEXT);"); // 5: score
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOSPITAL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Hospital entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String imageurl = entity.getImageurl();
        if (imageurl != null) {
            stmt.bindString(2, imageurl);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(4, grade);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String score = entity.getScore();
        if (score != null) {
            stmt.bindString(6, score);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Hospital entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String imageurl = entity.getImageurl();
        if (imageurl != null) {
            stmt.bindString(2, imageurl);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String grade = entity.getGrade();
        if (grade != null) {
            stmt.bindString(4, grade);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String score = entity.getScore();
        if (score != null) {
            stmt.bindString(6, score);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Hospital readEntity(Cursor cursor, int offset) {
        Hospital entity = new Hospital( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // imageurl
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // grade
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // address
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // score
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Hospital entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setImageurl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGrade(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setScore(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Hospital entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Hospital entity) {
        return null;
    }

    @Override
    public boolean hasKey(Hospital entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
