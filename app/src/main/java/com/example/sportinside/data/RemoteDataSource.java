package com.example.sportinside.data;

import android.util.Log;


import com.example.sportinside.TeamService;
import com.example.sportinside.data.TeamByName.entities.Teams;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteDataSource {

    private TeamService teamService;

    public RemoteDataSource(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                //.client(client)
                .build();
        teamService = retrofit.create(TeamService.class);
    }

    public Teams getTeams(String teamName){
        Log.e("Remote","Start getTeams");
        Call<Teams> call = teamService.getTeamByName(teamName);
        Log.e("Remote","After call");
        //try {
            Log.e("Remote","1Try: " + call.request().url().toString());
            call.enqueue(new Callback<Teams>() {
                @Override
                public void onResponse(Call<Teams> call, Response<Teams> response) {
                    if (response.isSuccessful()) {
                        Log.e("Remote","Ok");
                        Log.e("Remote", "Resp: " + response.body());

                    }
                    else {
                        Log.e("Remote",""+response.code());
                    }
                }

                @Override
                public void onFailure(Call<Teams> call, Throwable t) {
                    Log.e("Remote", "Ex: " + t.toString());
                }
            });
            Log.e("Remote","Try");

//        }catch(IOException ioex){
//                Log.e("Remote",""+ioex);
//
//            //return null
//        }
        Log.e("Remote","NeProshlo");
        return null;
    }

}
