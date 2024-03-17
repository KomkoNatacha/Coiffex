package ca.dmi.uqtr.coiffex3;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.multidex.MultiDexApplication;
import androidx.room.Room;

import com.google.firebase.FirebaseApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.dmi.uqtr.coiffex3.db.repos.CoiffexRepository;
import ca.dmi.uqtr.coiffex3.db.repos.CoiffureDB;

public class CoiffexApp extends MultiDexApplication implements ViewModelStoreOwner {
    private CoiffureDB coiffureDB;
    private ViewModelStore store;
    private ExecutorService dbWPool = Executors.newFixedThreadPool(1);
    private ExecutorService dbRPool = Executors.newFixedThreadPool(5);

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        coiffureDB = Room.databaseBuilder(this, CoiffureDB.class, "coiffex_db")
                .fallbackToDestructiveMigration()
                .build();
        store = new ViewModelStore();
    }

   /* public CoiffexRepository getCoiffexRepository() {
        return new CoiffexRepository(this);
    }*/

    public CoiffureDB getDb() {
        return coiffureDB;
    }

    public ExecutorService writeExecutor() {
        return dbWPool;
    }

    public void dbPostRead(Runnable task) {
        dbRPool.submit(task);
    }

    /*@Override
    public ViewModelStoreOwner getOwner() {
        return () -> store;
    }*/

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return null;
    }
}
