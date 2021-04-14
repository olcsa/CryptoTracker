package com.oliwasi.cryptotracker.activities.ui.currencies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrenciesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CurrenciesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}