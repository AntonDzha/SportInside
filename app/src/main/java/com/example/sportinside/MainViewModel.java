package com.example.sportinside;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sportinside.data.TeamByName.entities.TeamEntity;

import java.util.List;

public class MainViewModel extends ViewModel {

    private Repository repository;
    LiveData<List<TeamEntity>> teamData;//list

    public void loadData(Repository repository, String team){
        this.repository = repository;
        Log.e("Vhod","yeee");
        if(teamData==null){
            Log.e("Vhod","voshlo");
            //repository = new Repository(context);
            teamData = repository.getTeamData(team);

        }


    }
    public LiveData<List<TeamEntity>> getTeamData(){

        return teamData;
    }


    //public void getDataByCity(String city){
    //weatherData = repository.getWeatherForCity(city);
    //}
}
