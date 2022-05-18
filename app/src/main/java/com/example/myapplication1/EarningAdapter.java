package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EarningAdapter extends RecyclerView.Adapter<EarningAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<EarningItem> states;

    public EarningAdapter(Context context, List<EarningItem> states) {
        this.inflater = LayoutInflater.from(context);
        this.states = states;
    }

    @Override
    public EarningAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.earnings_item, parent, false);
        return new EarningAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EarningAdapter.ViewHolder holder, int position) {
        EarningItem earningItem = states.get(position);
        holder.imageView.setImageResource(earningItem.getImg());
        holder.text_vlojenia.setText(earningItem.getText_Vlojenia());
        holder.text_earn.setText(earningItem.getText_earn());
        holder.text_button.setText(earningItem.getText_button());
        holder.text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Earnings.getInstance().changeFragment(earningItem.getFragment());
            }
        });
    }


    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView text_earn,text_vlojenia;
        final Button text_button;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.img);
            text_vlojenia = view.findViewById(R.id.Vlojenia);;
            text_earn = view.findViewById(R.id.Earn);
            text_button = view.findViewById(R.id.Transportation);
        }
    }
}

