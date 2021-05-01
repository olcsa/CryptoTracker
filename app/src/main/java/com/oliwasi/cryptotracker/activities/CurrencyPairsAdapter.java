package com.oliwasi.cryptotracker.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.model.CurrencyPair;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrencyPairsAdapter extends RecyclerView.Adapter<CurrencyPairsAdapter.ViewHolder> {

    private List<CurrencyPair> currencyPairs;

    public CurrencyPairsAdapter(List<CurrencyPair> currencyPairs){
        this.currencyPairs = currencyPairs;
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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyPair pair = currencyPairs.get(position);

        holder.currencyPairText.setText(pair.getPrimaryCurrency() + " - " + pair.getSecondaryCurrency());
        holder.priceText.setText(pair.getLast());
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
            priceText = (TextView) itemView.findViewById(R.id.currencyPair_price);
            addFavoritesButton = (Button) itemView.findViewById(R.id.button_addToFavorites);
        }
    }
}
