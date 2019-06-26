package com.example.sportinside.data.TeamByName;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportinside.data.TeamByName.entities.TeamEntity;

import java.util.List;

@Dao
public interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertTeam(TeamEntity teamEntity);

    @Update
    public void update(TeamEntity teamEntity);

    @Delete
    public void delete(TeamEntity teamEntity);

    @Query("DELETE FROM team")
    public void clearDB();
    @Query("SELECT * FROM team")
    LiveData<List<TeamEntity>> getTeam();
}
