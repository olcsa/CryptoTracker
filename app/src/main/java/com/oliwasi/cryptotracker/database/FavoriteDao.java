package com.oliwasi.cryptotracker.database;

import com.oliwasi.cryptotracker.model.Favorite;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    List<Favorite> getAll();

    @Insert
    void insertAll(Favorite... favorites);

    @Delete
    void delete(Favorite favorite);
}
