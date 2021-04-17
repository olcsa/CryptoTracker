package com.oliwasi.cryptotracker;

import com.oliwasi.cryptotracker.data.Currency;

import javax.inject.Inject;

public class CurrencyPresenter {
    private Currency currency;
    private View view;

    @Inject
    public CurrencyPresenter(){}

    public void loadCurrency(Currency currency){
        //TODO
        view.updateCurrency(currency);
    }

    public void AddToFavorites(){

    }

    public interface View{
        void updateCurrency(Currency currency);
    }
}
