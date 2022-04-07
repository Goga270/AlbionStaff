package com.example.myapplication1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link second_market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class second_market extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<MarketItem> states = new ArrayList<MarketItem>();

    public second_market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment second_market.
     */
    // TODO: Rename and change types and number of parameters
    public static second_market newInstance(String param1, String param2) {
        second_market fragment = new second_market();
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

            mParam1 = getArguments().getString("ID");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_second_market, container, false);
       RecyclerView recyclerView = rootView.findViewById(R.id.list);
       setInitialData();
       StateAdapter stateAdapter = new StateAdapter(getContext(),states);
       recyclerView.setAdapter(stateAdapter);
       return rootView;
    }

    private void setInitialData(){

        states.add(new MarketItem ( R.drawable.cloth_armor_tier2_char0, "Тканевая броня", "Тир: 2", "Чар: 0"));
        states.add(new MarketItem (R.drawable.cloth_armor_tier3_char0, "Тканевая броня", "Тир: 3", "Чар: 0"));
    }
}