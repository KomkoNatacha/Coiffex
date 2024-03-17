package ca.dmi.uqtr.coiffex3.db.repos;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import ca.dmi.uqtr.coiffex3.db.dao.CoiffexDAO;
import ca.dmi.uqtr.coiffex3.db.dao.ReservationDao;
import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;
import ca.dmi.uqtr.coiffex3.db.model.GestionReservation;


@Database( version = 3, entities = {CoiffexInfo.class})
 public abstract class CoiffureDB extends RoomDatabase {
    private Context context;
    public abstract CoiffexDAO getCoiffexDAO();


    private static CoiffureDB INSTANCE;
    public synchronized static CoiffureDB instance(Context context) {
        if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(),
                                    CoiffureDB.class, "coiffuredatab")
                            .build();
                    INSTANCE.context = context;
                }
        return INSTANCE;
    }

}
