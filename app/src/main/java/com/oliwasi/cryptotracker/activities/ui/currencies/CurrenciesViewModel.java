package com.oliwasi.cryptotracker.activities.ui.currencies;

import com.oliwasi.cryptotracker.model.Currency;
import com.oliwasi.cryptotracker.model.CurrencyList;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class CurrenciesViewModel extends ViewModel {

    CryptoRepository repository;

    public CurrenciesAdapter adapter;

    private ArrayList<Currency> currencies = new ArrayList<>();

    @Inject
    public CurrenciesViewModel() {
        adapter = new CurrenciesAdapter(currencies);
    }

    public void setRepository(CryptoRepository repository){
        this.repository = repository;
    }

    public void loadCurrencies() {
        Disposable d = repository.getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyList>() {
                    @Override
                    public void accept(CurrencyList currencyList) throws Exception {
                        for (String key: currencyList.keySet()) {
                            currencies.add(currencyList.get(key));
                            adapter.notifyItemInserted(currencies.size() - 1);
                        }
                    }
                });
    }

}