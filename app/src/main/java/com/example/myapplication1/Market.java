package com.example.myapplication1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.myapplication1.RecycleViewButtons.ButtonAdapter;
import com.example.myapplication1.RecycleViewButtons.ButtonItem;

import java.util.ArrayList;

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
    ArrayList<ButtonItem> states = new ArrayList<ButtonItem>();
    private static Market instance;
    private boolean flag = true;


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

    public static Market getInstance() {
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        instance = this;

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

        RecyclerView recyclerView = rootView.findViewById(R.id.button_item);
        if(flag) {
            flag = false;
            setInitialData();
        }


        ButtonAdapter buttonAdapter = new ButtonAdapter(getContext(),states);
        recyclerView.setAdapter(buttonAdapter);

        return rootView;
    }

    public void changeFragment(Fragment first){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fr, first);
        ft.commit();
    }

    public void setInitialData(){
        states.add(new ButtonItem("Броня", getContext()));
        states.add(new ButtonItem("Аксесуары", getContext()));
        states.add(new ButtonItem("Артефакты", getContext()));
    }
}

