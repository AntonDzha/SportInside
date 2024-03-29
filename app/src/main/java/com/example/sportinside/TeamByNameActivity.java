package com.example.sportinside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sportinside.data.TeamByName.entities.TeamEntity;

import java.util.ArrayList;
import java.util.List;

public class TeamByNameActivity extends AppCompatActivity implements Observer<List<TeamEntity>> {
    TextView teamName;
    LiveData<List<TeamEntity>> teamData;
    private TeamAdapter adapter;
    private RecyclerView recyclerView;
    private List<TeamEntity>team0;
    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_by_name);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        String Team = getIntent().getStringExtra("TeamName");
        teamName = (TextView)findViewById(R.id.teamName);
        teamName.setText(Team);
        //teamData = new MutableLiveData<>();

        team0 = new ArrayList<>();
        //adapter = new TeamAdapter(team0);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        repository=((SportApp)getApplication()).getRepository();
        mainViewModel.loadData(repository,Team);

        //mainViewModel.loadData(this,Team);

        teamData = mainViewModel.getTeamData();
        teamData.observe(this,this);
        Log.i("onStart","Observe" );
        // создаем адаптер
        adapter = new TeamAdapter(null);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onChanged(List<TeamEntity> root) {
        Log.i("Root size","" + root.size());

        //adapter.changeData(root);
        if /*(root != null)&&*/(!root.isEmpty()) {
            adapter.changeData(root);
        }
    }

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }
}
