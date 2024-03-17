package ca.dmi.uqtr.coiffex3.db.repos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ca.dmi.uqtr.coiffex3.db.dao.CoiffexDAO;
import ca.dmi.uqtr.coiffex3.db.dao.ReservationDao;

import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;
import ca.dmi.uqtr.coiffex3.db.model.GestionReservation;

@Database( version = 1, entities = {GestionReservation.class})

public abstract class ReservationDatabase extends RoomDatabase {
    private Context context;
    public abstract ReservationDao getReservationDao();

    private static ReservationDatabase INSTANCE;


    public static synchronized ReservationDatabase Instance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(),
                            ReservationDatabase.class, "reservation_database")
                    .build();
            INSTANCE.context = context;
        }
        return INSTANCE;
    }



}





