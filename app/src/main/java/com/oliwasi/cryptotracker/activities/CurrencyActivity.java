package com.oliwasi.cryptotracker.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.oliwasi.cryptotracker.CurrencyPresenter;
import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.model.Currency;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import javax.inject.Inject;

@AndroidEntryPoint
public class CurrencyActivity extends AppCompatActivity implements CurrencyPresenter.View {

    private TextView currency_fullName;
    private TextView currency_shortName;
    private TextView currency_trxFee;

    @Inject
    CurrencyPresenter presenter;

    @Inject
    CryptoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Intent intent = getIntent();
        Currency currency = (Currency) intent.getSerializableExtra("currency");

        presenter.setRepository(repository);
        presenter.setCurrency(currency);

        initView();
        updateCurrency(currency);

        RecyclerView rvCurrencyPairs = (RecyclerView) findViewById(R.id.rvCurrencyPairs);
        rvCurrencyPairs.setLayoutManager(new LinearLayoutManager(this));
        rvCurrencyPairs.setHasFixedSize(true);
        rvCurrencyPairs.setAdapter(presenter.adapter);

        presenter.loadCurrencyPairs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.crash_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.crash_menu_item:
                throw new RuntimeException("Crashlytics test crash!");
        }
        return true;
    }

    private void initView(){
        currency_fullName = (TextView) findViewById(R.id.currencyFullName);
        currency_shortName = (TextView) findViewById(R.id.currency_shortName);
        currency_trxFee = (TextView) findViewById(R.id.currency_trxfee);
    }

    @Override
    public void updateCurrency(Currency currency) {
        currency_fullName.setText(currency.getName());
        currency_shortName.setText(currency.getShortName());
        currency_trxFee.setText(currency.getTxFee().toString());
    }
}