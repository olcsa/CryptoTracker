package com.oliwasi.cryptotracker.activities.ui.currencies;

import com.oliwasi.cryptotracker.data.Currency;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrenciesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Currency>> currencies;

    public CurrenciesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Currencies view");
    }

    public LiveData<List<Currency>> getCurrencies() {return currencies;}

    public LiveData<String> getText() {
        return mText;
    }
}