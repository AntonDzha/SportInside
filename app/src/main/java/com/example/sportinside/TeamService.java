package com.example.sportinside;

import com.example.sportinside.data.TeamByName.entities.Teams;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamService {
    @GET("/api/v1/json/1/searchteams.php")
    Call<Teams> getTeamByName(@Query("t") String t);

}
