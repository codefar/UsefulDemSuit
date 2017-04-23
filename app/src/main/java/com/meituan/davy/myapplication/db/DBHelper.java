package com.meituan.davy.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.meituan.davy.myapplication.db.entity.tomany.DaoMaster;
import com.meituan.davy.myapplication.db.entity.tomany.DaoSession;

import java.io.File;
import java.io.IOException;

/**
 * Created by davy on 2017/4/19.
 */

public class DBHelper {
    public static DaoSession initDB(Context context) {
        //DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "users-db");
        //SQLiteDatabase database  = devOpenHelper.getWritableDatabase();

        File file = new File(context.getExternalFilesDir("databases"), "notes.db");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(file, null);
        DaoMaster daoMaster = new DaoMaster(database);
        DaoMaster.createAllTables(daoMaster.getDatabase(), true);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }
}
