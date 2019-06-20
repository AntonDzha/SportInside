package com.example.sportinside.data.TeamByName;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sportinside.data.TeamByName.entities.TeamEntity;

@Database(entities = {TeamEntity.class},version = 1)
public abstract class TeamDB extends RoomDatabase {
    public abstract TeamDao teamDao();
}
