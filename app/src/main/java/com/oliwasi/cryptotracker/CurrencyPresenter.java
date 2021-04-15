package com.oliwasi.cryptotracker;

import com.oliwasi.cryptotracker.data.Currency;

public class CurrencyPresenter {
    private Currency currency;
    private View view;

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
