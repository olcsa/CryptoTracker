package com.oliwasi.cryptotracker.database;

import com.oliwasi.cryptotracker.model.Favorite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();
}
