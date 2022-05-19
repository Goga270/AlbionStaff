package com.example.myapplication1.RecycleViewMarket;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.MVVM.views.second_market;
import com.example.myapplication1.MVVM.views.third_market;
import com.example.myapplication1.R;

import java.util.List;
import com.example.myapplication1.DI.serviceLocator;
import com.example.myapplication1.MVVM.repositories.jsonWork;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<MarketItem> states;
    private Fragment fragment;
    private jsonWork repository = serviceLocator.getServiceLocator().getRepository();

    public StateAdapter(Context context, List<MarketItem> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.component_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        MarketItem state = states.get(position);
        holder.imgView.setImageResource(state.getImg());
        //holder.imgView.setImageURI(state.getImage());
        //holder.imgView.setImageBitmap(state.getBitmap());
        holder.nameView.setText(repository.getName(state.getName()));
        holder.tierView.setText(state.getTier());
        holder.charsView.setText(state.getChars());
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new third_market();
                Bundle bundle = new Bundle();
                bundle.putString("ITEM", state.getName());
                fragment.setArguments(bundle);
                second_market.getInstance().changeFragment(fragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imgView;
        final TextView nameView, tierView, charsView;
        ViewHolder(View view){
            super(view);
            imgView = view.findViewById(R.id.img);
            nameView = view.findViewById(R.id.name);
            tierView = view.findViewById(R.id.tier);
            charsView = view.findViewById(R.id.chars);
        }
    }
}