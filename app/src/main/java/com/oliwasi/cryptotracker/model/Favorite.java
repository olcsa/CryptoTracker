package com.oliwasi.cryptotracker.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favorite {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "primary_currency")
    public String primaryCurrency;

    @ColumnInfo(name = "secondary_currency")
    public String secondaryCurrency;
}
