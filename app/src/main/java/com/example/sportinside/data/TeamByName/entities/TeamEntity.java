package com.example.sportinside.data.TeamByName.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "team")
public class TeamEntity {
    @PrimaryKey
    public Integer idTeam;

    public String strTeam;
    public String strSport;
    public String strCountry;
    public String strLeague;
    public String strKeywords;
    public String strStadium;
    public String formedYear;
    public String strDescriptionEN;
    public String strTeamBadge;
    public String strTwitter;
    public String strInstagram;
}
