package com.oliwasi.cryptotracker.activities.ui.currencies;

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
import dagger.hilt.android.AndroidEntryPoint;

import com.oliwasi.cryptotracker.R;

@AndroidEntryPoint
public class CurrenciesFragment extends Fragment {

    private CurrenciesViewModel currenciesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        currenciesViewModel =
                new ViewModelProvider(this).get(CurrenciesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_currencies, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        currenciesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}