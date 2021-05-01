package com.oliwasi.cryptotracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.oliwasi.cryptotracker.CurrencyPresenter;
import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.data.Currency;

import javax.inject.Inject;

@AndroidEntryPoint
public class CurrencyActivity extends AppCompatActivity implements CurrencyPresenter.View {

    private TextView currency_fullName;
    private TextView currency_shortName;
    private TextView currency_trxFee;

    @Inject
    CurrencyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Intent intent = getIntent();
        com.oliwasi.cryptotracker.model.Currency c = (com.oliwasi.cryptotracker.model.Currency) intent.getSerializableExtra("currency");

        currency_fullName = (TextView) findViewById(R.id.currencyFullName);
        currency_shortName = (TextView) findViewById(R.id.currency_shortName);
        currency_trxFee = (TextView) findViewById(R.id.currency_trxfee);

        currency_fullName.setText(c.getName());
        currency_shortName.setText(c.getShortName());
        currency_trxFee.setText(c.getTxFee().toString());
    }

    @Override
    public void updateCurrency(Currency currency) {

    }
}