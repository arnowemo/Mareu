package arnaud.boige.mareu.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import arnaud.boige.mareu.model.Reunion;

@Dao
public interface ReunionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createReunion(Reunion reunion);

    @Query("SELECT * FROM Reunion WHERE id = :id")
    LiveData<Reunion> getReunions ( long id);

    @Insert
    long insertReunion(Reunion reunion);


    @Update
    int updateReunion(Reunion reunion);

    @Query("DELETE FROM Reunion WHERE id = :id")
    int deleteReunion(long id);

}
