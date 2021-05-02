package com.oliwasi.cryptotracker.activities.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;

import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.repository.CryptoRepository;

import javax.inject.Inject;

@AndroidEntryPoint
public class FavoritesFragment extends Fragment {

    @Inject
    CryptoRepository repository;

    private FavoritesViewModel favoritesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);
        favoritesViewModel.setRepository(repository);

        View root = inflater.inflate(R.layout.fragment_favorites, container, false);

        RecyclerView rvCurrencies = (RecyclerView) root.findViewById(R.id.rvFavorites);
        rvCurrencies.setLayoutManager(new LinearLayoutManager(root.getContext()));
        rvCurrencies.setHasFixedSize(true);
        rvCurrencies.setAdapter(favoritesViewModel.adapter);

        favoritesViewModel.loadFavorites();

        return root;
    }
}