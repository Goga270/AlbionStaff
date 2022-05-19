package com.example.myapplication1.RecycleViewButtons;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.MVVM.views.Market;
import com.example.myapplication1.R;
import com.example.myapplication1.MVVM.views.second_market;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<ButtonItem> states;
    private Fragment fragment = null;
    private Fragment fragment2 = null;

    public ButtonAdapter(Context context, List<ButtonItem> states) {
        this.inflater = LayoutInflater.from(context);
        this.states = states;
    }

    @Override
    public ButtonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.button_item, parent, false);
        return new ButtonAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonAdapter.ViewHolder holder, int position) {
        ButtonItem elem = states.get(position);
        System.out.println(elem.getName());
        holder.button.setText(elem.getName());
        String[] strings = elem.getPopUpMenuCatalog();
        holder.button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(elem.getContext(),holder.button);
                        for(int i=0;i<strings.length;i++){
                            popupMenu.getMenu().add(strings[i]);
                        }
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {

                                String title = (String) menuItem.getTitle();
                                Bundle bundle = new Bundle();
                                fragment = new second_market();

                                bundle.putString("ID", title);
                                System.out.println(title);
                                fragment.setArguments(bundle);
                                Market.getInstance().changeFragment(fragment);
                                /*for (int i=0;i<strings.length;i++){
                                    if(title == strings[i]){
                                        bundle.putString("ID", title);
                                        break;
                                    }
                                }*/
                                //FragmentTransaction ft = (MainActivity.getINSTANCE()).getSupportFragmentManager().beginTransaction();



                                /*FragmentManager fragmentManager = MainActivity.getINSTANCE().getSupportFragmentManager();
                                FragmentTransaction ft = fragmentManager.beginTransaction() ;
                                ft.addToBackStack(null);
                                ft.replace(R.id.fr, fragment);
                                ft.commit();*/

                                /*new MarketButton().changeFrag(fragment);*/

                                return true;
                            }
                        });
                        popupMenu.show();
                    }
                }
        );
    }


    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final Button button;
        ViewHolder(View view){
            super(view);
            button = view.findViewById(R.id.Button);
        }
    }

}
