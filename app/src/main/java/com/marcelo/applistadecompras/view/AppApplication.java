package com.marcelo.applistadecompras.view;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppApplication extends Application {

    public static final String DB_NAME = "ListaDeCompras.realm";
    public static final int DB_VERSION = 1;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DB_NAME)
                .schemaVersion(DB_VERSION)
                .allowWritesOnUiThread(true)
                .build();

        Realm realm = Realm.getInstance(config);

        Log.d("db_log", "onCreate: Realm create success!" + " - versão: " + DB_VERSION);


    }
}
