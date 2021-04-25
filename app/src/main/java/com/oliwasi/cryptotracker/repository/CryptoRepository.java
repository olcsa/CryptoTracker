package com.oliwasi.cryptotracker.repository;

import android.content.Context;

import com.oliwasi.cryptotracker.database.AppDatabase;
import com.oliwasi.cryptotracker.database.FavoriteDao;
import com.oliwasi.cryptotracker.model.CurrencyList;
import com.oliwasi.cryptotracker.model.CurrencyPairList;
import com.oliwasi.cryptotracker.model.Favorite;
import com.oliwasi.cryptotracker.network.PublicApi;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;
import io.reactivex.Observable;

public class CryptoRepository {

    PublicApi api;
    FavoriteDao dao;

    @Inject
    public CryptoRepository(PublicApi api, @ApplicationContext Context context){
        this.api = api;
        this.dao = AppDatabase.getDatabase(context).favoriteDao();
    }

    public Observable<CurrencyList> getCurrencies(){
        return api.returnCurrencies();
    }

    public Observable<CurrencyPairList> getCurrencyPairs(){
        return api.returnTicker();
    }

    public List<Favorite> getFavorites(){
        return dao.getAll();
    }

    public void insertFavorite(Favorite favorite){
        dao.insertAll(favorite);
    }

    public void deleteFavorite(Favorite favorite){
        dao.delete(favorite);
    }
}
