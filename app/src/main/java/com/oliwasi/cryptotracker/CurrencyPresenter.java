package com.oliwasi.cryptotracker;

import com.oliwasi.cryptotracker.activities.CurrencyPairsAdapter;
import com.oliwasi.cryptotracker.model.Currency;
import com.oliwasi.cryptotracker.model.CurrencyPair;
import com.oliwasi.cryptotracker.model.CurrencyPairList;
import com.oliwasi.cryptotracker.model.Favorite;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CurrencyPresenter {
    private Currency currency;
    private View view;

    private CryptoRepository repository;

    public CurrencyPairsAdapter adapter;

    private final ArrayList<CurrencyPair> currencyPairs = new ArrayList<>();

    @Inject
    public CurrencyPresenter(){
        adapter = new CurrencyPairsAdapter(currencyPairs, this);
    }

    public void setRepository(CryptoRepository repository){
        this.repository = repository;
    }

    public void loadCurrency(Currency currency){
        //TODO
        view.updateCurrency(currency);
    }

    public void loadCurrencyPairs(){
        Disposable d = repository.getCurrencyPairs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyPairList>() {
                    @Override
                    public void accept(CurrencyPairList pairList) throws Exception {
                        for (String key: pairList.keySet()) {
                            String[] splited = key.split("_");

                            if (splited[0].equals(currency.getShortName()) || splited[1].equals(currency.getShortName())){
                                CurrencyPair pair = pairList.get(key);
                                pair.setPrimaryCurrency(splited[0]);
                                pair.setSecondaryCurrency(splited[1]);
                                currencyPairs.add(pair);

                                adapter.notifyItemInserted(currencyPairs.size() - 1);
                            }
                        }
                    }
                });
    }

    public void AddToFavorites(CurrencyPair pair){
        Favorite favorite = new Favorite();
        favorite.id = pair.getId();
        favorite.primaryCurrency = pair.getPrimaryCurrency();
        favorite.secondaryCurrency = pair.getSecondaryCurrency();
        //repository.insertFavorite(favorite);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public interface View{
        void updateCurrency(Currency currency);
    }
}
