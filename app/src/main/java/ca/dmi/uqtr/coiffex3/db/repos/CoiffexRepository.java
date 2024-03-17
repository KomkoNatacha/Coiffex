package ca.dmi.uqtr.coiffex3.db.repos;


import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import ca.dmi.uqtr.coiffex3.CoiffexApp;
import ca.dmi.uqtr.coiffex3.db.dao.CoiffexDAO;
import ca.dmi.uqtr.coiffex3.db.model.CoiffexInfo;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CoiffexRepository {

        private final CoiffexDAO coiffexDAO;
        private final ExecutorService executorService;
        private static CoiffureDB coiffureDB;

        public CoiffexRepository(CoiffexApp context) {
            coiffureDB = getInstance(context);
            coiffexDAO = coiffureDB.getCoiffexDAO();
            executorService = Executors.newSingleThreadExecutor();
        }

        public static synchronized CoiffureDB getInstance(Context context) {
            if (coiffureDB == null) {
                coiffureDB = Room.databaseBuilder(context.getApplicationContext(),
                                CoiffureDB.class, "coiffex_db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return coiffureDB;
        }

        public LiveData<List<CoiffexInfo>> getAllCoiffexInfos() {
            return coiffexDAO.getAllCoiffexInfos();
        }

        public void insert(CoiffexInfo coiffexInfo) {
            executorService.submit(() -> coiffexDAO.addUser(coiffexInfo));
        }

    public CoiffexInfo  getUser(String email, String pw) throws ExecutionException, InterruptedException {
        Future<CoiffexInfo> info = executorService.submit(new Callable<CoiffexInfo>() {
            @Override
            public CoiffexInfo call() throws Exception {
                return coiffexDAO.singIn(email, pw);
            }
        });

        return info.get();
    }

       // public void deleteAll() {
         //   executorService.execute(coiffexDAO::deleteAll);
        //}
    }


