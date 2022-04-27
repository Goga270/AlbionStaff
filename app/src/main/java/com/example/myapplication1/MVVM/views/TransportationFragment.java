package com.example.myapplication1.MVVM.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.MVVM.mv.TransportationViewModel;
import com.example.myapplication1.MVVM.repositories.jsonWork;
import com.example.myapplication1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransportationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransportationFragment extends Fragment {

    private String resource;
    private String tier;
    private String city_from;
    private String city_to;
    private int count;
    private TransportationViewModel viewModel;
    private jsonWork model;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransportationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransportationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransportationFragment newInstance(String param1, String param2) {
        TransportationFragment fragment = new TransportationFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(this).get(TransportationViewModel.class);
        model = new ViewModelProvider(this).get(jsonWork.class);


        View view = inflater.inflate(R.layout.fragment_transportation, container, false);
        Spinner spinner_resources = view.findViewById(R.id.Spinner_Resources);
        Spinner spinner_tier = view.findViewById(R.id.Spinner_Tier);
        Spinner spinner_city_from = view.findViewById(R.id.Spinner_City_from);
        Spinner spinner_city_to = view.findViewById(R.id.Spinner_City_to);

        ArrayAdapter<CharSequence> adapter_spinner_resources = ArrayAdapter.createFromResource(getContext(),R.array.Resources, android.R.layout.simple_spinner_dropdown_item);
        adapter_spinner_resources.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_resources.setAdapter(adapter_spinner_resources);

        ArrayAdapter<CharSequence> adapter_spinner_tier = ArrayAdapter.createFromResource(getContext(),R.array.Tier,android.R.layout.simple_spinner_dropdown_item);
        adapter_spinner_tier.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tier.setAdapter(adapter_spinner_tier);

        ArrayAdapter<CharSequence> adapter_spinner_cities = ArrayAdapter.createFromResource(getContext(),R.array.Cities, android.R.layout.simple_spinner_dropdown_item);
        adapter_spinner_cities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_city_from.setAdapter(adapter_spinner_cities);
        spinner_city_to.setAdapter(adapter_spinner_cities);

       TextView earning = view.findViewById(R.id.money);
       TextView priceForOneCityFromText = view.findViewById(R.id.priceForOneCityFromText);
       TextView priceForOneCityToText = view.findViewById(R.id.priceForOneCityToText);
       TextView priceForCountCityFromText = view.findViewById(R.id.priceForCountCityFromText);
       TextView priceForCountCityToText = view.findViewById(R.id.priceForCountCityToText);
       TextView priceForOneCityFrom = view.findViewById(R.id.priceForOneCityFrom);
       TextView priceForOneCityTo = view.findViewById(R.id.priceForOneCityTo);
       TextView priceForCountCityFrom = view.findViewById(R.id.priceForCountCityFrom);
       TextView priceForCountCityTo = view.findViewById(R.id.priceForCountCityTo);

        EditText editText = view.findViewById(R.id.edit_Count);

        Button button = view.findViewById(R.id.Calculation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String count = editText.getText().toString();
                viewModel.CalculateEarn(spinner_resources.getSelectedItem().toString(),spinner_tier.getSelectedItem().toString(),count,spinner_city_from.getSelectedItem().toString(),spinner_city_to.getSelectedItem().toString());
            }
        });

        viewModel.getEarn().observe(getViewLifecycleOwner(), earn->{
            earning.setText(earn);
        });

        viewModel.getPriceForOneCityFrom().observe(getViewLifecycleOwner(), price->{

            priceForOneCityFromText.setText("Цена за 1 еденицу в городе " + spinner_city_from.getSelectedItem().toString());

            priceForOneCityFrom.setText(price.toString());
        });

        viewModel.getPriceForOneCityTo().observe(getViewLifecycleOwner(), price->{

            priceForOneCityToText.setText("Цена за 1 еденицу в городе " + spinner_city_to.getSelectedItem().toString());

            priceForOneCityTo.setText(price.toString());
        });

        viewModel.getPriceForCountCityFrom().observe(getViewLifecycleOwner(), price->{
            priceForCountCityFromText.setText("Цена за x едениц в городе " + spinner_city_from.getSelectedItem().toString());
            priceForCountCityFrom.setText(price);
        });

        viewModel.getPriceForCountCityTo().observe(getViewLifecycleOwner(), price->{
            priceForCountCityToText.setText("Цена за x едениц в городе " + spinner_city_to.getSelectedItem().toString());
            priceForCountCityTo.setText(price);
        });

        model.getEarn().observe(getViewLifecycleOwner(), earn->{
            earning.setText(earn);
        });

        return view;
    }
}