package com.oliwasi.cryptotracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

import android.os.Bundle;

import com.oliwasi.cryptotracker.CurrencyPresenter;
import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.data.Currency;

import javax.inject.Inject;

@AndroidEntryPoint
public class CurrencyActivity extends AppCompatActivity implements CurrencyPresenter.View {

    @Inject
    CurrencyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
    }

    @Override
    public void updateCurrency(Currency currency) {

    }
}