package com.oliwasi.cryptotracker.activities.ui.favorites;

import android.util.Log;

import com.oliwasi.cryptotracker.activities.CurrencyPairsAdapter;
import com.oliwasi.cryptotracker.model.CurrencyPair;
import com.oliwasi.cryptotracker.model.CurrencyPairList;
import com.oliwasi.cryptotracker.model.Favorite;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
public class FavoritesViewModel extends ViewModel {

    CryptoRepository repository;

    public FavoritesAdapter adapter;

    private final ArrayList<CurrencyPair> currencyPairs = new ArrayList<>();

    @Inject
    public FavoritesViewModel() {
        adapter = new FavoritesAdapter(currencyPairs, this);
    }

    public void setRepository(CryptoRepository repository){
        this.repository = repository;
    }

    public void loadFavorites(){
        List<Favorite> favorites = repository.getFavorites();

        if (favorites.size() == 0){
            return;
        }

        Disposable d = repository.getCurrencyPairs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyPairList>() {
                    @Override
                    public void accept(CurrencyPairList pairList) throws Exception {
                        for (Favorite favorite: favorites) {
                            String key = favorite.primaryCurrency + "_" + favorite.secondaryCurrency;
                            CurrencyPair pair = pairList.get(key);
                            pair.setPrimaryCurrency(favorite.primaryCurrency);
                            pair.setSecondaryCurrency(favorite.secondaryCurrency);
                            currencyPairs.add(pair);

                            adapter.notifyItemInserted(currencyPairs.size() - 1);
                        }
                    }
                });
    }

    public void deleteFavorite(CurrencyPair pair){
        Favorite favorite = new Favorite();
        favorite.id = pair.getId();
        favorite.primaryCurrency = pair.getPrimaryCurrency();
        favorite.secondaryCurrency = pair.getSecondaryCurrency();

        repository.deleteFavorite(favorite);

        int i = currencyPairs.indexOf(pair);
        currencyPairs.remove(pair);

        adapter.notifyItemRemoved(i);
    }

}