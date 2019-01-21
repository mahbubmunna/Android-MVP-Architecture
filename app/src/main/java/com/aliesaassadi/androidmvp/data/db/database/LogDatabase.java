package com.aliesaassadi.androidmvp.data.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.WorkerThread;

import com.aliesaassadi.androidmvp.App;
import com.aliesaassadi.androidmvp.data.db.dao.LogDAO;
import com.aliesaassadi.androidmvp.data.db.entity.LogClass;

/**
 * Created by Ali Esa Assadi on 07/03/2018.
 */

@Database(entities = {LogClass.class}, version = 2 , exportSchema = false)
public abstract class LogDatabase extends RoomDatabase {

    private static LogDatabase sInstance;

    @WorkerThread
    public abstract LogDAO logDao();

    public static LogDatabase getInstance() {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(App.getInstance(), LogDatabase.class, "log-database")
                    .fallbackToDestructiveMigration().build();
        }
        return sInstance;
    }
}
