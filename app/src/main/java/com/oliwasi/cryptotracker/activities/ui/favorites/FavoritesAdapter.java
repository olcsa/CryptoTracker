package com.oliwasi.cryptotracker.activities.ui.favorites;

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

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private List<CurrencyPair> currencyPairs;
    private FavoritesViewModel viewModel;

    public FavoritesAdapter(List<CurrencyPair> currencyPairs, FavoritesViewModel viewModel){
        this.currencyPairs = currencyPairs;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_favorite, parent, false);

        // Return a new holder instance
        FavoritesAdapter.ViewHolder viewHolder = new FavoritesAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyPair pair = currencyPairs.get(position);

        holder.pairText.setText(pair.getPrimaryCurrency() + " " + pair.getSecondaryCurrency());

        Double price = Double.parseDouble(pair.getLast());
        holder.priceText.setText(FormatHelper(price));

        Double highest = Double.parseDouble(pair.getHighestBid());
        holder.highestText.setText(FormatHelper(highest));

        Double lowest = Double.parseDouble(pair.getLowestAsk());
        holder.lowestText.setText(FormatHelper(lowest));

        Double change = Double.parseDouble(pair.getPercentChange()) * 100.0;
        holder.changeText.setText(String.format("%.2f", change) + " %");

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.deleteFavorite(pair);
            }
        });
    }

    private String FormatHelper(double d){
        if (d > 1){
            return String.format("%.3f", d);
        }
        else {
            return String.format("%.8f", d);
        }
    }

    @Override
    public int getItemCount() {
        return currencyPairs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView pairText;
        public TextView priceText;
        public TextView highestText;
        public TextView lowestText;
        public TextView changeText;
        public Button deleteButton;

        public ViewHolder(View itemView){
            super(itemView);

            pairText = (TextView) itemView.findViewById(R.id.favorite_pairName);
            priceText = (TextView) itemView.findViewById(R.id.favorite_price);
            highestText = (TextView) itemView.findViewById(R.id.favorite_highest);
            lowestText = (TextView) itemView.findViewById(R.id.favorite_lowest);
            changeText = (TextView) itemView.findViewById(R.id.favorite_change);
            deleteButton = (Button) itemView.findViewById(R.id.button_deleteFavorite);
        }
    }
}
