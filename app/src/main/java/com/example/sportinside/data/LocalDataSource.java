package com.example.sportinside.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.sportinside.data.TeamByName.TeamDB;
import com.example.sportinside.data.TeamByName.entities.Team;
import com.example.sportinside.data.TeamByName.entities.TeamEntity;
import com.example.sportinside.data.TeamByName.entities.Teams;

import java.util.ArrayList;
import java.util.List;


public class LocalDataSource {
    final TeamDB db;
    private MutableLiveData<List<TeamEntity>> teamData;

    public LocalDataSource(Context context){
        db= Room.databaseBuilder(context, TeamDB.class, "team").build();
    }

    public void storeTeams(Teams teams){
        List<Team> lteams = teams.getTeams();
        List<TeamEntity> teamList = new ArrayList<>();
        db.teamDao().clearDB();
        for(int i = 0; i < lteams.size(); i++){
            String formedYear = lteams.get(i).getIntFormedYear();
            String strTeamBadge = lteams.get(i).getStrTeamBadge();

            String strTeam = lteams.get(i).getStrTeam();
            String strSport = lteams.get(i).getStrSport();
            String strCountry = lteams.get(i).getStrCountry();
            String strLeague = lteams.get(i).getStrLeague();
            String strKeywords = lteams.get(i).getStrKeywords();
            String strStadium = lteams.get(i).getStrStadium();
            String strDescriptionEN = lteams.get(i).getStrDescriptionEN();
            String strTwitter = lteams.get(i).getStrTwitter();
            String strInstagram = lteams.get(i).getStrInstagram();
            int idTeam = i;
            TeamEntity teamEntity = new TeamEntity();
            teamEntity.idTeam = idTeam;
            teamEntity.formedYear = formedYear;
            teamEntity.strTeamBadge = strTeamBadge;
            teamEntity.strTeam = strTeam;
            teamEntity.strSport = strSport;
            teamEntity.strCountry = strCountry;
            teamEntity.strLeague = strLeague;
            teamEntity.strKeywords = strKeywords;
            teamEntity.strStadium = strStadium;
            teamEntity.strDescriptionEN = strDescriptionEN;
            teamEntity.strTwitter = strTwitter;
            teamEntity.strInstagram = strInstagram;
            db.teamDao().insertTeam(teamEntity);
            teamList.add(teamEntity);
            //teamData.postValue(teamEntity);
        }
        //teamData.postValue(teamList);
    }


    public LiveData<List<TeamEntity>> getTeam(){
        return db.teamDao().getTeam();

    }
}
