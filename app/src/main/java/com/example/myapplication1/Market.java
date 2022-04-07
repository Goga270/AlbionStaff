package com.example.myapplication1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Market extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String[] f = { "Ybrbnf ", "Seva" };
    private Fragment fragment=null;

    public Market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Market.
     */
    // TODO: Rename and change types and number of parameters
    public static Market newInstance(String param1, String param2) {
        Market fragment = new Market();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        /*Spinner spinner = (Spinner) getView().findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,f);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_market, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,f);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button b = rootView.findViewById(R.id.Button_accesoires);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(),b);
                popupMenu.getMenuInflater().inflate(R.menu.market_menu_armor, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        TextView textView= rootView.findViewById(R.id.test);
                        textView.setText(menuItem.getTitle());
                        Bundle bundle = new Bundle();
                        int id=menuItem.getItemId();
                        switch (id){
                            case R.id.cloth_armor:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "cloth_armor");
                                fragment.setArguments(bundle);

                            case R.id.cloth_helmet:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "cloth_helmet");
                                fragment.setArguments(bundle);

                            case R.id.cloth_shoes:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "cloth_shoes");
                                fragment.setArguments(bundle);

                            case R.id.leather_armor:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "leather_armor");
                                fragment.setArguments(bundle);

                            case R.id.leather_helmet:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "leather_helmet");
                                fragment.setArguments(bundle);

                            case R.id.leather_shoes:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "leather_shoes");
                                fragment.setArguments(bundle);

                            case R.id.plate_armor:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "plate_armor");
                                fragment.setArguments(bundle);

                            case R.id.plate_helmet:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "plate_helmet");
                                fragment.setArguments(bundle);

                            case R.id.plate_shoes:
                                fragment = new second_market();
                                bundle = new Bundle();
                                bundle.putString("ID", "plate_shoes");
                                fragment.setArguments(bundle);
                        }

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.addToBackStack(null);
                        ft.replace(R.id.fr, fragment);
                        ft.commit();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        return rootView;
    }
}