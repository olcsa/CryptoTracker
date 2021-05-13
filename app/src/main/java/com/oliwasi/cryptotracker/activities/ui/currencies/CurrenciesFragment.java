package com.oliwasi.cryptotracker.activities.ui.currencies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import javax.inject.Inject;

@AndroidEntryPoint
public class CurrenciesFragment extends Fragment {

    @Inject
    CryptoRepository repository;

    private CurrenciesViewModel currenciesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        currenciesViewModel =
                new ViewModelProvider(this).get(CurrenciesViewModel.class);
        currenciesViewModel.setRepository(repository);
        View root = inflater.inflate(R.layout.fragment_currencies, container, false);

        RecyclerView rvCurrencies = (RecyclerView) root.findViewById(R.id.rvCurrencies);
        rvCurrencies.setLayoutManager(new LinearLayoutManager(root.getContext()));
        rvCurrencies.setHasFixedSize(true);
        rvCurrencies.setAdapter(currenciesViewModel.adapter);

        currenciesViewModel.loadCurrencies();

        return root;
    }
}