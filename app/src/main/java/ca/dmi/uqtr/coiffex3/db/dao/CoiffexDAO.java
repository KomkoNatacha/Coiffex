package ca.dmi.uqtr.coiffex3.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import java.util.List;
import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;


@Dao
public interface CoiffexDAO {
    @Insert
    void addUser(CoiffexInfo coiffexinfos);
    @Update
    void update(CoiffexInfo coiffexinfos);

    @Delete
    void delete(CoiffexInfo coiffexinfos);

    @Query("SELECT * FROM coiffexinfos WHERE email = :email AND password = :password")
    CoiffexInfo singIn(String email , String password);


    //void deleteAll();

    @Query("SELECT * FROM coiffexinfos")
    LiveData<List<CoiffexInfo>> getAllCoiffexInfos();

    @Query("SELECT * FROM coiffexinfos")
    List<CoiffexInfo> getUsers();

    @Query("SELECT * FROM coiffexinfos WHERE id = :coiffexId")
    LiveData<CoiffexInfo> getCoiffexById(long coiffexId);

/*
    @Query("SELECT * FROM coiffexinfo")
    LiveData<List<CoiffexInfo>> getAllCoiffexInfos();

    @Query("DELETE FROM coiffexinfo")
    void deleteAll();




    */

}
