package com.example.sportinside;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportinside.data.TeamByName.entities.TeamEntity;
import com.example.sportinside.data.TeamByName.entities.Teams;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {
    List<TeamEntity> data;
    public TeamAdapter(List<TeamEntity> data){
        this.data=data;
    }

    public void changeData(List<TeamEntity> data){
        this.data = data;
        notifyDataSetChanged();
    }

    class TeamHolder extends RecyclerView.ViewHolder{
        private ImageView wthrImg;
        private TextView formedYear;
        private TextView strTeam;
        private TextView strSport;
        private TextView strCountry;
        private TextView strLeague;
        private TextView strKeywords;
        private TextView strStadium;
        private TextView strDescriptionEN;
        private TextView strTeamBadge;
        private TextView strTwitter;
        private TextView strInstagram;
        public TeamHolder(View view){
            super(view);
            formedYear = view.findViewById(R.id.formedYear);
            strTeam = view.findViewById(R.id.strTeam);
            strSport = view.findViewById(R.id.strSport);
            strCountry = view.findViewById(R.id.strCountry);
            strLeague = view.findViewById(R.id.strLeague);
            strKeywords = view.findViewById(R.id.strKeywords);
            strStadium = view.findViewById(R.id.strStadium);
            strDescriptionEN = view.findViewById(R.id.descr);
            strTwitter = view.findViewById(R.id.strTwitter);
            strInstagram = view.findViewById(R.id.strInstagram);
            //descr=view.findViewById(R.id.descr);
        }
        public void setData(String info){
            formedYear.setText(info);
            //descr.setText(info);
        }
    }

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.team_item,viewGroup,false);
        return new TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.TeamHolder holder, int i) {

        holder.formedYear.setText(""+data.get(i).formedYear);
        holder.strTeam.setText(""+data.get(i).strTeam);
        holder.strSport.setText(""+data.get(i).strSport);
        holder.strCountry.setText(""+data.get(i).strCountry);
        holder.strLeague.setText(""+data.get(i).strLeague);
        holder.strKeywords.setText(""+data.get(i).strKeywords);
        holder.strStadium.setText(""+data.get(i).strStadium);
        holder.strDescriptionEN.setText(""+data.get(i).strDescriptionEN);
        holder.strTwitter.setText(""+data.get(i).strTwitter);
        holder.strInstagram.setText(""+data.get(i).strInstagram);

    }

    @Override
    public int getItemCount() {
        if(data!=null) {
            return data.size();
        } else {
            return 0;
        }
    }
}
