package arnaud.boige.mareu;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;

import arnaud.boige.mareu.database.MareuDatabase;
import arnaud.boige.mareu.model.Reunion;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ReunionDaoTest {

   private MareuDatabase database;

    // DATA SET FOR TEST
    private static long REUNION_ID = 1;
    private static ArrayList<String> participants  = new ArrayList<String>(Collections.singleton("henri@lamzone.com, jack@lamzone.com"));
    private static Reunion REUNION_DEMO = new Reunion(REUNION_ID, "12", "06", "2021", "17", "45","B","Vacances", participants );



    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

   @Before
    public void initDb() throws Exception {
       this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),
                MareuDatabase.class)
                .allowMainThreadQueries()
               .build();
   }

   @After
    public void closeDb() throws Exception {
       database.close();
   }

    @Test
    public void insertAndGetUser() throws InterruptedException {
        // BEFORE : Adding a new user
        this.database.reunionDao().createReunion(REUNION_DEMO);
        // TEST
        Reunion reunion =  LiveDataTestUtil.getValue(this.database.reunionDao().getReunions(REUNION_ID));
        assertTrue(reunion.getDay().equals(REUNION_DEMO.getDay()) && reunion.getId() == REUNION_ID);
    }

}