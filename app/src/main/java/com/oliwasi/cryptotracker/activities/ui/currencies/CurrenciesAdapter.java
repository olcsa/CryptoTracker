package com.oliwasi.cryptotracker.activities.ui.currencies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.oliwasi.cryptotracker.R;
import com.oliwasi.cryptotracker.activities.CurrencyActivity;
import com.oliwasi.cryptotracker.model.Currency;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesAdapter.ViewHolder> {

    private List<Currency> currencies;

    public CurrenciesAdapter(List<Currency> currencies){
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_currency, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrenciesAdapter.ViewHolder holder, int position) {
        Currency currency = currencies.get(position);

        TextView textView = holder.currencyNameText;
        textView.setText(currency.getName());
        Button button = holder.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CurrencyActivity.class);
                intent.putExtra("currency", currency);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyNameText;
        public Button button;

        public ViewHolder(View itemView){
            super(itemView);

            currencyNameText = (TextView) itemView.findViewById(R.id.currency_name);
            button = (Button) itemView.findViewById(R.id.currency_button);
        }
    }
}
