package com.oliwasi.cryptotracker.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.oliwasi.cryptotracker.CurrencyPresenter;
import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.model.CurrencyPair;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrencyPairsAdapter extends RecyclerView.Adapter<CurrencyPairsAdapter.ViewHolder> {

    private List<CurrencyPair> currencyPairs;
    private CurrencyPresenter presenter;

    private FirebaseAnalytics mFirebaseAnalytics;

    public CurrencyPairsAdapter(List<CurrencyPair> currencyPairs, CurrencyPresenter presenter){
        this.currencyPairs = currencyPairs;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_currencypair, parent, false);

        // Return a new holder instance
        CurrencyPairsAdapter.ViewHolder viewHolder = new CurrencyPairsAdapter.ViewHolder(contactView);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyPair pair = currencyPairs.get(position);

        holder.currencyPairText.setText(pair.getPrimaryCurrency() + " - " + pair.getSecondaryCurrency());
        holder.priceText.setText(pair.getLast());
        holder.addFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.AddToFavorites(pair);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, pair.getPrimaryCurrency() + "_" + pair.getSecondaryCurrency());
                mFirebaseAnalytics.logEvent("add_favorite", bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return currencyPairs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyPairText;
        public TextView priceText;
        public Button addFavoritesButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            currencyPairText = (TextView) itemView.findViewById(R.id.currencyPair_name);
            priceText = (TextView) itemView.findViewById(R.id.favorite_lowest);
            addFavoritesButton = (Button) itemView.findViewById(R.id.button_deleteFavorite);
        }
    }
}
