package com.example.sportinside;

import android.app.Application;

public class SportApp extends Application {
    private Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(this);
    }

    public Repository getRepository() {
        return repository;
    }
}
