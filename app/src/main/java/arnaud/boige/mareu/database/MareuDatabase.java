package arnaud.boige.mareu.database;


import android.content.ContentValues;
import android.content.Context;
import android.media.MediaDrm;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import arnaud.boige.mareu.database.dao.ReunionDao;
import arnaud.boige.mareu.model.Reunion;

@Database(entities = {Reunion.class}, version = 1 ,exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MareuDatabase extends RoomDatabase {

    // SINGLETON

    private static volatile MareuDatabase INSTANCE;

    // DAO

    public abstract ReunionDao reunionDao();

    // INSTANCE

    public static MareuDatabase getInstance(Context context) {
        if (INSTANCE == null){
            synchronized (MareuDatabase.class) {
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MareuDatabase.class, "MyDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // ----

    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db){
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id",1);
                contentValues.put("mDay","12");
                contentValues.put("mMonth","06");
                contentValues.put("mYear","2021");
                contentValues.put("mHour","17");
                contentValues.put("mMinute","30");
                contentValues.put("mLocation","B");
                contentValues.put("mSubject","Projet Juillet");
                contentValues.put("mParticipant","henri@lamzone.com");

                db.insert("Reunion", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }
}
