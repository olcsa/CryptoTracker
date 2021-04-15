package com.oliwasi.cryptotracker.activities.ui.favorites;

import com.oliwasi.cryptotracker.data.CurrencyPair;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<CurrencyPair>> currencyPairs;

    public FavoritesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Favorites view");
    }

    public LiveData<List<CurrencyPair>> getCurrencyPairs() {
        return currencyPairs;
    }

    public LiveData<String> getText() {
        return mText;
    }
}