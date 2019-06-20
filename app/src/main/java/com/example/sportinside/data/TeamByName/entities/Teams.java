package com.example.sportinside.data.TeamByName.entities;

import java.util.List;

public class Teams {
    private List<Team> teams;

    public void setTeams(List<Team> teams){
        this.teams = teams;
    }
    public List<Team> getTeams(){
        return this.teams;
    }
}
