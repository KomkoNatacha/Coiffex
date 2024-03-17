package ca.dmi.uqtr.coiffex3.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ca.dmi.uqtr.coiffex3.db.model.GestionReservation;

@Dao
public interface ReservationDao {
    @Query("SELECT * FROM reservations")
    List<GestionReservation> getAllReservations();

    @Query("SELECT * FROM reservations WHERE id = :id")
    GestionReservation getReservationById(int id);

    @Insert
    void insertReservation(GestionReservation reservation);

    @Update
    void updateReservation(GestionReservation reservation);

    @Delete
    void deleteReservation(GestionReservation reservation);
}
