package com.example.sportinside;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.sportinside.data.LocalDataSource;
import com.example.sportinside.data.RemoteDataSource;
import com.example.sportinside.data.TeamByName.entities.TeamEntity;
import com.example.sportinside.data.TeamByName.entities.Teams;

import java.util.List;
import java.util.concurrent.Executors;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    public Repository (Context context){
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }
    public LiveData<List<TeamEntity>> getTeamData(final String team){

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Log.e("Repository","Run");
                Teams response = remoteDataSource.getTeams(team);
                localDataSource.storeTeams(response);
                Log.e("Repository","Proshlo?");
            }
        } );
        return localDataSource.getTeam();
    }
}
